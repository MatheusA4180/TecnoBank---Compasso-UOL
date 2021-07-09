package com.example.tecnobank.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecnobank.databinding.AccountDependencyActivityBinding

class AccountDependencyActivity : AppCompatActivity() {

    private var _binding: AccountDependencyActivityBinding? = null
    private val binding: AccountDependencyActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = AccountDependencyActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}