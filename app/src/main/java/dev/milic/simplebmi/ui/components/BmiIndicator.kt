package dev.milic.simplebmi.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.unit.dp
import dev.milic.simplebmi.ui.theme.SMALL_PADDING

@Composable
fun BmiIndicator() {

    val primaryColor = MaterialTheme.colors.primary

    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        Canvas(
            modifier = Modifier
                .padding(SMALL_PADDING)
                .height(2.dp)
                .width(100.dp)
        ) {
            drawRoundRect(
                color = primaryColor,
                cornerRadius = CornerRadius(x = 10f, y = 10f)
            )
        }
    }
}