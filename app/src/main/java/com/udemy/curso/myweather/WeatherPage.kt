package com.udemy.curso.myweather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.udemy.curso.myweather.api.WeatherModel

@Composable
fun Weatherpage(viewModel: WeatherViewModel) {

    var city by remember { mutableStateOf("") } // Gerenciador de Estado -> Variavel
    // let nome = [useNome, useChangeNome] = useState("")
    // value = nome -> onSubmit = (useChangeNome()) -> value

    var weatherResult = viewModel.weatherResult
    var result = weatherResult.value


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedTextField(value = city, onValueChange = { city = it })
                IconButton(onClick = { viewModel.getData(city) }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Procure por algum lugar."
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location Icon",
                            modifier = Modifier.size(40.dp)
                        )

                    }
                }
            }
        }
}


@Preview(showBackground = true)
@Composable

fun WeatherPagePreview() {
    Weatherpage(WeatherViewModel())
}