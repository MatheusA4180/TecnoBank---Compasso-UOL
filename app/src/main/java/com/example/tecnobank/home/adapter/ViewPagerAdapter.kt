package com.example.tecnobank.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tecnobank.home.fragments.PageOneFragment

class ViewPagerAdapter(fragment:Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return PageOneFragment()
    }
}
