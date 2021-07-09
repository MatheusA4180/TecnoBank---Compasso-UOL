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
        with(binding.listServices) {
            layoutManager =
                GridLayoutManager(
                    requireContext(), 2, GridLayoutManager.HORIZONTAL,
                    false
                )
            adapter =
                ListaServicosAdapter(getServicesByPage(requireArguments().getInt("position_view_pager")))
        }
    }

    fun getServicesByPage(positionViewPager: Int): List<ListaServicosAdapter.ItemService> {
        return when (positionViewPager) {
            0 -> {
                getListMainServices()
            }
            1 -> {
                getListProdutsAndInvestments()
            }
            2 -> {
                getListServices()
            }
            else -> {
                throw Exception("nenhuma lista encontrada")
            }
        }
    }

    fun getListMainServices(): List<ListaServicosAdapter.ItemService> {
        return listOf(
            ListaServicosAdapter.ItemService(
                "Transferências",
                R.drawable.ic_transferencia
            ),
            ListaServicosAdapter.ItemService(
                "Cartões",
                R.drawable.ic_cartoes
            ),
            ListaServicosAdapter.ItemService(
                "Pagar Contas",
                R.drawable.ic_pagar_contas
            ),
            ListaServicosAdapter.ItemService(
                "Recargas",
                R.drawable.ic_recarga
            ),
            ListaServicosAdapter.ItemService(
                "Adicionar dinheiro",
                R.drawable.ic_adicionar_dinheiro
            ),
            ListaServicosAdapter.ItemService(
                "Pix/QR Code",
                R.drawable.ic_pix_qrcode
            )
        )
    }

    private fun getListProdutsAndInvestments(): List<ListaServicosAdapter.ItemService> {
        return listOf(
            ListaServicosAdapter.ItemService(
                "Portabilidade de Salário",
                R.drawable.ic_portabilidade_salario
            ),
            ListaServicosAdapter.ItemService(
                "Aplicando meu Dinheiro",
                R.drawable.ic_aplicando_meu_dinheiro
            ),
            ListaServicosAdapter.ItemService(
                "Meus Investimentos",
                R.drawable.ic_meus_investimentos
            ),
            ListaServicosAdapter.ItemService(
                "Seguros",
                R.drawable.ic_seguros
            ),
            ListaServicosAdapter.ItemService(
                "Aprenda a Investir",
                R.drawable.ic_aprenda_a_investir
            )
        )
    }

    private fun getListServices(): List<ListaServicosAdapter.ItemService> {
        return listOf(
            ListaServicosAdapter.ItemService(
                "Postos Shell",
                R.drawable.ic_postos_shell
            ),
            ListaServicosAdapter.ItemService(
                "Radar de Ofertas",
                R.drawable.ic_radar_ofertas
            ),
            ListaServicosAdapter.ItemService(
                "Shopping",
                R.drawable.ic_shopping
            ),
            ListaServicosAdapter.ItemService(
                "Onde sacar Dinheiro",
                R.drawable.ic_onde_sacar
            ),
            ListaServicosAdapter.ItemService(
                "Indique e Ganhe",
                R.drawable.ic_indique_e_ganhe
            ),
            ListaServicosAdapter.ItemService(
                "Pagar com QR code",
                R.drawable.ic_pagar_com_qrcode
            )
        )
    }

}
