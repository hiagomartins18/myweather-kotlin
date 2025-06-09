package com.udemy.curso.myweather

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udemy.curso.myweather.api.InstanceRetrofit
import com.udemy.curso.myweather.api.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val weatherApi = InstanceRetrofit.weatherApi

    private val _weatherResult = MutableLiveData<WeatherModel>()
    val weatherResult: LiveData<WeatherModel> = _weatherResult

    fun getData(city: String) {
        viewModelScope.launch {
            val response = weatherApi.getWeather("8991e3081e7d46d484c21934250906", city)
            if (response.isSuccessful) {
                response.body()?.let { _weatherResult.value }

            } else {
                Log.i("Erro: ", response.message())
            }
        }
    }
}