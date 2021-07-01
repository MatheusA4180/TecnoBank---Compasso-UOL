package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.PageFuncionalidades2Binding

class PageTwoFragment: Fragment() {
    private var _binding: PageFuncionalidades2Binding? = null
    private val binding: PageFuncionalidades2Binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PageFuncionalidades2Binding.inflate(inflater, container, false)
        return _binding!!.root
    }

}