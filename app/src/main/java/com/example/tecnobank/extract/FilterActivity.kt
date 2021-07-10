package com.example.tecnobank.extract

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecnobank.databinding.FilterActivityBinding

class FilterActivity : AppCompatActivity() {

    private var _binding: FilterActivityBinding? = null
    private val binding: FilterActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = FilterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}