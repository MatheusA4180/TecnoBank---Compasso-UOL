package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tecnobank.R
import com.example.tecnobank.databinding.FiltroExtratoFragmentBinding
import com.example.tecnobank.home.recyclerview.ListaFiltrosAdapter

class FiltroExtratoFragment : Fragment() {

    private var _binding: FiltroExtratoFragmentBinding? = null
    private val binding: FiltroExtratoFragmentBinding get() = _binding!!
    private val listItemFilter: List<String> = listOf(
        "Últimos 3 dias",
        "Últimos 7 dias",
        "Últimos 30 dias",
        "Últimos 60 dias",
        "Últimos 120 dias"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FiltroExtratoFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btBack.setOnClickListener {
            findNavController().navigate(R.id.acao_filtroExtratoFragment_para_extratoFragment)
        }

        //receber a posição selecionada para enviar para o outro fragmento
        with(binding.listFilters) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ListaFiltrosAdapter(listItemFilter)
        }

//        binding.applyFilter.setOnClickListener {
//            arguments = Bundle().apply {
//              putString("text_selected",//listItemFilter[position])
//            }
//        }
    }
}
