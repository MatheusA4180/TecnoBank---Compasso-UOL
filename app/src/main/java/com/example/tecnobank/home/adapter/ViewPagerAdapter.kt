package com.example.tecnobank.home.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tecnobank.home.fragments.ServicosFragment

class ViewPagerAdapter(fragment:Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
//        return ServicosFragment().apply {
//            arguments = Bundle().
//        }

        return ServicosFragment().also {
            it.arguments = Bundle().apply {
                putInt("position", position)
            }
        }
    }
}
