package com.example.tecnobank.viewmodelfactory

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tecnobank.R
import com.example.tecnobank.data.local.SharedPreferenceServices
import com.example.tecnobank.data.remote.EndPoint
import com.example.tecnobank.extract.repository.ExtractRepositoty
import com.example.tecnobank.extract.viewmodel.ExtractViewModel
import com.example.tecnobank.home.repository.HomeRepository
import com.example.tecnobank.home.repository.PixRepository
import com.example.tecnobank.home.viewmodel.HomeViewModel
import com.example.tecnobank.home.viewmodel.PixOnBoardingViewModel
import com.example.tecnobank.home.viewmodel.PixViewModel
import com.example.tecnobank.intro.repository.LoginRepository
import com.example.tecnobank.intro.repository.OnBoardingRepository
import com.example.tecnobank.intro.repository.SplashRepository
import com.example.tecnobank.intro.viewmodel.LoginViewModel
import com.example.tecnobank.intro.viewmodel.OnBoardingViewModel
import com.example.tecnobank.intro.viewmodel.SplashViewModel

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == SplashViewModel::class.java) {
            return providerSplashViewModel() as T
        }
        if (modelClass == OnBoardingViewModel::class.java) {
            return providerOnBoardingViewModel() as T
        }
        if (modelClass == LoginViewModel::class.java) {
            return providerLoginViewModel() as T
        }
        if (modelClass == HomeViewModel::class.java) {
            return providerHomeViewModel() as T
        }
        if (modelClass == ExtractViewModel::class.java) {
            return providerExtractViewModel() as T
        }
        if (modelClass == PixOnBoardingViewModel::class.java) {
            return providerPixOnBordingViewModel() as T
        }
        if (modelClass == PixViewModel::class.java) {
            return providerPixViewModel() as T
        }
        throw Exception("ViewModel não encotrado")
    }

    private fun providerSplashViewModel(): SplashViewModel {
        return SplashViewModel(
            SplashRepository(
                providerSharedPreferenceService(
                    providerSharedPreference()
                )
            )
        )
    }

    private fun providerOnBoardingViewModel(): OnBoardingViewModel {
        return OnBoardingViewModel(
            OnBoardingRepository(
                providerSharedPreferenceService(
                    providerSharedPreference()
                )
            )
        )
    }

    private fun providerLoginViewModel(): LoginViewModel {
        return LoginViewModel(
            LoginRepository(
                providerEndPointInstance(),
                providerSharedPreferenceService(providerSharedPreference())
            )
        )
    }

    private fun providerHomeViewModel(): HomeViewModel {
        return HomeViewModel(
            HomeRepository(
                providerEndPointInstance(),
                providerSharedPreferenceService(providerSharedPreference())
            )
        )
    }

    private fun providerPixViewModel(): PixViewModel {
        return PixViewModel(
            PixRepository(
                providerSharedPreferenceService(
                    providerSharedPreference()
                )
            )
        )
    }

    private fun providerPixOnBordingViewModel(): PixOnBoardingViewModel {
        return PixOnBoardingViewModel(
            PixRepository(
                providerSharedPreferenceService(
                    providerSharedPreference()
                )
            )
        )
    }

    private fun providerExtractViewModel(): ExtractViewModel {
        return ExtractViewModel(
            ExtractRepositoty(
                providerEndPointInstance(),
                providerSharedPreferenceService(providerSharedPreference())
            )
        )
    }

    private fun providerSharedPreferenceService(
        preferences: SharedPreferences
    ): SharedPreferenceServices {
        return SharedPreferenceServices(preferences)
    }

    private fun providerEndPointInstance(): EndPoint {
        return EndPoint.getEndPointInstance()
    }

    private fun providerSharedPreference(): SharedPreferences {
        return context.getSharedPreferences(
            R.string.preference_file_key.toString(), Context.MODE_PRIVATE
        )
    }
}
