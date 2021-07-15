package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.ListNotificationFragmentBinding
import com.example.tecnobank.home.adapter.POSITION_VIEW_PAGER_NOTIFICATION
import com.example.tecnobank.home.recyclerview.ListNotificationAdapter
import com.example.tecnobank.home.recyclerview.ListServicesAdapter

class ListNotificationFragment : Fragment() {

    private var _binding: ListNotificationFragmentBinding? = null
    private val binding: ListNotificationFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListNotificationFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.listNotification.adapter = ListNotificationAdapter(getNotificationByPage(
            requireArguments().getInt(POSITION_VIEW_PAGER_NOTIFICATION)))

    }

    fun getNotificationByPage(positionViewPager: Int):Int {
        return when (positionViewPager) {
            0 -> 0
            1 -> {
                binding.listNotification.isVisible = false
                binding.imageNotification.isVisible = true
                binding.textNotificationStatic.isVisible = true
                with(binding.textNotificationPage){
                    isVisible = true
                    text = text.toString().replace(".","'Sua Conta'")
                }
                1
            }
            else -> 2
        }
    }
}