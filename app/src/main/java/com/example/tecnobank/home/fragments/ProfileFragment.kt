package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tecnobank.R
import com.example.tecnobank.databinding.ProfileFragmentBinding
import com.example.tecnobank.home.recyclerview.ListOptionsProfileAdapter
import com.example.tecnobank.home.recyclerview.ListServicesAdapter
import com.example.tecnobank.home.viewmodel.ProfileViewModel
import com.example.tecnobank.intro.viewmodel.LoginViewModel
import com.example.tecnobank.viewmodelfactory.ViewModelFactory

class ProfileFragment : Fragment() {

    private var _binding: ProfileFragmentBinding? = null
    private val binding: ProfileFragmentBinding get() = _binding!!
    private lateinit var viewModel: ProfileViewModel
    private var listOptionsProfile: List<ListOptionsProfileAdapter.ItemOptionProfile> = listOf(
        ListOptionsProfileAdapter.ItemOptionProfile(
            "Meu Perfil",
            R.drawable.ic_user
        ),
        ListOptionsProfileAdapter.ItemOptionProfile(
            "Imposto de Renda",
            R.drawable.ic_money_white
        ),
        ListOptionsProfileAdapter.ItemOptionProfile(
            "Benefícios eTecnoBank",
            R.drawable.ic_star
        ),ListOptionsProfileAdapter.ItemOptionProfile(
            "Indique e ganhe",
            R.drawable.ic_nominate_and_win
        ),
        ListOptionsProfileAdapter.ItemOptionProfile(
            "Ofertas",
            R.drawable.ic_win_oferts
        ),
        ListOptionsProfileAdapter.ItemOptionProfile(
            "Limites Pix",
            R.drawable.ic_limits_pix
        ),ListOptionsProfileAdapter.ItemOptionProfile(
            "Central de Ajuda",
            R.drawable.ic_help
        ),
        ListOptionsProfileAdapter.ItemOptionProfile(
            "Segurança",
            R.drawable.ic_secure
        ),
        ListOptionsProfileAdapter.ItemOptionProfile(
            "Encerrar conta",
            R.drawable.ic_close_account
        ),
        ListOptionsProfileAdapter.ItemOptionProfile(
            "sair",
            R.drawable.ic_exit_login
        ))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, ViewModelFactory(requireContext())).get(
            ProfileViewModel::class.java
        )

        binding.nameUser.text = viewModel.getSaveUserName()

        binding.btBack.setOnClickListener {
            requireActivity().finish()
        }

        binding.listOptionsProfile.adapter = ListOptionsProfileAdapter(listOptionsProfile)

    }

}
