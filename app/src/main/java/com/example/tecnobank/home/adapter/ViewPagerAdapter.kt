package com.example.tecnobank.home.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tecnobank.home.fragments.ServicesFragment

const val POSITION_VIEW_PAGER = "position_view_pager"

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return ServicesFragment().also {
            it.arguments = Bundle().apply {
                putInt(POSITION_VIEW_PAGER, position)
            }
        }
    }

}
