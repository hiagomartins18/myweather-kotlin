package com.udemy.curso.myweather.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InstanceRetrofit {

    private const val baseUrl = "https://api.weatherapi.com"

    val api: WeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()) //GSON -> Serializador para converter objeto -> json e vice versa
            .build()
            .create(WeatherApi::class.java)
    }
}