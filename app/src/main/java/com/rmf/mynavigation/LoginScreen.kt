package com.rmf.mynavigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmf.mynavigation.destinations.ForgetPasswordScreenDestination
import com.rmf.mynavigation.destinations.GreetingScreenDestination

@OptIn(ExperimentalMaterial3Api::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun LoginScreen(
    message: String? = null,
    navigator: DestinationsNavigator
) {
    var email by remember {
        mutableStateOf("")
    }
    val snackbarHostState = SnackbarHostState()

    LaunchedEffect(key1 = Unit) {
        if (!message.isNullOrEmpty())
            snackbarHostState.showSnackbar(message = message)
    }

    Scaffold(
        topBar = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp)
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = email,
                    onValueChange = { value -> email = value },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                Button(
                    onClick = { navigator.navigate(GreetingScreenDestination(email = email)) }
                ) {
                    Text(text = "Login")
                }
                Spacer(modifier = Modifier.height(24.dp))
                TextButton(onClick = { navigator.navigate(ForgetPasswordScreenDestination) }) {
                    Text(text = "Lupa Password?")
                }
            }
        }

    }

}