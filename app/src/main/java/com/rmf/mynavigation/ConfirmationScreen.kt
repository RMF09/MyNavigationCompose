package com.rmf.mynavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmf.mynavigation.destinations.LoginScreenDestination

@Destination
@Composable
fun ConfirmationScreen(
    email: String,
    navigator: DestinationsNavigator
) {

    val text = buildAnnotatedString {
        append("Hai ")
        withStyle(SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
            append(email)
        }
        append(", kami akan mengirim password baru ke email anda. Klik tombol konfirmasi untuk melanjutkan")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Konfirmasi Ganti Password",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 64.dp)
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = text)
            Button(
                onClick = {
                    navigator.navigate(LoginScreenDestination(message = "Silahkan cek email anda dan kembali login")){
                       //  popUpTo(NavGraphs.root)
                    }
                }
            ) {
                Text(text = "Confirm")
            }
        }

    }

}