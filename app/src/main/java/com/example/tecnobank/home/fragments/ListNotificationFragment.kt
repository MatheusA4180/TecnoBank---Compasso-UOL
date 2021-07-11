package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.ListNotificationFragmentBinding

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
    }

}