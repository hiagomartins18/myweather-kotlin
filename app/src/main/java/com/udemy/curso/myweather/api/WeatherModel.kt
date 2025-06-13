package com.udemy.curso.myweather.api

data class WeatherModel(
    val current: Current,  // Criamos o model utilizando uma extensão JSON TO MODEL, de dentro da IDE.
    val location: Location
)