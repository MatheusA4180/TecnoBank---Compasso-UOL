package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tecnobank.R
import com.example.tecnobank.databinding.PageFuncionalidadesBinding
import com.example.tecnobank.home.recyclerview.ListaServicosAdapter

class ServicosFragment : Fragment() {
    private var _binding: PageFuncionalidadesBinding? = null
    private val binding: PageFuncionalidadesBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PageFuncionalidadesBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listServicesTitles: List<String> = listOf(
            "Transferências",
            "Cartões",
            "Pagar Contas",
            "Recargas",
            "Adicionar dinheiro",
            "Pix/QR Code",
            "Aplicando meu Dinheiro",
            "Meus Investimentos",
            "Seguros",
            "Aprenda a Investir",
            "Postos Shell",
            "Radar de Ofertas",
            "Shopping",
            "Onde sacar Dinheiro",
            "Indique e Ganhe",
            "Pagar com QR code"
        )

        val listServicesIcons: List<Int> = listOf(
            R.drawable.ic_transferencia,
            R.drawable.ic_cartoes,
            R.drawable.ic_pagar_contas,
            R.drawable.ic_recarga,
            R.drawable.ic_adicionar_dinheiro,
            R.drawable.ic_pix_qrcode,
            R.drawable.ic_aplicando_meu_dinheiro,
            R.drawable.ic_meus_investimentos,
            R.drawable.ic_seguros,
            R.drawable.ic_aprenda_a_investir,
            R.drawable.ic_postos_shell,
            R.drawable.ic_radar_ofertas,
            R.drawable.ic_shopping,
            R.drawable.ic_onde_sacar,
            R.drawable.ic_indique_e_ganhe,
            R.drawable.ic_pagar_com_qrcode
        )

        with(binding.listaServicos) {
            layoutManager =
                GridLayoutManager(
                    requireContext(), 2, GridLayoutManager.HORIZONTAL,
                    false
                )
            adapter = ListaServicosAdapter(listServicesTitles, listServicesIcons)
        }

        //if(positionViewPager==0){(1 pagina do view pager)
        //  limitar o trecho de exibição inicial da recycler view(6 botões iniciais)
        // }else if(positionViewPager==1){(2 pagina do view pager)
        //  limitar o trecho de exibição medio da recycler view(6 botões intermediarios)
        // }else{(3 pagina do view pager)
        //  limitar o trecho de exibição final da recycler view(4 botões finais)
        // }

        arguments?.takeIf { it.containsKey("position") }?.apply {
            binding.listaServicos.scrollToPosition(getInt("position"))
        }
    }

}
