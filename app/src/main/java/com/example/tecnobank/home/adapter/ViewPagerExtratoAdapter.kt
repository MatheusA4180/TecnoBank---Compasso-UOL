package com.example.tecnobank.home.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tecnobank.home.fragments.ExtratoContaFragment
import com.example.tecnobank.home.fragments.ServicosFragment

class ViewPagerExtratoAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return ExtratoContaFragment().also {
            it.arguments = Bundle().apply {
                putInt("position", position)
            }
        }
    }
}