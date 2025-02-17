package com.karlo.ashflix.ui.view.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.karlo.ashflix.R
import com.karlo.ashflix.ui.components.textfield.AppOutlinedTextField
import com.karlo.ashflix.ui.main.BasePreview
import com.karlo.ashflix.ui.main.uiState.ApiState


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel(),
    windowSizeClass: WindowWidthSizeClass,
    onContinueAsGuest: () -> Unit
) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()
    val modifierLoginCard = when (windowSizeClass) {
        WindowWidthSizeClass.Expanded -> Modifier.width(dimensionResource(R.dimen.expanded_login_card_width))
        else -> Modifier.fillMaxWidth()
    }
    LaunchedEffect(uiState.loginApiState) {
        if (uiState.loginApiState is ApiState.Success) {
            onLoginSuccess()
        }
    }
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        ScreenBackground(modifier = Modifier.fillMaxSize())
        OutlinedCard(
            modifier = modifierLoginCard
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

                LoginFields(userName = uiState.userName,
                    password = uiState.password,
                    onUpdateUserName = {
                        loginViewModel.updateUsername(it)
                    },
                    onUpdatePassword = {
                        loginViewModel.updatePassword(it)
                    })

                LoginSignUp(
                    modifier = Modifier.fillMaxWidth(),
                    onLogin = {
                        loginViewModel.login()
                    }
                )

                Text(
                    modifier = Modifier.clickable { onContinueAsGuest() },
                    text = stringResource(R.string.continue_as_guest)
                )
            }
        }
    }
}

@Composable
private fun LoginFields(
    userName: String,
    onUpdateUserName: (String) -> Unit,
    password: String,
    onUpdatePassword: (String) -> Unit,
) {
    AppOutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(R.string.username),
        value = userName,
        onValueChange = onUpdateUserName,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        ),
        singleLine = true,
    )
    AppOutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(R.string.password),
        visualTransformation = PasswordVisualTransformation(),
        value = password,
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        onValueChange = onUpdatePassword
    )
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
private fun LoginSignUp(modifier: Modifier = Modifier, onLogin: () -> Unit) {
    Row(
        modifier = modifier.height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        Button(modifier = Modifier.weight(1f), onClick = onLogin) {
            Text(text = stringResource(R.string.login))
        }
        VerticalDivider()
        OutlinedButton(modifier = Modifier.weight(1f), enabled = false, onClick = onLogin) {
            Text(text = stringResource(R.string.sign_up))
        }
    }
}

@Composable
private fun ScreenBackground(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {

    }
}

@Composable
fun LoginScreenPreview(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowWidthSizeClass,
    onLoginSuccess: () -> Unit = {},
    onContinueAsGuest: () -> Unit = {},
) {
    LoginScreen(
        modifier = modifier,
        onLoginSuccess = onLoginSuccess,
        windowSizeClass = windowSizeClass,
        loginViewModel = LoginViewModel(FakeLoginProvider()),
        onContinueAsGuest = onContinueAsGuest
    )
}


@Preview
@Composable
private fun DarkPreview() {
    BasePreview {
        LoginScreenPreview(
            windowSizeClass = WindowWidthSizeClass.Compact,
        )
    }
}

@Preview(device = "spec:width=1280dp,height=800dp,dpi=240")
@Composable
private fun TabletPreview() {
    BasePreview {
        LoginScreenPreview(
            windowSizeClass = WindowWidthSizeClass.Expanded,
        )

    }
}

@Preview(device = "spec:width=673dp,height=841dp")
@Composable
private fun FoldablePreview() {
    BasePreview {
        LoginScreenPreview(
            windowSizeClass = WindowWidthSizeClass.Expanded,
        )
    }
}

@Preview
@Composable
private fun LightPreview() {
    BasePreview(darkTheme = false) {
        LoginScreenPreview(
            windowSizeClass = WindowWidthSizeClass.Compact,
        )
    }
}