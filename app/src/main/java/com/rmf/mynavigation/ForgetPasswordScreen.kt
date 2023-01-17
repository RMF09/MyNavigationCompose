package com.rmf.mynavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmf.mynavigation.destinations.ConfirmationScreenDestination
import com.rmf.mynavigation.destinations.ForgetPasswordScreenDestination

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun ForgetPasswordScreen(
    navigator: DestinationsNavigator
) {
    var email by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Lupa Password",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 64.dp)
        )
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = email,
                onValueChange = { value -> email = value },
                label = {
                    Text(text = "Masukan Email Kamu")
                }
            )
            Button(
                onClick = { navigator.navigate(ConfirmationScreenDestination(email = email)) }
            ) {
                Text(text = "Next")
            }
        }
    }
}