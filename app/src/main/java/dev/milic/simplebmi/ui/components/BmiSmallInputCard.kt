package dev.milic.simplebmi.ui.components

import androidx.compose.foundation.layout.*
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
import dev.milic.simplebmi.ui.theme.SMALL_PADDING

@Composable
fun BmiSmallInputCard(
    title: String,
    result: Int = 0,
    onMinusButtonClicked: () -> Unit,
    onPlusButtonClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .widthIn(
                min = 160.dp,
                max = 500.dp
            ),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = CARD_ELEVATION
    ) {
        Column(
            modifier = Modifier
                .padding(all = SMALL_PADDING),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    fontWeight = FontWeight(weight = 600)
                )
            )
            Text(
                text = result.toString(),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.h2.fontSize,
                    fontWeight = FontWeight(weight = 900)
                )
            )
            BmiIndicator()
        }
    }
}