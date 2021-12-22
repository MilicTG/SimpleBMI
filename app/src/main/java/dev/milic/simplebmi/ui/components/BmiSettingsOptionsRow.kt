package dev.milic.simplebmi.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import dev.milic.simplebmi.ui.theme.LARGE_PADDING
import dev.milic.simplebmi.ui.theme.MEDIUM_PADDING

@Composable
fun BmiSettingsOptionsRow(
    rowTitle: String,
    icon: ImageVector,
    onRowClicked: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onRowClicked(true)
            }
            .padding(
                all = LARGE_PADDING,
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = rowTitle,
            modifier = Modifier
                .padding(end = MEDIUM_PADDING)
        )

        Text(
            text = rowTitle,
            style = TextStyle(
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontStyle = MaterialTheme.typography.caption.fontStyle
            )
        )
    }
}