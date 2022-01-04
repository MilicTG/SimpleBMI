package dev.milic.simplebmi.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.unit.dp
import dev.milic.simplebmi.presentation.theme.SMALL_PADDING

@Composable
fun BmiIndicator() {

    val primaryColor = MaterialTheme.colors.primary

    Row(
        modifier = Modifier
            .padding(vertical = SMALL_PADDING),
        horizontalArrangement = Arrangement.Center
    ) {
        Canvas(
            modifier = Modifier
                .padding(SMALL_PADDING)
                .height(2.dp)
                .width(90.dp)
        ) {
            drawRoundRect(
                color = primaryColor,
                cornerRadius = CornerRadius(x = 10f, y = 10f)
            )
        }
    }
}