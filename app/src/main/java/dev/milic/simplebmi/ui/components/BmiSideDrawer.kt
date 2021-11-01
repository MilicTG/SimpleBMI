package dev.milic.simplebmi.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import dev.milic.simplebmi.R
import dev.milic.simplebmi.ui.theme.DRAWER_SPACER_SIZE
import dev.milic.simplebmi.ui.theme.LARGE_PADDING
import dev.milic.simplebmi.ui.theme.SMALL_PADDING

@Composable
fun BmiSideDrawer() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
            .padding(
                start = SMALL_PADDING,
                top = LARGE_PADDING
            )
    ) {
        Text(
            text = stringResource(R.string.saved_calculations),
            style = TextStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.W300
            )
        )
        Spacer(
            modifier = Modifier
                .height(DRAWER_SPACER_SIZE)
        )
        Text(text = "Sample")
    }
}