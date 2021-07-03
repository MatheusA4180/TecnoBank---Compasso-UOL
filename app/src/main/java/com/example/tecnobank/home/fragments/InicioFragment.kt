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

        viewModel = ViewModelProvider(this, ViewModelFactoryHome(requireContext())).get(InicioViewModel::class.java)

        viewModel.onOpenHome()

        viewModel.sucesso.observe(viewLifecycleOwner, {
            mostraInfo("Response recebida com sucesso!")
            binding.valorSaldo.text = it.balance.currentValue
            binding.valorVendas.text = it.balance.receivables
        })

        viewModel.erro.observe(viewLifecycleOwner, {
            mostraInfo(it)
        })

        var visivel = true
        binding.visivelSaldo.setOnClickListener {
            if(visivel==true){
                binding.valorSaldo.setTransformationMethod(PasswordTransformationMethod())
                binding.valorVendas.setTransformationMethod(PasswordTransformationMethod())
                visivel = false
            }else{
                binding.valorSaldo.setTransformationMethod(null)
                binding.valorVendas.setTransformationMethod(null)
                visivel = true
            }
        }


        val adapter = ViewPagerAdapter(this)
        binding.pagerFuncionalidades.adapter = adapter
        val tablayoutMediator = TabLayoutMediator(binding.tabLayoutFuncionalidades,
            binding.pagerFuncionalidades,
            TabLayoutMediator.TabConfigurationStrategy{ tab, position ->
                when(position + 1){
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
            })
        tablayoutMediator.attach()


        binding.listaVantagens.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        binding.listaVantagens.adapter = ListaVantagensAdapter()

        val decor = PagerDecorator()
        binding.listaVantagens.addItemDecoration(decor)

        binding.listaVantagens.addOnItemTouchListener(object: RecyclerView.OnItemTouchListener {
            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
            }

            override fun onInterceptTouchEvent(rv: RecyclerView, motionEvent: MotionEvent): Boolean {
                return decor.isIndicatorPressing(motionEvent, rv)
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
            }
        })

    }

    fun mostraInfo(titulo: String?) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setCancelable(true)
        builder.setTitle(titulo)
        builder.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}