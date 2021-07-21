package com.example.tecnobank.extract.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.R
import com.example.tecnobank.databinding.FilterExtractFragmentBinding
import com.example.tecnobank.extract.recyclerview.ListFilterAdapter

const val RESULT_CODE: Int = 2
const val FILTER = "filter"

class FilterExtractFragment : Fragment(), ListFilterAdapter.SelectFilterlistener {

    private var _binding: FilterExtractFragmentBinding? = null
    private val binding: FilterExtractFragmentBinding get() = _binding!!

    private val listItemFilter: List<String> by lazy {
        listOf(
            getString(R.string.list_filter_item_1),
            getString(R.string.list_filter_item_2),
            getString(R.string.list_filter_item_3),
            getString(R.string.list_filter_item_4),
            getString(R.string.list_filter_item_5)
        )
    }


    private var positionSelected: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FilterExtractFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.filterToolbar.setNavigationOnClickListener {
            requireActivity().finish()
        }



        with(binding.listFilters) {
            adapter =
                ListFilterAdapter(listItemFilter, this@FilterExtractFragment, positionSelected)
        }

        binding.applyFilter.setOnClickListener {
            requireActivity().setResult(
                RESULT_CODE,
                Intent().putExtra(FILTER, listItemFilter[positionSelected])
            )
            requireActivity().finish()
        }

    }

    override fun selectedFilterlistener(position: Int) {
        this.positionSelected = position
    }

}
