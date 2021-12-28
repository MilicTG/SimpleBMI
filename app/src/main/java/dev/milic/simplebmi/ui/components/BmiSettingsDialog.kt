package dev.milic.simplebmi.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import dev.milic.simplebmi.ui.theme.LARGE_PADDING


@Composable
fun BmiSettingsDialog(
    dialogTitle: String,
    settingsTextOne: String,
    settingsTextTwo: String,
    onSelectedSetting: (String) -> Unit,
    closeDialog: () -> Unit
) {
    val radioOptions = listOf(settingsTextOne, settingsTextTwo)
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }


    AlertDialog(
        onDismissRequest = { closeDialog() },
        title = {
            Text(
                text = dialogTitle
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                radioOptions.forEach { text ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = {
                                    onOptionSelected(text)
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = {
                                onOptionSelected(text)
                            }
                        )
                        Text(
                            text = text,
                            modifier = Modifier
                                .padding(
                                    start = LARGE_PADDING,
                                )
                        )
                    }
                }
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
                    text = "Save",
                    style = TextStyle(
                        color = Color.White
                    )
                )
            }
        }
    )
}