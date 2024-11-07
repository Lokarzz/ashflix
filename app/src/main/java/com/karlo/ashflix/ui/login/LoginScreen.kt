package com.karlo.ashflix.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.karlo.ashflix.R
import com.karlo.ashflix.ui.main.BasePreview
import com.karlo.ashflix.ui.main.components.textfield.AppOutlinedTextField


@Composable
fun LoginScreen(modifier: Modifier = Modifier, onLoginSuccess: () -> Unit) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = dimensionResource(R.dimen.padding_small))
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
        ) {
            Logo()
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.username)
            )
            AppOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.password),
                visualTransformation = PasswordVisualTransformation()
            )
            LoginSignUp(modifier = Modifier.fillMaxWidth(), onLoginSuccess = onLoginSuccess)
        }

    }
}

@Composable
private fun Logo(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.displayLarge
    )
}

@Composable
private fun LoginSignUp(modifier: Modifier = Modifier, onLoginSuccess: () -> Unit) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        Button(modifier = Modifier.weight(1f), onClick = onLoginSuccess) {
            Text(text = stringResource(R.string.login))
        }
        OutlinedButton(modifier = Modifier.weight(1f), enabled = false, onClick = onLoginSuccess) {
            Text(text = stringResource(R.string.sign_up))
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