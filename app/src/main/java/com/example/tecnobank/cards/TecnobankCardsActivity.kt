package com.example.tecnobank.cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.R
import com.example.tecnobank.databinding.RequestCardActivityBinding
import com.example.tecnobank.databinding.TecnobankCardsActivityBinding
import com.example.tecnobank.databinding.TecnobankCardsFragmentBinding

class TecnobankCardsActivity : AppCompatActivity() {
    private var _binding: TecnobankCardsActivityBinding? = null
    private val binding: TecnobankCardsActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = TecnobankCardsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}