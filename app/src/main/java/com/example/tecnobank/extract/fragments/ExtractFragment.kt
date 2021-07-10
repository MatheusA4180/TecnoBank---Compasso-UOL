package com.example.tecnobank.extract.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.ExtractFragmentBinding

class ExtractFragment: Fragment() {

    private var _binding: ExtractFragmentBinding? = null
    private val binding: ExtractFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ExtractFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

}
