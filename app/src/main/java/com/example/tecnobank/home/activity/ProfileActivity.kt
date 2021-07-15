package com.example.tecnobank.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.databinding.ProfileActivityBinding

class ProfileActivity : AppCompatActivity() {

    private var _binding: ProfileActivityBinding? = null
    private val binding: ProfileActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ProfileActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}