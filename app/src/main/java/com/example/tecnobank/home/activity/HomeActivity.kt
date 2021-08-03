package com.example.tecnobank.home.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.HomeActivityBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging

class HomeActivity : AppCompatActivity() {

    private var _binding: HomeActivityBinding? = null
    private val binding: HomeActivityBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setupWithNavController(
            (supportFragmentManager
                .findFragmentById(R.id.navHostFragmentPix) as NavHostFragment).navController
        )

        //id('com.google.gms.google-services')

//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            if (!task.isSuccessful) {
//                Log.i("W", "Fetching FCM registration token failed", task.exception)
//                return@OnCompleteListener
//            }
//            Log.i("Funcionou", task.result!!)
//        })

    }

}
