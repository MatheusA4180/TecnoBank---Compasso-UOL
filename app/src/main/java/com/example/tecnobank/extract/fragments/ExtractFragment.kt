package com.example.tecnobank.extract.fragments

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tecnobank.R
import com.example.tecnobank.data.remote.model.extract.ExtractResponse
import com.example.tecnobank.databinding.ExtractFragmentBinding
import com.example.tecnobank.extract.activity.FilterActivity
import com.example.tecnobank.extract.recyclerview.ListExtractsAdapter
import com.example.tecnobank.extract.viewmodel.ExtractViewModel
import com.example.tecnobank.viewmodelfactory.ViewModelFactory
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

const val REQUEST_CODE: Int = 1
const val BUTTON_EVERY: String = "bt_every"
const val BUTTON_INPUTS: String = "bt_inputs"
const val BUTTON_EXITS: String = "bt_exits"

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

        viewModel.requestExtracts()

        viewModel.loading.observe(viewLifecycleOwner, {
            binding.progressCircular.isVisible = false
        })

        viewModel.responseErro.observe(viewLifecycleOwner, {
            binding.progressCircular.isVisible = false
            showInfo(it)
        })

        binding.enterFilter.setOnClickListener {
            startActivityForResult(
                Intent(requireActivity(), FilterActivity::class.java),
                REQUEST_CODE
            )
        }

        binding.everyExtracts.setOnClickListener {
            checkSelectedButton(listOf(true, false, false))
            recyclerViewConfig(BUTTON_EVERY)
        }

        binding.inputsExtract.setOnClickListener {
            checkSelectedButton(listOf(false, true, false))
            recyclerViewConfig(BUTTON_INPUTS)
        }

        binding.exitExtracts.setOnClickListener {
            checkSelectedButton(listOf(false, false, true))
            recyclerViewConfig(BUTTON_EXITS)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_CODE) {
            viewModel.onChangeDataFilter(
                data!!.getStringExtra(FILTER)!!
                    .toString().lowercase()
            )
            binding.textFilter.text = viewModel.valueFilter()
        }
    }

    private fun recyclerViewConfig(buttonPressed: String) {
        binding.imageExtract.isVisible = false
        binding.textExtract.isVisible = false
        binding.textFilter.isVisible = false
        binding.listExtracts.isVisible = true
        binding.listExtracts.adapter = ListExtractsAdapter(
            viewModel.returnListForExtractFiltered(buttonPressed)
        )

    }

    private fun checkSelectedButton(listSelectedButtons: List<Boolean>) {
        when {
            listSelectedButtons[0] -> {
                paintButtonOn(binding.everyExtracts)
                paintButtonOff(binding.inputsExtract)
                paintButtonOff(binding.exitExtracts)
            }
            listSelectedButtons[1] -> {
                paintButtonOff(binding.everyExtracts)
                paintButtonOn(binding.inputsExtract)
                paintButtonOff(binding.exitExtracts)
            }
            listSelectedButtons[2] -> {
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
