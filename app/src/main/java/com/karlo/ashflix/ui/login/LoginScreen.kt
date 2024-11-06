package com.karlo.ashflix.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.karlo.ashflix.ui.main.BasePreview


@Composable
fun LoginScreen(modifier: Modifier = Modifier, onLoginSuccess: () -> Unit) {
    Column(modifier.fillMaxSize()) {
        Text(text = "Login screen")
        Button(onClick = onLoginSuccess) {
            Text("login!")
        }
    }
}


@Preview
@Composable
private fun LoginScreenPreview() {
    BasePreview {
        LoginScreen(onLoginSuccess = {})
    }
}