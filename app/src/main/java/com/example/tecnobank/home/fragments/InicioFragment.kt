package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R
import com.example.tecnobank.databinding.InicioFragmentBinding
import com.example.tecnobank.databinding.OnboardingFragmentBinding
import com.example.tecnobank.home.recyclerview.ListaVantagensAdapter
import com.example.tecnobank.home.recyclerview.PagerDecorator

class InicioFragment:Fragment() {
    private var _binding: InicioFragmentBinding? = null
    private val binding: InicioFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = InicioFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}