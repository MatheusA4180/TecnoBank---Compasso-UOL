package com.example.tecnobank.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.databinding.NotificationActivityBinding

class NotificationActivity : AppCompatActivity() {
    private var _binding: NotificationActivityBinding? = null
    private val binding: NotificationActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = NotificationActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}