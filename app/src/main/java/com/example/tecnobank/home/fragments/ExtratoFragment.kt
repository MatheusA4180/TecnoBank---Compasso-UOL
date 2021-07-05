package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.R
import com.example.tecnobank.databinding.CartoesFragmentBinding
import com.example.tecnobank.databinding.ExtratoFragmentBinding

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
}
