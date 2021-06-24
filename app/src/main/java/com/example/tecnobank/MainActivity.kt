package com.example.tecnobank

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportActionBar?.hide()

//        val preferences: SharedPreferences =
//            getSharedPreferences("user_preferences", MODE_PRIVATE)
//        preferences.edit {
//            putBoolean("Passou",true)
//        }
//        if(preferences.getBoolean("passou", false)){
//            //vai para a tela
//        }


    }
}