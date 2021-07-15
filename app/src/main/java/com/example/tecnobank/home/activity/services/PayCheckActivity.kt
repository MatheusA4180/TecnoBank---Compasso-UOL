package com.example.tecnobank.home.activity.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.databinding.PayCheckActivityBinding
import com.example.tecnobank.databinding.PayQrCodeActivityBinding

class PayCheckActivity : AppCompatActivity() {
    private var _binding: PayCheckActivityBinding? = null
    private val binding: PayCheckActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = PayCheckActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}