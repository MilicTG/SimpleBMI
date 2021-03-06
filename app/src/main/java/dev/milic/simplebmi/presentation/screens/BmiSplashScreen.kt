package dev.milic.simplebmi.presentation.screens

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.milic.simplebmi.domain.util.Constants.HOME_GRAPH_ROUTE
import dev.milic.simplebmi.domain.util.Constants.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay
import dev.milic.simplebmi.R

@Composable
fun BmiSplashScreen(
    navController: NavHostController
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
        navController.navigate(HOME_GRAPH_ROUTE) {
            navController.popBackStack()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(fraction = 1f)
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
       Image(
           painter = painterResource(id = R.drawable.scale),
           contentDescription = "App icon",
           modifier = Modifier
               .size(120.dp)
       )
    }
}