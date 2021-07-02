package com.example.tecnobank.intro.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.OnboardingFragmentBinding
import com.example.tecnobank.databinding.SplashFragmentBinding
import com.example.tecnobank.intro.viewmodel.OnBoardingViewModel
import com.example.tecnobank.intro.viewmodel.SplashViewModel
import com.example.tecnobank.intro.viewmodel.ViewModelFactory

class SplashFragment : Fragment() {

    private var _binding: SplashFragmentBinding? = null
    private val binding: SplashFragmentBinding get() = _binding!!
    private lateinit var viewModel:SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SplashFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = ViewModelProvider(this, ViewModelFactory(requireContext())).get(
            SplashViewModel::class.java)

        if(viewModel.hasPassed()) {
            Handler().postDelayed(Runnable {
                findNavController().navigate(R.id.acao_splashfragment_para_loginfragment) },
                3000)
        }else{
            Handler().postDelayed(Runnable {
                findNavController().navigate(R.id.acao_splashfragment_para_onbordingfragment) },
                3000)
        }
    }
}