package com.example.tecnobank.home.activity.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.databinding.QrCodeSafeActivityBinding
import com.example.tecnobank.databinding.ShoppingCashbackActivityBinding

class ShoppingCashbackActivity : AppCompatActivity() {

    private var _binding: ShoppingCashbackActivityBinding? = null
    private val binding: ShoppingCashbackActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ShoppingCashbackActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}
