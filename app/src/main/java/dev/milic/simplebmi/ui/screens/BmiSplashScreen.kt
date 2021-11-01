package dev.milic.simplebmi.ui.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import dev.milic.simplebmi.util.Constants.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay

@Composable
fun BmiSplashScreen(
    navigateToCalculatorScreen: () -> Unit
) {
    var startAnimation by remember { mutableStateOf(value = false) }
    val offsetState by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 100.dp,
        animationSpec = tween(durationMillis = 1000)
    )
    val alphaState by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(SPLASH_SCREEN_DELAY)
        navigateToCalculatorScreen()
    }

    Box(
        modifier = Modifier
            .fillMaxSize(fraction = 1f)
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Splash",
            style = TextStyle(
                fontSize = MaterialTheme.typography.h3.fontSize
            )
        )
    }
}