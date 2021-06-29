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

class loginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding: LoginFragmentBinding get() = _binding!!
    private lateinit var viewModel: LoginViewModel
    private val controlador by lazy {
        findNavController()
    }

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
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginEntrar.setOnClickListener {
            controlador.navigate(R.id.acao_loginfragment_to_homeactivity)
        }
//        view.findViewById<Button>(R.id.login_entrar).setOnClickListener {
//            val user = view.findViewById<EditText>(R.id.login_email).text.toString()
//            val password = view.findViewById<EditText>(R.id.login_senha).text.toString()
//
//            if(true){
//                mostraErro("Erro","Descrição do erro")
//            }

        //prepararEntrarNaConta()

    }

    fun mostraErro(titulo: String?, mensagem: String?) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setCancelable(true)
        builder.setTitle(titulo)
        builder.setMessage(mensagem)
        builder.show()
    }

    fun prepararEntrarNaConta() {
        val button: Button = binding.loginEntrar
        button.setOnClickListener {
            preencher()
        }
    }

    fun preencher() {
        val email: String = binding.loginEmail.text.toString() //campoEmail?.text.toString()
        val senha: String = binding.loginSenha.text.toString()
        validar(email, senha)
    }

    fun isCampoVazio(valor: String): Boolean {
        return !(TextUtils.isEmpty(valor))
    }

    fun validar(email: String, senha: String) {
        if (!isCampoVazio(email)) {
            binding.loginEmail.error = "CPF, CNPJ ou Email não preenchido!";
            binding.loginEmail.requestFocus();
        }
        if (!isCampoVazio(senha)) {
            binding.loginSenha.error = "Senha não preenchida!";
            binding.loginSenha.requestFocus();
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



