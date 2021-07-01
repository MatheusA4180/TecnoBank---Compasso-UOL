package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.PageFuncionalidades3Binding

class PageThreeFragment : Fragment() {
    private var _binding: PageFuncionalidades3Binding? = null
    private val binding: PageFuncionalidades3Binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PageFuncionalidades3Binding.inflate(inflater, container, false)
        return _binding!!.root
    }

}