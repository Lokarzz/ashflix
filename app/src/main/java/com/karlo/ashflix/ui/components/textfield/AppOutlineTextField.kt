package com.karlo.ashflix.ui.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.karlo.ashflix.R

@Composable
fun AppOutlinedTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        label = { Text(label) },
    )
}

@Preview
@Composable
private fun AppOutlinedTextFieldPreview() {
    Surface {
        var value by remember { mutableStateOf("") }
        AppOutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.username),
            onValueChange = {
                value = it
            },
            value = value
        )
    }
}