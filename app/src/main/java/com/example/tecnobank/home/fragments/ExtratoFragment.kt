package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.R
import com.example.tecnobank.databinding.CartoesFragmentBinding
import com.example.tecnobank.databinding.ExtratoFragmentBinding
import com.example.tecnobank.home.adapter.ViewPagerExtratoAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ExtratoFragment: Fragment() {
    private var _binding: ExtratoFragmentBinding? = null
    private val binding: ExtratoFragmentBinding get() = _binding!!

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

        binding.extratoPager.adapter = ViewPagerExtratoAdapter(this)

        TabLayoutMediator(
            binding.extratoTabLayout,
            binding.extratoPager
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Todas"
                }
                1 -> {
                    tab.text = "Entradas"
                }
                2 -> {
                    tab.text = "Saídas"
                }
            }
        }.attach()
    }
}
