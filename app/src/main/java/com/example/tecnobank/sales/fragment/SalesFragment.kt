package com.example.tecnobank.sales.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.SalesFragmentBinding

class SalesFragment : Fragment() {

    private var _binding: SalesFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SalesFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

}
