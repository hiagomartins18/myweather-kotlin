package com.udemy.curso.myweather.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("key") apiKey:String,
        @Query("q") city: String
    ) : Response<WeatherModel>  // Aqui criamos uma interface que irá colocar os endpoints necessários pela API, as querys, a rota que será consumida
}                               // E estabelecemos o Model que queremos de retorno.