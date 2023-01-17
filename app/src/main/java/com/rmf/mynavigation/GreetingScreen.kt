package com.rmf.mynavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.result.NavResult
import com.ramcosta.composedestinations.result.ResultRecipient
import com.rmf.mynavigation.destinations.ChooseLocationScreenDestination

@Destination
@Composable
fun GreetingScreen(
    email: String,
    resultRecipient: ResultRecipient<ChooseLocationScreenDestination,String>,
    navigator: DestinationsNavigator
) {
    var locationSelected by remember {
        mutableStateOf("")
    }
    resultRecipient.onNavResult{result ->
        when(result){
            is NavResult.Value -> {
                locationSelected = result.value
            }
            NavResult.Canceled -> {}
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hai $email, untuk melanjutkan ke halaman utama, harap pilih lokasi kamu terlebih dahulu",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 64.dp, start = 26.dp, end = 26.dp)
        )
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (locationSelected.isNotBlank())
                Text(text = "Lokasi Kamu adalah $locationSelected")

            Button(onClick = { navigator.navigate(ChooseLocationScreenDestination)}) {
                val textButton = if (locationSelected.isBlank()) "Pilih Lokasi" else "Ubah Lokasi"
                Text(text = textButton)
            }

            if (locationSelected.isNotBlank())
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Done")
                }

        }
    }
}