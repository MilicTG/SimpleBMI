package dev.milic.simplebmi.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.milic.simplebmi.ui.theme.CARD_ELEVATION
import dev.milic.simplebmi.ui.theme.LARGE_PADDING
import dev.milic.simplebmi.ui.theme.MEDIUM_PADDING
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
                .padding(all = MEDIUM_PADDING),
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
            Row(
                modifier = Modifier
                    .widthIn(
                        min = 150.dp,
                        max = 500.dp
                    )
                    .padding(
                        all = SMALL_PADDING
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BmiPlusOrMinusButton(
                    icon = Icons.Filled.Remove,
                    description = "Subtract",
                    onButtonPressed = {
                        onMinusButtonClicked()
                    }
                )
                Spacer(
                    modifier = Modifier
                        .width(16.dp)
                )
                BmiPlusOrMinusButton(
                    icon = Icons.Filled.Add,
                    description = "Add",
                    onButtonPressed = {
                        onPlusButtonClicked()
                    }
                )
            }
        }
    }
}