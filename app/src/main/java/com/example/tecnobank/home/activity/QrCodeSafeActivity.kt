package com.example.tecnobank.home.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecnobank.databinding.QrCodeSafeActivityBinding

class QrCodeSafeActivity : AppCompatActivity() {

    private var _binding: QrCodeSafeActivityBinding? = null
    private val binding: QrCodeSafeActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = QrCodeSafeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}
