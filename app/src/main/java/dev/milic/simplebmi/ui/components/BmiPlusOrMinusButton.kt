package dev.milic.simplebmi.ui.components

import androidx.compose.material.icons.Icons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


@Composable
fun BmiPlusOrMinusButton(
    icon: Icons,
    description: String,
    onButtonPressed: () -> Unit
) {
    OutlinedButton(
        onClick = { onButtonPressed },
        border = BorderStroke(1.dp, MaterialTheme.colors.onSurface),
        shape = CircleShape,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colors.onSurface
        )
    ) {
//        Icon(
//            icon,
//            contentDescription = description
//        )
    }
}