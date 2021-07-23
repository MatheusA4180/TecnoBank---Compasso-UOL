package com.example.tecnobank.home.fragments.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.PixDescriptionFragmentBinding

class PixDescriptionFragment : Fragment() {

    private var _binding: PixDescriptionFragmentBinding? = null
    private val binding: PixDescriptionFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PixDescriptionFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.textView.text = arguments?.getString("Teste")


        binding.toolbarDescriptionPix.setNavigationOnClickListener {

        }

        binding.pixApplyDescription.setOnClickListener {
            findNavController().navigate(R.id.action_pixDescriptionFragment_to_pixValueRequestFragment)
        }

    }
}