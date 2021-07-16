package com.example.tecnobank.home.activity.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.databinding.PayQrCodeActivityBinding
import com.example.tecnobank.databinding.PayQrCodeFragmentBinding
import com.example.tecnobank.databinding.PixQrCodeActivityBinding

class PayQrCodeActivity : AppCompatActivity() {

    private var _binding: PayQrCodeActivityBinding? = null
    private val binding: PayQrCodeActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = PayQrCodeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
