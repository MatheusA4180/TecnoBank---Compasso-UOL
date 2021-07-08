package com.example.tecnobank.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.HomeActivityBinding


class HomeActivity : AppCompatActivity() {

    private var _binding: HomeActivityBinding? = null
    private val binding: HomeActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setupWithNavController(
            (supportFragmentManager
                .findFragmentById(R.id.navHostFragment) as NavHostFragment).navController
        )


//        val intent = intent
//        val filter = intent.getStringExtra("filter")
//        val bundle = Bundle()
//        bundle.putString("filter", filter)
//        ExtratoFragment().setArguments(bundle)

    }
}
