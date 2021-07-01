package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.PageFuncionalidades1Binding

class PageOneFragment: Fragment() {
    private var _binding: PageFuncionalidades1Binding? = null
    private val binding: PageFuncionalidades1Binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PageFuncionalidades1Binding.inflate(inflater, container, false)
        return _binding!!.root
    }

}