package com.example.tecnobank.cards.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.CardsFragmentBinding

class CardsFragment: Fragment() {

    private var _binding: CardsFragmentBinding? = null
    private val binding: CardsFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CardsFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

}
