package com.karlo.ashflix.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.karlo.ashflix.ui.components.AppScreens
import com.karlo.ashflix.ui.main.theme.AshflixTheme
import com.karlo.ashflix.ui.view.dashboard.DashboardScreen
import com.karlo.ashflix.ui.view.login.LoginScreen
import com.karlo.ashflix.ui.view.login.LoginScreenPreview
import com.karlo.ashflix.ui.view.video.VideoScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AshflixTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    AshflixApp(
                        modifier = Modifier.safeContentPadding(),
                        windowSizeClass = windowSize.widthSizeClass
                    )
                }
            }
        }
    }
}

@Composable
private fun AshflixApp(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController()
) {
//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentScreen = AppScreens.valueOf(
//        backStackEntry?.destination?.route ?: AppScreens.Login.name
//    )
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppScreens.Login.name
    ) {
        composable(route = AppScreens.Login.name) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(route = AppScreens.Dashboard.name)
                },
                windowSizeClass = windowSizeClass
            )
        }
        composable(route = AppScreens.Dashboard.name) {
            DashboardScreen(windowSizeClass = windowSizeClass)
        }
        composable(route = AppScreens.Video.name) {
            VideoScreen(windowSizeClass = windowSizeClass)
        }
    }
}

@Composable
fun AshflixAppPreview(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppScreens.Login.name
    ) {
        composable(route = AppScreens.Login.name) {
            LoginScreenPreview(
                onLoginSuccess = {
                    navController.navigate(route = AppScreens.Dashboard.name)
                },
                windowSizeClass = windowSizeClass,
            )
        }
        composable(route = AppScreens.Dashboard.name) {
            DashboardScreen(windowSizeClass = windowSizeClass)
        }
    }
}


@Composable
fun BasePreview(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val layoutDirection = LocalLayoutDirection.current
    AshflixTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier
                .padding(
                    start = WindowInsets.safeDrawing.asPaddingValues()
                        .calculateStartPadding(layoutDirection),
                    end = WindowInsets.safeDrawing.asPaddingValues()
                        .calculateEndPadding(layoutDirection)
                )
        ) {
            content()
        }
    }
}

@Preview
@Composable
private fun MediumPreview(

) {
    BasePreview {
        AshflixAppPreview(
            windowSizeClass = WindowWidthSizeClass.Medium
        )
    }
}


@Preview(device = Devices.TABLET)
@Composable
private fun ExpandedPreview() {
    BasePreview {
        AshflixAppPreview(windowSizeClass = WindowWidthSizeClass.Expanded)
    }
}