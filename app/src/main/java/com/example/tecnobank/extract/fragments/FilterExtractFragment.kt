package com.example.tecnobank.extract.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tecnobank.databinding.FilterExtractFragmentBinding
import com.example.tecnobank.extract.FilterActivity
import com.example.tecnobank.extract.recyclerview.ListFilterAdapter
import com.example.tecnobank.home.HomeActivity

const val RESULT_CODE: Int = 2
const val FILTER = "filter"

class FilterExtractFragment : Fragment(), ListFilterAdapter.SelectFilterlistener {

    private var _binding: FilterExtractFragmentBinding? = null
    private val binding: FilterExtractFragmentBinding get() = _binding!!
    private val listItemFilter: List<String> = listOf(
        "Últimos 3 dias",
        "Últimos 7 dias",
        "Últimos 30 dias",
        "Últimos 60 dias",
        "Últimos 120 dias"
    )

    private var positionS: Int = 1


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

        binding.btBack.setOnClickListener {
            requireActivity().finish()
        }

        with(binding.listFilters) {
            adapter = ListFilterAdapter(listItemFilter, this@FilterExtractFragment)
        }

        binding.applyFilter.setOnClickListener {
            val intent = Intent()
            intent.putExtra(FILTER, listItemFilter[positionS])
            requireActivity().setResult(RESULT_CODE,intent)
            requireActivity().finish()
        }

    }

    override fun selectedFilterlistener(position: Int) {
        this.positionS = position
    }
}
