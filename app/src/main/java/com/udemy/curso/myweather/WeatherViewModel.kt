package com.udemy.curso.myweather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udemy.curso.myweather.api.InstanceRetrofit
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val weatherApi = InstanceRetrofit.weatherApi

    fun getData(city: String) {
        viewModelScope.launch {
            val response = weatherApi.getWeather("8991e3081e7d46d484c21934250906", city)
            if (response.isSuccessful) {
                Log.i("Response: ", response.body().toString())

            } else {
                Log.i("Erro: ", response.message())
            }
        }
    }
}