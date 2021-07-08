package com.example.tecnobank.home.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.ExtratoFragmentBinding
import com.example.tecnobank.home.viewmodel.ExtratoViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class ExtratoFragment: Fragment() {

    private var _binding: ExtratoFragmentBinding? = null
    private val binding: ExtratoFragmentBinding get() = _binding!!
    private lateinit var viewModel: ExtratoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ExtratoFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = ViewModelProvider(this).get(ExtratoViewModel::class.java)

        binding.entraFiltro.setOnClickListener {
            findNavController().navigate(R.id.acao_extratoFragment_para_filtroExtratoFragment)
        }

        checkSelectedButton(listOf(true, false, false))

        binding.todosExtratos.setOnClickListener {
            checkSelectedButton(listOf(true, false, false))
        }

        binding.entradasExtratos.setOnClickListener {
            checkSelectedButton(listOf(false, true, false))
        }

        binding.saidasExtratos.setOnClickListener {
            checkSelectedButton(listOf(false, false, true))
        }

//        viewModel.seletedButtonEveryOn.observe(viewLifecycleOwner, {
//        })
//
//        viewModel.seletedButtonEveryOff.observe(viewLifecycleOwner, {
//        })


    }

    private fun checkSelectedButton(listSelectedButtons: List<Boolean>) {
        for (position in listSelectedButtons.indices) {
            if (listSelectedButtons[0] == true) {
                paintButtonOn(binding.todosExtratos)
                paintButtonOff(binding.entradasExtratos)
                paintButtonOff(binding.saidasExtratos)
            } else if (listSelectedButtons[1] == true) {
                paintButtonOff(binding.todosExtratos)
                paintButtonOn(binding.entradasExtratos)
                paintButtonOff(binding.saidasExtratos)
            } else if (listSelectedButtons[2] == true) {
                paintButtonOff(binding.todosExtratos)
                paintButtonOff(binding.entradasExtratos)
                paintButtonOn(binding.saidasExtratos)
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

}
