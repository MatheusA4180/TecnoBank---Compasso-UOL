package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.R
import com.example.tecnobank.databinding.CartoesFragmentBinding
import com.example.tecnobank.databinding.InicioFragmentBinding

class CartoesFragment: Fragment() {
    private var _binding: CartoesFragmentBinding? = null
    private val binding: CartoesFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CartoesFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }
}
