package dev.milic.simplebmi.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.milic.simplebmi.ui.theme.CARD_ELEVATION
import dev.milic.simplebmi.ui.theme.MEDIUM_PADDING

@Composable
fun BmiHeightInputCard(
    result: Int = 0,
    onValueChanged: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = CARD_ELEVATION
    ) {
        Column(
            modifier = Modifier
                .padding(all = MEDIUM_PADDING),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Height",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    fontWeight = FontWeight(weight = 600)
                )
            )
            Text(
                text = "cm",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.caption.fontSize,
                    fontWeight = FontWeight(weight = 200)
                )
            )
            Text(text = result.toString())
            
        }
    }
}