package com.example.tecnobank.home.activity.services

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecnobank.databinding.LearningInvestmentsActivityBinding

class LearningInvestmentsActivity : AppCompatActivity() {

    private var _binding: LearningInvestmentsActivityBinding? = null
    private val binding: LearningInvestmentsActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = LearningInvestmentsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
