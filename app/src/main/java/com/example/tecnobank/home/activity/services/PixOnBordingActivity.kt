package com.example.tecnobank.home.activity.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.databinding.PixOnBordingActivityBinding
import com.example.tecnobank.databinding.PixQrCodeActivityBinding

class PixOnBordingActivity : AppCompatActivity() {

    private lateinit var binding: PixOnBordingActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PixOnBordingActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}