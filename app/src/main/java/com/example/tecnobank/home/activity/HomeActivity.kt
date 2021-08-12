package com.example.tecnobank.home.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tecnobank.R
import com.example.tecnobank.data.remote.model.home.TokenFirebase
import com.example.tecnobank.databinding.HomeActivityBinding
import com.example.tecnobank.home.viewmodel.HomeActivityViewModel
import com.example.tecnobank.viewmodelfactory.ViewModelFactory
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class HomeActivity : AppCompatActivity() {

    private var _binding: HomeActivityBinding? = null
    private val binding: HomeActivityBinding get() = _binding!!
    private lateinit var viewModel: HomeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, ViewModelFactory(this))
                .get(HomeActivityViewModel::class.java)

        binding.bottomNavigation.setupWithNavController(
            (supportFragmentManager
                .findFragmentById(R.id.navHostFragmentPix) as NavHostFragment).navController
        )

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@OnCompleteListener
            }
            viewModel.sendToken(TokenFirebase(task.result!!))
        })

        viewModel.responseSuccess.observe(this,{
            Toast.makeText(this,"sucesso",Toast.LENGTH_LONG).show()
        })

        viewModel.responseError.observe(this,{
            Toast.makeText(this,"Erro",Toast.LENGTH_LONG).show()
        })

    }

}
