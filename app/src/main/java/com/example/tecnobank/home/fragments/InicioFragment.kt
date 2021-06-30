package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R
import com.example.tecnobank.databinding.InicioFragmentBinding
import com.example.tecnobank.databinding.OnboardingFragmentBinding
import com.example.tecnobank.home.recyclerview.ListaVantagensAdapter

class InicioFragment:Fragment() {
    private var _binding: InicioFragmentBinding? = null
    private val binding: InicioFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = InicioFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.listaVantagens.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        binding.listaVantagens.adapter = ListaVantagensAdapter()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}