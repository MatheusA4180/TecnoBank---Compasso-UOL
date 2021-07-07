package com.example.tecnobank.home.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.databinding.InicioFragmentBinding
import com.example.tecnobank.home.adapter.ViewPagerAdapter
import com.example.tecnobank.home.model.BalanceBenefits
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

        binding.cardBenefitsAndHelp.isVisible = false

        viewModel.responseSucess.observe(viewLifecycleOwner, {
            binding.cardBenefitsAndHelp.isVisible = true
            binding.valorSaldo.text = it.balance.currentValue.replace(".", ",")
            binding.valorVendas.text = (it.balance.receivables + ".00")
                .replace(".", ",")
            recyclerViewConfig(it.benefits)
        })

        viewModel.responseErro.observe(viewLifecycleOwner, {
            showInfo(it)
        })

        binding.visivelSaldo.setOnClickListener {
            viewModel.checkVisibleBalances()
        }

        binding.fechaBanner.setOnClickListener {
            binding.funcionalidadesFaltaPoucoBanner.isVisible = false
        }

        viewModel.visibleBalancesOn.observe(viewLifecycleOwner, {
            binding.valorSaldo.setTransformationMethod(null)
            binding.valorVendas.setTransformationMethod(null)
        })

        viewModel.visibleBalancesOff.observe(viewLifecycleOwner, {
            binding.valorSaldo.setTransformationMethod(PasswordTransformationMethod())
            binding.valorVendas.setTransformationMethod(PasswordTransformationMethod())
        })

        viewPagerAndTabLayoutConfig()
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
            when (position) {
                0 -> {
                    tab.text = "Principais"
                }
                1 -> {
                    tab.text = "Produtos e Investimentos"
                }
                2 -> {
                    tab.text = "Serviços"
                }
            }
        }.attach()
    }

    private fun recyclerViewConfig(listBenefits: List<BalanceBenefits.Benefits>) {
        with(binding.listBenefits) {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = ListaVantagensAdapter(listBenefits, requireContext())
            dotsConfig()
        }
    }

    private fun RecyclerView.dotsConfig() {
        val decor = PagerDecorator()
        addItemDecoration(decor)
        addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
            }

            override fun onInterceptTouchEvent(
                rv: RecyclerView,
                motionEvent: MotionEvent
            ): Boolean {
                return decor.isIndicatorPressing(motionEvent, rv)
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

