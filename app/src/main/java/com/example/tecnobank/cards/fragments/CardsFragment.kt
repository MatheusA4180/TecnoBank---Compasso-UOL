package com.example.tecnobank.cards.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.CardsFragmentBinding

class CardsFragment : Fragment() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.requireCard.setOnClickListener {
            findNavController().navigate(R.id.action_cardsFragment_to_requestCardActivity)
        }

        binding.buyPrepaidCard.setOnClickListener {
            findNavController().navigate(R.id.action_cardsFragment_to_prepaidCardActivity)
        }

        binding.tecnobankCards.setOnClickListener {
            findNavController().navigate(R.id.action_cardsFragment_to_tecnobankCardsActivity)
        }

    }

}
