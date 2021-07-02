package com.example.tecnobank.intro.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.LoginFragmentBinding
import com.example.tecnobank.intro.viewmodel.LoginViewModel
import com.example.tecnobank.intro.viewmodel.SaveUserViewModel
import com.example.tecnobank.intro.viewmodel.ViewModelFactory

class loginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding: LoginFragmentBinding get() = _binding!!
    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModelSave: SaveUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelFactory(requireContext())).get(
            LoginViewModel::class.java
        )
        viewModelSave = ViewModelProvider(this, ViewModelFactory(requireContext())).get(
            SaveUserViewModel::class.java
        )

        var openloginscreen = true
        if(openloginscreen){
            binding.loginEmail.setText(viewModelSave.getEmail())
            binding.loginSenha.setText(viewModelSave.getPassword())
            if((binding.loginEmail.text.toString() != "")||(binding.loginSenha.text.toString()!="")){
                binding.remeberLogin.toggle()
            }
            openloginscreen = false
        }

        viewModel.sucesso.observe(viewLifecycleOwner, {
            mostraInfo("Login efetuado com sucesso!")
            findNavController().navigate(R.id.acao_loginfragment_to_homeactivity)
            it.tokenAuthentication//levar ele para a InicialFragment
        })

        viewModel.erro.observe(viewLifecycleOwner, {
            mostraInfo(it)
        })
        
        binding.remeberLogin.setOnCheckedChangeListener { _ , isChecked ->
            if(isChecked){
                viewModelSave.saveLogin(binding.loginEmail.text.toString(),
                    binding.loginSenha.text.toString())
            }else{
                viewModelSave.deleteLogin()
            }
        }
        
        binding.loginEntrar.setOnClickListener {
            viewModel.onLoginClicked(
                binding.loginEmail.text.toString(),
                binding.loginSenha.text.toString()
            )
        }
    }

    fun mostraInfo(titulo: String?) {
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
