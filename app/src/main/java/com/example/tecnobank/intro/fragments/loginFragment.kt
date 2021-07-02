package com.example.tecnobank.intro.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tecnobank.databinding.LoginFragmentBinding
import com.example.tecnobank.intro.viewmodel.LoginViewModel
import com.example.tecnobank.intro.viewmodel.ViewModelFactory

class loginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding: LoginFragmentBinding get() = _binding!!
    private lateinit var viewModel: LoginViewModel

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

        binding.loginEmail.setText(viewModel.getEmail())
        binding.loginSenha.setText(viewModel.getPassword())

        viewModel.initEmptyFields(binding.loginEmail.text.toString(),
            binding.loginSenha.text.toString())

        viewModel.emptyFields.observe(viewLifecycleOwner, {
            binding.remeberLogin.toggle()
        })

        viewModel.sucesso.observe(viewLifecycleOwner, {
            mostraInfo("Login efetuado com sucesso!")
        })

        viewModel.erro.observe(viewLifecycleOwner, {
            mostraInfo(it)
        })
        
        binding.remeberLogin.setOnCheckedChangeListener { _ , isChecked ->
            if(isChecked){
                viewModel.onSwitchChecked(
                    binding.loginEmail.text.toString(),
                    binding.loginSenha.text.toString()
                )
            }else{
                viewModel.offSwitchChecked()
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
