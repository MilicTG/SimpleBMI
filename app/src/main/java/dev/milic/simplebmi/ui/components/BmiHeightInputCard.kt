package dev.milic.simplebmi.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import dev.milic.simplebmi.ui.theme.CARD_ELEVATION
import dev.milic.simplebmi.ui.theme.MEDIUM_PADDING
import dev.milic.simplebmi.ui.theme.TINY_PADDING
import kotlin.math.roundToInt
import kotlin.math.roundToLong

@Composable
fun BmiHeightInputCard(
    value: Int?,
    onValueChanged: (Int) -> Unit
) {
    var sliderPosition by remember { mutableStateOf(value?.toFloat()) }
    val start = 50f
    val end = 250f

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
            Text(text = sliderPosition?.roundToLong().toString())
            Slider(
                value = sliderPosition!!,
                onValueChange = {
                    onValueChanged(it.roundToInt())
                    sliderPosition = it
                },
                valueRange = start..end,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = TINY_PADDING),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "min: ${start.roundToInt()}",
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = "max: ${end.roundToInt()}",
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}