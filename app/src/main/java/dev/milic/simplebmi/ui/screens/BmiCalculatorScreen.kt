package dev.milic.simplebmi.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController

@Composable
fun BmiCalculatorScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize(fraction = 1f)
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Calculator",
            style = TextStyle(
                fontSize = MaterialTheme.typography.h3.fontSize
            )
        )
    }
}
