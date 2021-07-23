package com.example.tecnobank.home.fragments.services

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tecnobank.R
import com.example.tecnobank.databinding.PixValueRequestFragmentBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class PixValueRequestFragment : Fragment() {

    private var _binding: PixValueRequestFragmentBinding? = null
    private val binding: PixValueRequestFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PixValueRequestFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btBack.setOnClickListener {
        }

        binding.ocultBalance.setOnClickListener {
            binding.balanceCard.isVisible = false
        }

        binding.pixApplyValue.setOnClickListener {
            findNavController().navigate(R.id.action_pixValueRequestFragment_to_pixConfirmationFragment)
        }

    }

    private fun paintButtonOn(ref: ExtendedFloatingActionButton) {
        with(ref) {
            setBackgroundColor(Color.parseColor("#2270E3"))
            setTextColor(Color.parseColor("#FFFFFF"))
            setStrokeColorResource(R.color.white)
        }
    }

    private fun paintButtonOff(ref: ExtendedFloatingActionButton) {
        with(ref) {
            setBackgroundColor(Color.parseColor("#ABABAB"))
            setTextColor(Color.parseColor("#676767"))
            setStrokeColorResource(R.color.white)
        }
    }
}
