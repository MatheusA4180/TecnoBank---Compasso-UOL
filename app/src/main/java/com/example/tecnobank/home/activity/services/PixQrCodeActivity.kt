package com.example.tecnobank.home.activity.services

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecnobank.databinding.PixQrCodeActivityBinding

class PixQrCodeActivity : AppCompatActivity() {

    private var _binding: PixQrCodeActivityBinding? = null
    private val binding: PixQrCodeActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = PixQrCodeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
