package com.example.tecnobank.cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.databinding.RequestCardActivityBinding

class RequestCardActivity : AppCompatActivity() {
    private var _binding: RequestCardActivityBinding? = null
    private val binding: RequestCardActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = RequestCardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}