package com.example.tecnobank.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnobank.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
        supportActionBar?.hide()

    }
}