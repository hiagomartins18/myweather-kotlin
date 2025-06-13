package com.udemy.curso.myweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udemy.curso.myweather.api.InstanceRetrofit
import com.udemy.curso.myweather.api.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val _weatherData = MutableLiveData<WeatherModel?>() // Colocando os dados do body dentro de uma MutableLiveData para armazenar as informações de acordo com a mudança
    val weatherData: LiveData<WeatherModel?> = _weatherData // Convertemos para LiveData para que a View não consiga alterar os dados.

    private val _errorMessage = MutableLiveData<String?>() // Exemplo igual o caso acima, porém quando retorna algum erro.
    val errorMessage: LiveData<String?> = _errorMessage


    fun getData(city: String) {
        viewModelScope.launch {
            try {
                val response =
                    InstanceRetrofit.api.getWeather("8991e3081e7d46d484c21934250906", city)
                if (response.isSuccessful) {
                    _weatherData.value = response.body()
                    if (response.body() == null) {
                        _errorMessage.value = "Dados não encontrados."
                    }
                } else {
                    _errorMessage.value = "Erro"
                    _weatherData.value = null
                }

            } catch (e: Exception) {
                _errorMessage.value = "Deu erro"
            }
        }
    }
}