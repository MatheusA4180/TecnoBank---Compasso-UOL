package com.example.tecnobank.home.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tecnobank.home.fragments.FiltroExtratoFragment

class ViewPagerExtratoAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return FiltroExtratoFragment().also {
            it.arguments = Bundle().apply {
                putInt("position", position)
            }
        }
    }
}