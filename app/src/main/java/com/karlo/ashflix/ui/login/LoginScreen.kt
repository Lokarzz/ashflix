package com.karlo.ashflix.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.karlo.ashflix.R
import com.karlo.ashflix.ui.main.BasePreview
import com.karlo.ashflix.ui.main.components.textfield.AppOutlinedTextField


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier, onLoginSuccess: () -> Unit,
    loginViewModel: LoginViewModel = viewModel()
) {
    val uiState = loginViewModel.uiState.collectAsState()
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        ScreenBackground(modifier = Modifier.fillMaxSize())
        OutlinedCard(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = dimensionResource(R.dimen.padding_medium)),
        ) {
            Column(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            ) {
                Logo(modifier = Modifier)
                AppOutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(R.string.username),
                    value = uiState.value.userName,
                    onValueChange = {
                        loginViewModel.updateUsername(it)
                    }
                )
                AppOutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(R.string.password),
                    visualTransformation = PasswordVisualTransformation(),
                    value = uiState.value.password,
                    onValueChange = {
                        loginViewModel.updatePassword(it)
                    }
                )
                LoginSignUp(modifier = Modifier.fillMaxWidth(), onLoginSuccess = onLoginSuccess)
            }
        }


    }
}

@Composable
private fun Logo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            modifier = Modifier,
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.displayLarge,
            fontFamily = FontFamily.Cursive
        )
        Icon(
            painter = painterResource(R.drawable.rounded_camera_video_24),
            contentDescription = stringResource(R.string.rounded_camera_video)
        )
    }

}

@Composable
private fun LoginSignUp(modifier: Modifier = Modifier, onLoginSuccess: () -> Unit) {
    Row(
        modifier = modifier.height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        Button(modifier = Modifier.weight(1f), onClick = onLoginSuccess) {
            Text(text = stringResource(R.string.login))
        }
        VerticalDivider()
        OutlinedButton(modifier = Modifier.weight(1f), enabled = false, onClick = onLoginSuccess) {
            Text(text = stringResource(R.string.sign_up))
        }
    }
}

@Composable
fun ScreenBackground(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .blur(radius = 10.dp),
        painter = painterResource(R.drawable.ashflix),
        contentDescription = stringResource(R.string.background_logo),
        contentScale = ContentScale.Crop,
    )
}


@Preview
@Composable
private fun DarkPreview() {
    BasePreview(darkTheme = true) {
        LoginScreen(onLoginSuccess = {})
    }
}

@Preview
@Composable
private fun LightPreview() {
    BasePreview(darkTheme = false) {
        LoginScreen(onLoginSuccess = {})
    }
}