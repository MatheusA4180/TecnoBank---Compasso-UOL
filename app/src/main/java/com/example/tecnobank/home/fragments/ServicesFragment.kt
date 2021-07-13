package com.example.tecnobank.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tecnobank.R
import com.example.tecnobank.databinding.PageFunctionalitiesBinding
import com.example.tecnobank.home.adapter.POSITION_VIEW_HOLDER
import com.example.tecnobank.home.recyclerview.ListServicesAdapter

class ServicesFragment : Fragment() {

    private var _binding: PageFunctionalitiesBinding? = null
    private val binding: PageFunctionalitiesBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PageFunctionalitiesBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.listServices.adapter =
                ListServicesAdapter(
                    getServicesByPage(
                        requireArguments().getInt(
                            POSITION_VIEW_HOLDER
                        )
                    )
                )
    }

    fun getServicesByPage(positionViewPager: Int): List<ListServicesAdapter.ItemService> {
        return when (positionViewPager) {
            0 -> {
                getListMainServices()
            }
            1 -> {
                getListProdutsAndInvestments()
            }
            else -> {
                getListServices()
            }
        }
    }

    fun getListMainServices(): List<ListServicesAdapter.ItemService> {
        return listOf(
            ListServicesAdapter.ItemService(
                "Transferências",
                R.drawable.ic_transferencia
            ),
            ListServicesAdapter.ItemService(
                "Cartões",
                R.drawable.ic_cartoes
            ),
            ListServicesAdapter.ItemService(
                "Pagar Contas",
                R.drawable.ic_pagar_contas
            ),
            ListServicesAdapter.ItemService(
                "Recargas",
                R.drawable.ic_recarga
            ),
            ListServicesAdapter.ItemService(
                "Adicionar dinheiro",
                R.drawable.ic_adicionar_dinheiro
            ),
            ListServicesAdapter.ItemService(
                "Pix/QR Code",
                R.drawable.ic_pix_qrcode
            )
        )
    }

    private fun getListProdutsAndInvestments(): List<ListServicesAdapter.ItemService> {
        return listOf(
            ListServicesAdapter.ItemService(
                "Aplicando meu Dinheiro",
                R.drawable.ic_aplicando_meu_dinheiro
            ),
            ListServicesAdapter.ItemService(
                "Meus Investimentos",
                R.drawable.ic_meus_investimentos
            ),
            ListServicesAdapter.ItemService(
                "Seguros",
                R.drawable.ic_seguros
            ),
            ListServicesAdapter.ItemService(
                "Aprenda a Investir",
                R.drawable.ic_aprenda_a_investir
            )
        )
    }

    private fun getListServices(): List<ListServicesAdapter.ItemService> {
        return listOf(
            ListServicesAdapter.ItemService(
                "Postos Shell",
                R.drawable.ic_postos_shell
            ),
            ListServicesAdapter.ItemService(
                "Radar de Ofertas",
                R.drawable.ic_radar_ofertas
            ),
            ListServicesAdapter.ItemService(
                "Shopping",
                R.drawable.ic_shopping
            ),
            ListServicesAdapter.ItemService(
                "Onde sacar Dinheiro",
                R.drawable.ic_onde_sacar
            ),
            ListServicesAdapter.ItemService(
                "Indique e Ganhe",
                R.drawable.ic_indique_e_ganhe
            ),
            ListServicesAdapter.ItemService(
                "Pagar com QR code",
                R.drawable.ic_pagar_com_qrcode
            )
        )
    }

}
