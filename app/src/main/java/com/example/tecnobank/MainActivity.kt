package com.example.tecnobank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(3000)
        setTheme(R.style.Theme_Tecnobank)

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