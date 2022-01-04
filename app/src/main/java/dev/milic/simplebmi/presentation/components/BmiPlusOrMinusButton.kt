package dev.milic.simplebmi.presentation.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun BmiPlusOrMinusButton(
    icon: ImageVector,
    description: String,
    onButtonPressed: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .size(50.dp),
        onClick = {
            onButtonPressed()
        },
        border = BorderStroke(
            1.dp, MaterialTheme.colors.onSurface
        ),
        shape = CircleShape,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colors.onSurface
        )
    ) {
        Icon(
            icon,
            contentDescription = description,
            tint = MaterialTheme.colors.onSurface
        )
    }
}