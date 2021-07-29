package com.example.tecnobank.home.activity.services

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.PixQrCodeActivityBinding
import com.example.tecnobank.home.viewmodel.PixViewModel
import com.example.tecnobank.viewmodelfactory.ViewModelFactory

class PixQrCodeActivity : AppCompatActivity() {

    private lateinit var binding: PixQrCodeActivityBinding
    private lateinit var viewModel: PixViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PixQrCodeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, ViewModelFactory(this))
                .get(PixViewModel::class.java)

        val navHostFragment = (supportFragmentManager.findFragmentById(R.id.navHostFragmentPix) as NavHostFragment)
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.pix_qr_code_nav_graph)

        viewModel.passedOrNoPassedForPixOnbording()

        viewModel.servicesToPixOnBoarding.observe(this, {
            graph.startDestination = R.id.pixOnBordingFragment
            //findNavController().navigate(R.id.action_homeFragment_to_pixOnBordingActivity)
        })

        viewModel.servicesToPix.observe(this, {
            graph.startDestination = R.id.pixQrCodeFragment
            //findNavController().navigate(R.id.action_homeFragment_to_pixQrCodeActivity)
        })

        navHostFragment.navController.graph = graph

    }
}
