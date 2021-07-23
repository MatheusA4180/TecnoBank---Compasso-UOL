package com.example.tecnobank.home.fragments.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.PixOnboardingFragmentBinding
import com.example.tecnobank.databinding.PixQrCodeFragmentBinding

class PixOnBordingFragment: Fragment() {

    private var _binding: PixOnboardingFragmentBinding? = null
    private val binding: PixOnboardingFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PixOnboardingFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.closeOnBording.setOnClickListener{
            requireActivity().finish()
        }

        binding.btContinue.setOnClickListener{
            findNavController().navigate(R.id.action_pixOnBordingFragment_to_pixQrCodeActivity2)
            requireActivity().finish()
        }
    }
}