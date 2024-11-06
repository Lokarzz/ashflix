package com.karlo.ashflix.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun LoginScreen(modifier: Modifier = Modifier, onLoginSuccess: () -> Unit) {
    Column(modifier.fillMaxSize()) {
        Text(text = "Login screen")
        Button(onClick = onLoginSuccess) {
            Text("login!")
        }
    }
}