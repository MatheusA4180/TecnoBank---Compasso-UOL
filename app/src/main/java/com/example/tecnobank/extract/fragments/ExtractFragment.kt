package com.example.tecnobank.extract.fragments

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tecnobank.R
import com.example.tecnobank.databinding.ExtractFragmentBinding
import com.example.tecnobank.extract.FilterActivity
import com.example.tecnobank.extract.recyclerview.ListExtractsAdapter
import com.example.tecnobank.extract.viewmodel.ExtractViewModel
import com.example.tecnobank.viewmodelfactory.ViewModelFactory
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import java.util.*

const val REQUEST_CODE: Int = 1

class ExtractFragment : Fragment() {

    private var _binding: ExtractFragmentBinding? = null
    private val binding: ExtractFragmentBinding get() = _binding!!
    private lateinit var viewModel: ExtractViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ExtractFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(ExtractViewModel::class.java)

        viewModel.onOpenExtract("09/07/2021","12/07/2021")

        viewModel.responseSucess.observe(viewLifecycleOwner, {
                binding.imageExtract.isVisible = false
                binding.textExtract.isVisible = false
                binding.textFilter.isVisible = false
                Toast.makeText(requireContext(),"sucesso",Toast.LENGTH_LONG).show()
                //recyclerViewConfig()
        })

        viewModel.responseErro.observe(viewLifecycleOwner, {
            showInfo(it)
            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        })


        binding.enterFilter.setOnClickListener {
            //findNavController().navigate(R.id.action_extratoFragment_to_filterActivity)
            val intent = Intent(requireActivity(), FilterActivity::class.java)
            requireActivity().startActivityForResult(intent, REQUEST_CODE)
        }

        try {
            Toast.makeText(
                requireContext(),
                requireArguments().getString("filter").toString().lowercase(),
                Toast.LENGTH_LONG
            ).show()
            binding.textFilter.text =
                "nos ${requireArguments().getString("filter").toString().lowercase()}"
        } catch (e: IllegalStateException) {
            binding.textFilter.text = binding.textFilter.text.toString().replace("três", "3")
        }

        binding.everyExtracts.setOnClickListener {
            checkSelectedButton(listOf(true, false, false))
            loading()
            Handler().postDelayed({
                binding.progressCircular.isVisible = false
                binding.imageExtract.isVisible = false
                binding.textExtract.isVisible = false
                binding.textFilter.isVisible = false
                val data: Date = Calendar.getInstance().time
                testRecyclerViewConfig(data)
            }, 1500)
        }

        binding.inputsExtract.setOnClickListener {
            checkSelectedButton(listOf(false, true, false))
            loading()
            loadingSemDados()
        }

        binding.exitExtracts.setOnClickListener {
            checkSelectedButton(listOf(false, false, true))
            loading()
            loadingSemDados()
        }

    }

    private fun testRecyclerViewConfig(date: Date) {
        with(binding.listExtracts) {
            isVisible = true
            adapter = ListExtractsAdapter(date)
        }
    }

    private fun loadingSemDados() {
        Handler().postDelayed({
            binding.progressCircular.isVisible = false
            binding.listExtracts.isVisible = false
            binding.imageExtract.isVisible = true
            binding.textExtract.isVisible = true
            binding.textFilter.isVisible = true
        }, 1500)
    }

    private fun loading() {
        binding.progressCircular.isVisible = true
    }

//    private fun recyclerViewConfig(listBenefits: List<BalanceBenefits.Benefits>) {
//        with(binding.listExtratos) {
//            layoutManager = LinearLayoutManager(
//                requireContext(),
//                LinearLayoutManager.HORIZONTAL,
//                false
//            )
//            adapter = ListaExtratoAdapter()
//        }
//    }

    private fun checkSelectedButton(listSelectedButtons: List<Boolean>) {
        for (position in listSelectedButtons.indices) {
            if (listSelectedButtons[0] == true) {
                paintButtonOn(binding.everyExtracts)
                paintButtonOff(binding.inputsExtract)
                paintButtonOff(binding.exitExtracts)
            } else if (listSelectedButtons[1] == true) {
                paintButtonOff(binding.everyExtracts)
                paintButtonOn(binding.inputsExtract)
                paintButtonOff(binding.exitExtracts)
            } else if (listSelectedButtons[2] == true) {
                paintButtonOff(binding.everyExtracts)
                paintButtonOff(binding.inputsExtract)
                paintButtonOn(binding.exitExtracts)
            }
        }
    }

    private fun paintButtonOn(ref: ExtendedFloatingActionButton) {
        with(ref) {
            setBackgroundColor(Color.parseColor("#FFFFFF"))
            setTextColor(Color.parseColor("#5cbd4c"))
            setStrokeColorResource(R.color.greenTecnoBank)
        }
    }

    private fun paintButtonOff(ref: ExtendedFloatingActionButton) {
        with(ref) {
            setBackgroundColor(Color.parseColor("#5cbd4c"))
            setTextColor(Color.parseColor("#FFFFFF"))
            setStrokeColorResource(R.color.white)
        }
    }

    fun showInfo(titulo: String?) {
        AlertDialog.Builder(requireContext())
            .setCancelable(true)
            .setTitle(titulo)
            .setMessage("")
            .show()
    }

}