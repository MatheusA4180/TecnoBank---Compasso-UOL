package com.example.tecnobank.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecnobank.databinding.ComplementActivityBinding

class ComplementActivity : AppCompatActivity() {

    private var _binding: ComplementActivityBinding? = null
    private val binding: ComplementActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ComplementActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}