package com.example.tecnobank.cards.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecnobank.databinding.TecnobankCardsActivityBinding

class TecnobankCardsActivity : AppCompatActivity() {

    private var _binding: TecnobankCardsActivityBinding? = null
    private val binding: TecnobankCardsActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = TecnobankCardsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}
