package com.example.tecnobank.home.activity.services

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tecnobank.databinding.PixQrCodeActivityBinding
import com.example.tecnobank.home.viewmodel.PixViewModel
import com.example.tecnobank.viewmodelfactory.ViewModelFactory

class PixQrCodeActivity : AppCompatActivity() {

    private lateinit var binding: PixQrCodeActivityBinding
    private lateinit var viewModel: PixViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            ViewModelProvider(this, ViewModelFactory(this))
                .get(PixViewModel::class.java)



        binding = PixQrCodeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
