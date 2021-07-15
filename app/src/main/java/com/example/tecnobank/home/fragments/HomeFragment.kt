package com.example.tecnobank.home.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnobank.R
import com.example.tecnobank.data.remote.model.home.BalanceBenefitsResponse
import com.example.tecnobank.databinding.HomeFragmentBinding
import com.example.tecnobank.extension.HelperFunctions.converterToReal
import com.example.tecnobank.home.adapter.ViewPagerServicesAdapter
import com.example.tecnobank.home.recyclerview.ListBenefitsAdapter
import com.example.tecnobank.home.recyclerview.PagerDecoratorDots
import com.example.tecnobank.home.viewmodel.HomeViewModel
import com.example.tecnobank.viewmodelfactory.ViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private var _binding: HomeFragmentBinding? = null
    private val binding: HomeFragmentBinding get() = _binding!!
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(HomeViewModel::class.java)

        viewModel.onOpenHome()

        viewModel.responseSucess.observe(viewLifecycleOwner, {
            binding.listBenefits.isVisible = true
            binding.currentValue.text = converterToReal(it.balance.currentValue.toDouble())
            binding.receivables.text = converterToReal(it.balance.receivables.toDouble())
            recyclerViewConfig(it.benefits)
        })

        viewModel.responseErro.observe(viewLifecycleOwner, {
            showInfo(it)
        })

        binding.btVisibleBalance.setOnClickListener {
            viewModel.checkVisibleBalances()
        }

        binding.incompletSingUp.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_accountDependencyActivity)
        }

        binding.btNotification.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_notificationActivity)
        }

        binding.btQrcode.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_qrCodeSafeActivity)
        }

        binding.btLogin.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileActivity)
        }

        viewModel.balanceVisible.observe(viewLifecycleOwner, {
            if(it){
                binding.currentValue.setTransformationMethod(null)
                binding.receivables.setTransformationMethod(null)
            }else{
                binding.currentValue.setTransformationMethod(PasswordTransformationMethod())
                binding.receivables.setTransformationMethod(PasswordTransformationMethod())
            }
        })

        viewPagerAndTabLayoutConfig()
    }

    private fun viewPagerAndTabLayoutConfig() {
        binding.pagerFunctionalities.adapter = ViewPagerServicesAdapter(this)
        tabLayoutConfig()
    }

    private fun tabLayoutConfig() {
        TabLayoutMediator(
            binding.tabLayoutFunctionalities,
            binding.pagerFunctionalities
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.main_services)
                }
                1 -> {
                    tab.text = getString(R.string.products_services)
                }
                2 -> {
                    tab.text = getString(R.string.service_services)
                }
            }
        }.attach()
    }

    private fun recyclerViewConfig(listBenefitsResponse: List<BalanceBenefitsResponse.Benefits>) {
        with(binding.listBenefits) {
            adapter = ListBenefitsAdapter(listBenefitsResponse)
            dotsConfig()
        }
    }

    private fun RecyclerView.dotsConfig() {
        val decor = PagerDecoratorDots()
        addItemDecoration(decor)
        addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
            }

            override fun onInterceptTouchEvent(
                rv: RecyclerView,
                motionEvent: MotionEvent
            ): Boolean {
                return decor.isIndicatorPressing(motionEvent, rv)
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
            }
        })
    }

    fun showInfo(titulo: String?) {
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

