package com.example.tecnobank.home.fragments.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.PixFinishFragmentBinding
import com.example.tecnobank.databinding.PixInfoDestinationFragmentBinding

class PixFinishFragment: Fragment() {
    private var _binding: PixFinishFragmentBinding? = null
    private val binding: PixFinishFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PixFinishFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backToHome.setOnClickListener {
            requireActivity().finish()
        }
    }
}