package com.example.tecnobank.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.R
import com.example.tecnobank.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
