package dev.milic.simplebmi.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.milic.simplebmi.presentation.theme.CARD_ELEVATION
import dev.milic.simplebmi.presentation.theme.EXTRA_LARGE_PADDING
import dev.milic.simplebmi.presentation.theme.MEDIUM_PADDING

@Composable
fun BmiGenderCard(
    image: ImageBitmap,
    gender: String?,
    onCardClicked: () -> Unit,
    isSelected: Boolean? = false
) {
    Card(
        backgroundColor = if (isSelected == true) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        elevation = CARD_ELEVATION,
        modifier = Modifier
            .wrapContentSize()
            .clickable {
                onCardClicked()
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                image,
                contentDescription = gender,
                modifier = Modifier
                    .padding(EXTRA_LARGE_PADDING)
                    .size(90.dp)
            )
            Text(
                text = gender!!,
                modifier = Modifier
                    .padding(bottom = MEDIUM_PADDING),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    fontWeight = FontWeight(weight = 600)
                )
            )
        }

    }
}