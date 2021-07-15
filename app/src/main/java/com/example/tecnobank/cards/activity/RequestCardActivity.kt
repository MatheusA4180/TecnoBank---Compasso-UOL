package com.example.tecnobank.cards.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecnobank.databinding.RequestCardActivityBinding

class RequestCardActivity : AppCompatActivity() {

    private var _binding: RequestCardActivityBinding? = null
    private val binding: RequestCardActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = RequestCardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}
