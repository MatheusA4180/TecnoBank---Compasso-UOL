package com.example.tecnobank.home.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.databinding.InicioFragmentBinding
import com.example.tecnobank.home.adapter.ViewPagerAdapter
import com.example.tecnobank.home.recyclerview.ListaVantagensAdapter
import com.example.tecnobank.home.recyclerview.PagerDecorator
import com.example.tecnobank.home.viewmodel.InicioViewModel
import com.example.tecnobank.home.viewmodel.ViewModelFactoryHome
import com.google.android.material.tabs.TabLayoutMediator


class InicioFragment:Fragment() {
    private var _binding: InicioFragmentBinding? = null
    private val binding: InicioFragmentBinding get() = _binding!!
    private lateinit var viewModel:InicioViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = InicioFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = ViewModelProvider(
            this,
            ViewModelFactoryHome(requireContext())
        ).get(InicioViewModel::class.java)

        viewModel.onOpenHome()

        viewModel.response.observe(viewLifecycleOwner, {
            showInfo("Response recebida com sucesso!")
            binding.valorSaldo.text = it.balance.currentValue
            binding.valorVendas.text = it.balance.receivables
        })

        viewModel.responseErro.observe(viewLifecycleOwner, {
            showInfo(it)
        })

        binding.visivelSaldo.setOnClickListener {
            viewModel.checkVisibleBalances()
        }


        viewModel.visibleOn.observe(viewLifecycleOwner,{
            binding.valorSaldo.setTransformationMethod(null)
            binding.valorVendas.setTransformationMethod(null)
        })

        viewModel.visibleOff.observe(viewLifecycleOwner,{
            binding.valorSaldo.setTransformationMethod(PasswordTransformationMethod())
            binding.valorVendas.setTransformationMethod(PasswordTransformationMethod())
        })

        viewPagerAndTabLayoutConfig()

        recyclerViewConfig()
    }

    private fun viewPagerAndTabLayoutConfig() {
        binding.pagerFuncionalidades.adapter = ViewPagerAdapter(this)
        tabLayoutConfig()
    }

    private fun tabLayoutConfig() {
        TabLayoutMediator(
            binding.tabLayoutFuncionalidades,
            binding.pagerFuncionalidades
        ) { tab, position ->
            when (position + 1) {
                1 -> {
                    tab.text = "Principais"
                }
                2 -> {
                    tab.text = "Produtos e Investimentos"
                }
                3 -> {
                    tab.text = "Serviços"
                }
            }
        }.attach()
    }

    private fun recyclerViewConfig() {
        with(binding.listaVantagens) {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = ListaVantagensAdapter()
            dotsConfig()
        }
    }

    private fun RecyclerView.dotsConfig() {
        addItemDecoration(PagerDecorator())
        addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
            }

            override fun onInterceptTouchEvent(
                rv: RecyclerView,
                motionEvent: MotionEvent
            ): Boolean {
                return PagerDecorator().isIndicatorPressing(motionEvent, rv)
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
            }
        })
    }

    fun showInfo(titulo: String?) {
        AlertDialog.Builder(requireContext())
            .setCancelable(true)
            .setTitle(titulo)
            .setMessage("")
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
