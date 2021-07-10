package com.example.tecnobank.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecnobank.databinding.IntroActivityBinding


class IntroActivity : AppCompatActivity() {
    private lateinit var binding: IntroActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IntroActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
