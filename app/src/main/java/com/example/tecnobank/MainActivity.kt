package com.example.tecnobank

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferences:SharedPreferences =
            this.getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE)


        setContentView(R.layout.main_activity)
        supportActionBar?.hide()

    }
}