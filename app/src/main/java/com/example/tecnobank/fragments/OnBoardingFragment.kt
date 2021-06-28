package com.example.tecnobank.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.viewmodel.OnBoardingViewModel


class OnBoardingFragment : Fragment(){
    private lateinit var viewModel: OnBoardingViewModel

    private val controlador by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(OnBoardingViewModel::class.java)

        if(viewModel.vezesSubsequentes()){
            controlador.navigate(R.id.acao_onbordingfragment_para_teste)
        }

        view.findViewById<Button>(R.id.login_comecar).setOnClickListener {
            viewModel.primeiraVez()
            controlador.navigate(R.id.acao_onbordingfragment_para_teste)
        }

    }

}