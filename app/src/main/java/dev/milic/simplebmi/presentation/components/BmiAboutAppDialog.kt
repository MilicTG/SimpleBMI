package dev.milic.simplebmi.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import dev.milic.simplebmi.BuildConfig
import dev.milic.simplebmi.domain.util.Constants.DEV_EMAIL
import dev.milic.simplebmi.domain.util.Constants.DEV_NAME

@Composable
fun BmiAboutAppDialog(
    closeDialog: () -> Unit
) {

    val appVersion = BuildConfig.VERSION_NAME

    AlertDialog(
        onDismissRequest = { closeDialog() },
        title = {
            Text(
                text = "About App"
            )
        },
        text = {
            Column {
                Text(text = "App author: $DEV_NAME")
                Text(text = "Dev e-mail: $DEV_EMAIL")
                Text(text = "App version: $appVersion")
            }
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