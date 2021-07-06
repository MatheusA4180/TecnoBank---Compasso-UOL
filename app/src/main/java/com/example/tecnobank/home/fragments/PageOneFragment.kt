package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tecnobank.databinding.PageFuncionalidades1Binding
import com.example.tecnobank.home.recyclerview.ListaServicosAdapter

class PageOneFragment: Fragment() {
    private var _binding: PageFuncionalidades1Binding? = null
    private val binding: PageFuncionalidades1Binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PageFuncionalidades1Binding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.listaServicos) {
            layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.HORIZONTAL, false)
            adapter = ListaServicosAdapter(requireContext())
        }

    }

}
