package com.example.tecnobank.home.fragments.services

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onStart() {
        super.onStart()
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

        binding.pixApplyEmail.setOnClickListener {
            viewModel.onClickApplyInfoDestinationPix()
        }

    }

    private fun paintButtonOn(button: ExtendedFloatingActionButton) {
        with(button) {
            setBackgroundColor(Color.parseColor("#2270E3"))
            setTextColor(Color.parseColor("#FFFFFF"))
            setStrokeColorResource(R.color.white)
        }
    }

    private fun paintButtonOff(button: ExtendedFloatingActionButton) {
        with(button) {
            setBackgroundColor(Color.parseColor("#ABABAB"))
            setTextColor(Color.parseColor("#676767"))
            setStrokeColorResource(R.color.white)
        }
    }
}
