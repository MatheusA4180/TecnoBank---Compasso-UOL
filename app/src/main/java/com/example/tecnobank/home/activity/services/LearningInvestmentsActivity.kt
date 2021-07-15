package com.example.tecnobank.home.activity.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.R
import com.example.tecnobank.databinding.LearningInvestmentsActivityBinding
import com.example.tecnobank.databinding.LearningInvestmentsFragmentBinding
import com.example.tecnobank.databinding.PixQrCodeActivityBinding

class LearningInvestmentsActivity : AppCompatActivity() {

    private var _binding: LearningInvestmentsActivityBinding? = null
    private val binding: LearningInvestmentsActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = LearningInvestmentsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}