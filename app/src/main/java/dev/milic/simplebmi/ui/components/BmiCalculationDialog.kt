package dev.milic.simplebmi.ui.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

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
                text = "Your BMI calculation is $calculationResult"
            )
        },
        text = {
            Text(text = "Severe Thinness < 16\nModerate Thinness 16 - 17\nMild Thinness 17 - 19\nNormal 19 - 25\nOverweight 25 - 30\nObese Class I 30 - 35\nObese Class II 35 - 40\nObese Class III > 40")
        },
        confirmButton = {
            Button(
                onClick = {
                    closeDialog()
                }
            ) {
                Text(
                    text = "Close"
                )
            }
        }
    )
}