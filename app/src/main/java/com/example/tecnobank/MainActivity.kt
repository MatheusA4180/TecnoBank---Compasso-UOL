package com.example.tecnobank

<<<<<<< HEAD
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


=======
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(3000)
        setTheme(R.style.Theme_Tecnobank)

        setContentView(R.layout.activity_main)
>>>>>>> db970d3 (Feature - Implementação da função do splash)
    }
}