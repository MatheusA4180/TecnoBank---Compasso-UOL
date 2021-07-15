package com.example.tecnobank.home.activity.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.databinding.AddMoneyActivityBinding
import com.example.tecnobank.databinding.NotificationActivityBinding

class AddMoneyActivity : AppCompatActivity() {

    private var _binding: AddMoneyActivityBinding? = null
    private val binding: AddMoneyActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = AddMoneyActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
