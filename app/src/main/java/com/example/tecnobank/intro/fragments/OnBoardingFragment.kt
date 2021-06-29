package com.example.tecnobank.intro.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.OnboardingFragmentBinding
import com.example.tecnobank.intro.viewmodel.OnBoardingViewModel
import com.example.tecnobank.intro.viewmodel.ViewModelFactory


class OnBoardingFragment : Fragment(){

    private lateinit var viewModel: OnBoardingViewModel
    private var _binding: OnboardingFragmentBinding? = null
    private val binding: OnboardingFragmentBinding get() = _binding!!
    private val controlador by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OnboardingFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, ViewModelFactory(requireContext())).get(
            OnBoardingViewModel::class.java)

        if(viewModel.vezesSubsequentes()){
            controlador.navigate(R.id.acao_onbordingfragment_para_loginfragment)
        }

        binding.loginComecar.setOnClickListener {
            viewModel.primeiraVez()
            controlador.navigate(R.id.acao_onbordingfragment_para_loginfragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}