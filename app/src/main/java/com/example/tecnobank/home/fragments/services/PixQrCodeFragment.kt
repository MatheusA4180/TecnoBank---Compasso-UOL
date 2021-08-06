package com.example.tecnobank.home.fragments.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.PixQrCodeFragmentBinding


class PixQrCodeFragment : Fragment() {

    private var _binding: PixQrCodeFragmentBinding? = null
    private val binding: PixQrCodeFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PixQrCodeFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pixQrcodeToobar.setNavigationOnClickListener{
            requireActivity().finish()
        }

        binding.pixTransfer.setOnClickListener {
            findNavController().navigate(R.id.action_pixQrCodeFragment_to_pixModeTransferFragment)
        }

        binding.payQrCode.setOnClickListener {
            findNavController().navigate(R.id.action_pixQrCodeFragment_to_payQrCodeActivity2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
