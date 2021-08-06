package com.example.tecnobank.home.fragments

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnobank.databinding.QrCodeSafeFragmentBinding
import java.lang.Exception

class QrCodeSafeFragment: Fragment() {

    private var _binding: QrCodeSafeFragmentBinding? = null
    private val binding: QrCodeSafeFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = QrCodeSafeFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btBack.setOnClickListener {
            requireActivity().finish()
        }

        binding.acceptDependency.setOnClickListener {
            try{
                startActivity(Intent(ACTION_IMAGE_CAPTURE))
            }catch (e:Exception){
                AlertDialog.Builder(requireContext()).setTitle("Erro inesperado ao abrir a camera")
                    .setMessage("").show()
            }

            //requireActivity().startCamera()
        }

    }

}
