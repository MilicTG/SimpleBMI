package dev.milic.simplebmi.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import dev.milic.simplebmi.ui.theme.TINY_PADDING

@Composable
fun BmiIndicator() {

    val primaryColor = MaterialTheme.colors.primary
    val onSurfaceColor = MaterialTheme.colors.onSurface

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
                .padding(TINY_PADDING)
        ) {
            val path = Path()
            path.moveTo(size.width, 0f)
            path.lineTo(size.width, size.height)
            path.lineTo(0f, size.height)

            drawPath(
                path = path,
                brush = SolidColor(primaryColor)
            )
        }
        Canvas(
            modifier = Modifier
                .size(90.dp)
        ) {
            drawLine(
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = 0f, y = 0f),
                color = onSurfaceColor
            )
        }
    }
}