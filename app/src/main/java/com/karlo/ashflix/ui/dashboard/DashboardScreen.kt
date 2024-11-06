package com.karlo.ashflix.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.karlo.ashflix.ui.main.BasePreview

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Text(text = "dashboard")
    }
}


@Preview
@Composable
private fun DashboardScreenPreview() {
    BasePreview {
        DashboardScreen()
    }
}