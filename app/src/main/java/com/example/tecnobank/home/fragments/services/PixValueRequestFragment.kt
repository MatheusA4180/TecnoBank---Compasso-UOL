package com.example.tecnobank.home.fragments.services

import android.graphics.Color
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tecnobank.R
import com.example.tecnobank.databinding.PixValueRequestFragmentBinding
import com.example.tecnobank.extension.MoneyTextMask
import com.example.tecnobank.home.viewmodel.PixValueRequestViewModel
import com.example.tecnobank.viewmodelfactory.ViewModelFactory
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class PixValueRequestFragment : Fragment() {

    private var _binding: PixValueRequestFragmentBinding? = null
    private val binding: PixValueRequestFragmentBinding get() = _binding!!
    private lateinit var viewModel: PixValueRequestViewModel
    private val args: PixValueRequestFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PixValueRequestFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(PixValueRequestViewModel::class.java)

        viewModel.getSaveBalanceValue()

        binding.editValue.addTextChangedListener(MoneyTextMask(binding.editValue));

        viewModel.balanceValue.observe(viewLifecycleOwner,{
            binding.balanceValue.text = it
        })

        binding.toolbarPixValue.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        binding.editValue.addTextChangedListener{
            viewModel.changeValuePix(it.toString())
        }

        viewModel.confirmationButtonEnabled.observe(viewLifecycleOwner,{
            if(it){
                paintButtonOn(binding.pixApplyValue)
            }else{
                paintButtonOff(binding.pixApplyValue)
            }
        })

        viewModel.goToConfirmationPix.observe(viewLifecycleOwner,{
            findNavController().navigate(
                PixValueRequestFragmentDirections
                    .actionPixValueRequestFragmentToPixConfirmationFragment(
                        args.email,
                        args.description,
                        it
                    )
            )
        })

        binding.pixApplyValue.setOnClickListener {
            viewModel.onClickApplyValuePix()
        }

        binding.ocultBalance.setOnClickListener {
            viewModel.onOcultBalanceClicked()
        }

        viewModel.balanceVisible.observe(viewLifecycleOwner, {
            if(it){
                binding.ocultBalance.text = getString(R.string.title_ocult)
                binding.balanceValue.setTransformationMethod(null)
            }else{
                binding.ocultBalance.text = getString(R.string.title_visible)
                binding.balanceValue.setTransformationMethod(PasswordTransformationMethod())
            }
        })

        viewModel.invalidValueError.observe(viewLifecycleOwner,{
            binding.editLayoutValue.error = it
        })

    }

    private fun paintButtonOn(button: ExtendedFloatingActionButton) {
        with(button) {
            setBackgroundColor(getColor(requireContext(),R.color.blueTecnoBank))
            setTextColor(Color.WHITE)
            setStrokeColorResource(R.color.white)
        }
    }

    private fun paintButtonOff(button: ExtendedFloatingActionButton) {
        with(button) {
            setBackgroundColor(getColor(requireContext(),R.color.gray_200))
            setTextColor(getColor(requireContext(),R.color.gray_backgroud_invalid))
            setStrokeColorResource(R.color.white)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
