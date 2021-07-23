package com.example.tecnobank.home.fragments.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.PixInfoDestinationFragmentBinding

class PixInfoDestinationFragment: Fragment() {

    private var _binding: PixInfoDestinationFragmentBinding? = null
    private val binding: PixInfoDestinationFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PixInfoDestinationFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = Bundle().putString("key", "deu certo")

        binding.btContinue.setOnClickListener {
            findNavController().navigate(R.id.action_pixInfoDestinationFragment_to_pixDescriptionFragment, bundle)
        }
    }

}