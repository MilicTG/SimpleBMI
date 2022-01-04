package dev.milic.simplebmi.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun BmiCalculationDialog(
    calculationResult: Int,
    closeDialog: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {
            closeDialog()
        },
        title = {
            Text(
                text = "Your BMI is $calculationResult"
            )
        },
        text = {
            Text(text = "You are in ${calculateWeightRange(calculationResult)} range.\n\nBMI weight ranges\n\nLess than 19 = Underweight\nBetween 19 - 25 = Healthy Weight\nBetween 25 - 30 = Overweight\nOver 30 = Obese\n")
        },
        confirmButton = {
            Button(
                onClick = {
                    closeDialog()
                },
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "Close",
                    style = TextStyle(
                        color = Color.White
                    )
                )
            }
        }
    )
}

private fun calculateWeightRange(result: Int): String {
    return when {
        result in 0..19 -> {
            "underweight"
        }
        result in 20..24 -> {
            "healthy weight"
        }
        result in 25..30 -> {
            "overweight"
        }
        result > 30 -> {
            "obese"
        }
        else -> "result not valid"
    }
}