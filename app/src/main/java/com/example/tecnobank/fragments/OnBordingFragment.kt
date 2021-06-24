package com.example.tecnobank.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.viewmodel.LoginViewModel


class OnBordingFragment : Fragment(){
    private lateinit var viewModel: LoginViewModel
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

       /* this.login_comecar.setOnClickListener {
           viewModel.primeiraVez()
        }

        this.login_comecar.setOnClickListener {
            val direcao = OnBordingFragmentDirections
            .acao_onbordingfragment_para_teste
            controlador.navigate(direcao)
        }
*/
    }

}