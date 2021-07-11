package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.R
import com.example.tecnobank.databinding.ProfileFragmentBinding
import com.example.tecnobank.home.recyclerview.ListOptionsProfileAdapter
import com.example.tecnobank.home.recyclerview.ListServicesAdapter

class ProfileFragment : Fragment() {

    private var _binding: ProfileFragmentBinding? = null
    private val binding: ProfileFragmentBinding get() = _binding!!
    private var listOptionsProfile: List<ListOptionsProfileAdapter.ItemOptionProfile> = listOf(
        ListOptionsProfileAdapter.ItemOptionProfile(
            getString(R.string.tranfers_service),
            R.drawable.ic_transferencia
        ))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btBack.setOnClickListener {
            requireActivity().finish()
        }

        binding.listOptionsProfile.adapter = ListOptionsProfileAdapter(listOptionsProfile)

    }
}
