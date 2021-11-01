package dev.milic.simplebmi.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import dev.milic.simplebmi.R

@Composable
fun BmiTopAppbar(
    title: String = stringResource(R.string.simple_bmi),
    navIcon: ImageVector,
    settingsIcon: ImageVector,
    onNavIconClicked: () -> Unit,
    onSettingsIconClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title
            )
        },
        backgroundColor = MaterialTheme.colors.surface,
        navigationIcon = {
            IconButton(
                onClick = { onNavIconClicked() }
            ) {
                Icon(
                    navIcon,
                    contentDescription = ""
                )
            }
        },
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