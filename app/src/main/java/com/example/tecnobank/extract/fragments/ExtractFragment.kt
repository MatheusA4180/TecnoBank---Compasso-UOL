package com.example.tecnobank.extract.fragments

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tecnobank.R
import com.example.tecnobank.databinding.ExtractFragmentBinding
import com.example.tecnobank.extract.recyclerview.ListExtractsAdapter
import com.example.tecnobank.extract.viewmodel.ExtractViewModel
import com.example.tecnobank.viewmodelfactory.ViewModelFactory
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import java.util.*

class ExtractFragment: Fragment() {

    private var _binding: ExtractFragmentBinding? = null
    private val binding: ExtractFragmentBinding get() = _binding!!
    private lateinit var viewModel: ExtractViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ExtractFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(ExtractViewModel::class.java)

        binding.progressCircular.isVisible = false
        binding.listExtracts.isVisible = false

//        if(requireArguments().getString("filter").isNullOrEmpty()){
//            binding.textFilter.text = "nos ${(requireArguments().getString("text_selected"))!!.toLowerCase()}."
//        }

//        viewModel.onOpenExtract("","")

//        viewModel.responseSucess.observe(viewLifecycleOwner, {
//                binding.imageExtract.isVisible = false
//                binding.textExtract.isVisible = false
//                binding.textFilter.isVisible = false
//                recyclerViewConfig()
//        })

//        viewModel.responseErro.observe(viewLifecycleOwner, {
//            showInfo(it)
//            if(requireArguments().getString("text_selected").isNullOrEmpty()){
//                binding.textFilter.text = "nos ${(requireArguments().getString("text_selected")).toLowerCase()}."
//            }
//        })

        binding.enterFilter.setOnClickListener {
            findNavController().navigate(R.id.action_extratoFragment_to_filterActivity)
        }

        binding.everyExtracts.setOnClickListener {
            checkSelectedButton(listOf(true, false, false))
            loading()
            Handler().postDelayed({
                binding.progressCircular.isVisible = false
                binding.imageExtract.isVisible = false
                binding.textExtract.isVisible = false
                binding.textFilter.isVisible = false
                val data: Date = Calendar.getInstance().time
                testRecyclerViewConfig(data)
            }, 1500)
        }

        binding.inputsExtract.setOnClickListener {
            checkSelectedButton(listOf(false, true, false))
            loading()
            loadingSemDados()
        }

        binding.exitExtracts.setOnClickListener {
            checkSelectedButton(listOf(false, false, true))
            loading()
            loadingSemDados()
        }

    }

    private fun testRecyclerViewConfig(date: Date) {
        with(binding.listExtracts) {
            isVisible = true
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ListExtractsAdapter(date)
        }
    }

    private fun loadingSemDados() {
        Handler().postDelayed({
            binding.progressCircular.isVisible = false
            binding.listExtracts.isVisible = false
            binding.imageExtract.isVisible = true
            binding.textExtract.isVisible = true
            binding.textFilter.isVisible = true
        }, 1500)
    }

    private fun loading() {
        binding.progressCircular.isVisible = true
    }

//    private fun recyclerViewConfig(listBenefits: List<BalanceBenefits.Benefits>) {
//        with(binding.listExtratos) {
//            layoutManager = LinearLayoutManager(
//                requireContext(),
//                LinearLayoutManager.HORIZONTAL,
//                false
//            )
//            adapter = ListaExtratoAdapter()
//        }
//    }

    private fun checkSelectedButton(listSelectedButtons: List<Boolean>) {
        for (position in listSelectedButtons.indices) {
            if (listSelectedButtons[0] == true) {
                paintButtonOn(binding.everyExtracts)
                paintButtonOff(binding.inputsExtract)
                paintButtonOff(binding.exitExtracts)
            } else if (listSelectedButtons[1] == true) {
                paintButtonOff(binding.everyExtracts)
                paintButtonOn(binding.inputsExtract)
                paintButtonOff(binding.exitExtracts)
            } else if (listSelectedButtons[2] == true) {
                paintButtonOff(binding.everyExtracts)
                paintButtonOff(binding.inputsExtract)
                paintButtonOn(binding.exitExtracts)
            }
        }
    }

    private fun paintButtonOn(ref: ExtendedFloatingActionButton) {
        with(ref) {
            setBackgroundColor(Color.parseColor("#FFFFFF"))
            setTextColor(Color.parseColor("#5cbd4c"))
            setStrokeColorResource(R.color.greenTecnoBank)
        }
    }

    private fun paintButtonOff(ref: ExtendedFloatingActionButton) {
        with(ref) {
            setBackgroundColor(Color.parseColor("#5cbd4c"))
            setTextColor(Color.parseColor("#FFFFFF"))
            setStrokeColorResource(R.color.white)
        }
    }

    fun showInfo(titulo: String?) {
        AlertDialog.Builder(requireContext())
            .setCancelable(true)
            .setTitle(titulo)
            .setMessage("")
            .show()
    }

}