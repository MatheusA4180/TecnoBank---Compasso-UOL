package com.example.tecnobank.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.HomeActivityBinding
import com.example.tecnobank.extract.fragments.ExtractFragment
import com.example.tecnobank.extract.fragments.REQUEST_CODE
import com.example.tecnobank.extract.fragments.RESULT_CODE
import com.example.tecnobank.home.adapter.POSITION_VIEW_PAGER_SERVICES
import com.example.tecnobank.home.fragments.ServicesFragment


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

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CODE) {
                ExtractFragment().also {
                    it.arguments = Bundle().apply {
                        putString("filter", data!!.getStringExtra("filter"))
                    }
                }
            }
        }
    }
}
