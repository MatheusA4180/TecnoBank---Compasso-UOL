package com.example.tecnobank.home.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tecnobank.home.fragments.PageOneFragment
import com.example.tecnobank.home.fragments.PageThreeFragment
import com.example.tecnobank.home.fragments.PageTwoFragment

class ViewPagerAdapter(fragmentbase:Fragment): FragmentStateAdapter(fragmentbase) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                PageOneFragment()
            }
            1 -> {
                PageTwoFragment()
            }
            2 -> {
                PageThreeFragment()
            }
            else -> {
                throw Exception("Não foi encontrado nenhum fragment")
            }
        }

    }
}