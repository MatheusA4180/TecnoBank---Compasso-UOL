package com.example.tecnobank.home.fragments.services

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tecnobank.R
import com.example.tecnobank.databinding.PixConfirmationFragmentBinding
import com.example.tecnobank.extension.HelperFunctions.converterToReal
import com.example.tecnobank.home.viewmodel.PixConfirmationViewModel
import com.example.tecnobank.viewmodelfactory.ViewModelFactory
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class PixConfirmationFragment : Fragment() {

    private var _binding: PixConfirmationFragmentBinding? = null
    private val binding: PixConfirmationFragmentBinding get() = _binding!!
    private lateinit var viewModel: PixConfirmationViewModel
    private val args: PixConfirmationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PixConfirmationFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(PixConfirmationViewModel::class.java)

        viewModel.setPixItensRequest(args.email,args.description,args.value.toDouble())
        viewModel.requestValidationPix()

        binding.toolbarPixConfirmation.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.datePix.setOnClickListener {
            MaterialDatePicker.Builder.datePicker().setTitleText("Selecione a data")
                .build().apply {
                    addOnPositiveButtonClickListener {
                        val calendar = Calendar.getInstance()
                        calendar.time = Date(it)
                        viewModel.validationDatePix(calendar)
                    }
                }.show(childFragmentManager, DATE_PICKER_PIX)
        }

        viewModel.loading.observe(viewLifecycleOwner, {
            binding.progressCircular.isVisible = it
        })

        viewModel.pixValidationSucess.observe(viewLifecycleOwner, {
            with(binding) {
                valueConfirmationPix.text = converterToReal(it.pixValue.toDouble())
                valueConfirmationPix2.text = converterToReal(it.pixValue.toDouble())
                binding.nameDestination.text = "${it.user.firstName} ${it.user.lastName}"
                emailDestinationPix.text = it.pix
                descriptionPix.text = it.description
                datePix.text = it.date
            }
        })

        viewModel.validDatePix.observe(viewLifecycleOwner,{
            binding.datePix.text = it
        })

        viewModel.pixValidationError.observe(viewLifecycleOwner, {
            showInfo(it)
        })

        viewModel.pixConfirmationSucess.observe(viewLifecycleOwner, {
            findNavController().navigate(
                PixConfirmationFragmentDirections
                    .actionPixConfirmationFragmentToPixFinishFragment(
                        it.date,
                        "${it.user.firstName} ${it.user.lastName}",
                        it.pix,
                        converterToReal(it.pixValue.toDouble()),
                    )
            )
        })

        viewModel.pixConfirmationError.observe(viewLifecycleOwner, {
            showInfo(it)
        })

        binding.pixConfirmationTransaction.setOnClickListener {
            viewModel.onClickConfirmationPix()
        }

        binding.cancelPix.setOnClickListener {
            requireActivity().finish()
        }

    }

    fun showInfo(titulo: String?) {
        AlertDialog.Builder(requireContext())
            .setCancelable(true)
            .setTitle(titulo)
            .setMessage("")
            .show()
    }

    companion object {
        const val DATE_PICKER_PIX = "datePicker"
    }
}
