package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tecnobank.databinding.FiltroExtratoFragmentBinding
import com.example.tecnobank.home.recyclerview.ListaFiltrosAdapter


class FiltroExtratoFragment : Fragment(), ListaFiltrosAdapter.SelectFilterlistener {

    private var _binding: FiltroExtratoFragmentBinding? = null
    private val binding: FiltroExtratoFragmentBinding get() = _binding!!
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
        _binding = FiltroExtratoFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btBack.setOnClickListener {
            requireActivity().finish()
        }

        with(binding.listFilters) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ListaFiltrosAdapter(listItemFilter, this@FiltroExtratoFragment)
        }

        positionS


//        val intent = Intent(requireActivity().baseContext, FilterActivity::class.java)
//        intent.putExtra("filter", listItemFilter[4])
//        requireActivity().startActivity(intent)

    }

    override fun selectedFilterlistener(position: Int) {
        this.positionS = position
    }
}
