package dev.milic.simplebmi.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import dev.milic.simplebmi.R

@Composable
fun BmiTopAppbar(
    title: String = stringResource(R.string.simple_bmi),
    settingsIcon: ImageVector,
    onSettingsIconClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        actions = {
            IconButton(
                onClick = { onSettingsIconClicked() }
            ) {
                Icon(
                    settingsIcon,
                    contentDescription = ""
                )
            }
        }
    )
}