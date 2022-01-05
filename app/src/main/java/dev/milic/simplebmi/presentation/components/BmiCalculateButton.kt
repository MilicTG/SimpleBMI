package dev.milic.simplebmi.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import dev.milic.simplebmi.presentation.theme.CARD_ELEVATION
import dev.milic.simplebmi.presentation.theme.SMALL_PADDING

@Composable
fun BmiCalculateButton(
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { onClick() },
        elevation = ButtonDefaults.elevation(
            defaultElevation = CARD_ELEVATION
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = "Calculate",
            style = TextStyle(
                fontSize = MaterialTheme.typography.subtitle2.fontSize,
                fontWeight = FontWeight(weight = 600)
            ),
            modifier = Modifier
                .padding(vertical = SMALL_PADDING)
        )
    }
}