package dev.milic.simplebmi.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import dev.milic.simplebmi.presentation.theme.LARGE_PADDING

@Composable
fun BmiCalculateButton(
    onClick: () -> Unit
) {
    Box(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Calculate",
            style = TextStyle(
                fontSize = MaterialTheme.typography.subtitle2.fontSize,
                fontWeight = FontWeight(weight = 600)
            ),
            modifier = Modifier
                .padding(vertical = LARGE_PADDING)
        )
    }
}