package com.example.tecnobank.cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.databinding.PrepaidCardActivityBinding

class PrepaidCardActivity : AppCompatActivity() {
    private var _binding: PrepaidCardActivityBinding? = null
    private val binding: PrepaidCardActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = PrepaidCardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}