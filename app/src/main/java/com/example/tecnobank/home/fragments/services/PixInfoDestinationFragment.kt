package com.example.tecnobank.home.fragments.services

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.PixInfoDestinationFragmentBinding
import com.example.tecnobank.home.viewmodel.PixInfoDestinationViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class PixInfoDestinationFragment: Fragment() {

    private var _binding: PixInfoDestinationFragmentBinding? = null
    private val binding: PixInfoDestinationFragmentBinding get() = _binding!!
    private lateinit var viewModel: PixInfoDestinationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PixInfoDestinationFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(PixInfoDestinationViewModel::class.java)

        binding.toolbarPixInsertEmail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        binding.defaultEditText.addTextChangedListener {
            viewModel.changeDestinationEmailPix(binding.defaultEditText.text.toString())
        }

        viewModel.buttonColor.observe(viewLifecycleOwner,{
            if(it){
                paintButtonOn(binding.pixApplyEmail)
            }else{
                paintButtonOff(binding.pixApplyEmail)
            }
        })

        viewModel.goToDescriptionPix.observe(viewLifecycleOwner,{
            findNavController().navigate(
                PixInfoDestinationFragmentDirections
                    .actionPixInfoDestinationFragmentToPixDescriptionFragment(
                        it
                    )
            )
        })

        viewModel.emailErro.observe(viewLifecycleOwner,{
            AlertDialog.Builder(requireContext()).setTitle(it).setMessage("").show()
        })

        binding.pixApplyEmail.setOnClickListener {
            viewModel.onClickApplyInfoDestinationPix()
        }

    }

    private fun paintButtonOn(button: ExtendedFloatingActionButton) {
        with(button) {
            setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.blueTecnoBank))
            setTextColor(Color.WHITE)
            setStrokeColorResource(R.color.white)
        }
    }

    private fun paintButtonOff(button: ExtendedFloatingActionButton) {
        with(button) {
            setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gray_200))
            setTextColor(ContextCompat.getColor(requireContext(), R.color.gray_backgroud_invalid))
            setStrokeColorResource(R.color.white)
        }
    }
}
