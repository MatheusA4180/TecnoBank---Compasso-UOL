package com.example.tecnobank.cards.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.PrepaidCardFragmentBinding
import com.example.tecnobank.databinding.TecnobankCardsFragmentBinding

class TecnobankCardsFragment: Fragment() {

    private var _binding: TecnobankCardsFragmentBinding? = null
    private val binding: TecnobankCardsFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TecnobankCardsFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btBack.setOnClickListener {
            requireActivity().finish()
        }
    }

}