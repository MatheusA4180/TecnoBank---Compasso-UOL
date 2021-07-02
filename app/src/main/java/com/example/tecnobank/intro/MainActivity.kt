package com.example.tecnobank.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.R
import com.example.tecnobank.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {
    private var _binding: MainActivityBinding? = null
    private val binding: MainActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}