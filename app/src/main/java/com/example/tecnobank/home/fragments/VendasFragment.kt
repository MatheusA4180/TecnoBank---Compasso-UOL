package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.R
import com.example.tecnobank.databinding.ExtratoFragmentBinding
import com.example.tecnobank.databinding.VendasFragmentBinding

class VendasFragment : Fragment() {
    private var _binding: VendasFragmentBinding? = null
    private val binding: VendasFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = VendasFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }
}
