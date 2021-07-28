package com.example.tecnobank.home.activity.services

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecnobank.databinding.IntroActivityBinding
import com.example.tecnobank.databinding.PixQrCodeActivityBinding

class PixQrCodeActivity : AppCompatActivity() {

    private lateinit var binding: PixQrCodeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PixQrCodeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
