package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.LearningInvestmentsFragmentBinding
import com.example.tecnobank.home.recyclerview.ListLearningInvestmentsPostsAdapter
import java.util.zip.Inflater

class LearningInvestmentsFragment: Fragment() {

    private var _binding : LearningInvestmentsFragmentBinding? = null
    private val binding : LearningInvestmentsFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LearningInvestmentsFragmentBinding.inflate(inflater,container,false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btBack.setOnClickListener {
            requireActivity().finish()
        }

        binding.recyclerLearningInvestments.adapter = ListLearningInvestmentsPostsAdapter()
    }
}