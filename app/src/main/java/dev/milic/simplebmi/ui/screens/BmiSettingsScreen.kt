package dev.milic.simplebmi.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Draw
import androidx.compose.material.icons.outlined.Smartphone
import androidx.compose.material.icons.outlined.Thermostat
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import dev.milic.simplebmi.navigation.BmiScreens
import dev.milic.simplebmi.ui.components.BmiAboutAppDialog
import dev.milic.simplebmi.ui.components.BmiSettingsAppbar
import dev.milic.simplebmi.ui.components.BmiSettingsDialog
import dev.milic.simplebmi.ui.components.BmiSettingsOptionsRow
import dev.milic.simplebmi.ui.theme.LARGE_PADDING

@Composable
fun BmiSettingsScreen(
    navController: NavHostController
) {

    val openUnitDialog = remember { mutableStateOf(false) }
    val openThemeDialog = remember { mutableStateOf(false) }
    val openAboutAppDialog = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            BmiSettingsAppbar(
                onBackIconClicked = {
                    navController.navigate(BmiScreens.Calculator.route)
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(
                modifier = Modifier
                    .height(LARGE_PADDING)
            )

            BmiSettingsOptionsRow(
                rowTitle = "Change units",
                icon = Icons.Outlined.Thermostat,
                onRowClicked = { openUnitDialog.value = it }
            )

            BmiSettingsOptionsRow(
                rowTitle = "Change theme",
                icon = Icons.Outlined.Draw,
                onRowClicked = { openThemeDialog.value = it }
            )

            BmiSettingsOptionsRow(
                rowTitle = "About app",
                icon = Icons.Outlined.Smartphone,
                onRowClicked = { openAboutAppDialog.value = it }
            )

            if (openUnitDialog.value) {
                BmiSettingsDialog(
                    dialogTitle = "Choose your units",
                    settingsTextOne = "Metric",
                    settingsTextTwo = "Imperial",
                    onSelectedSetting = {},
                    closeDialog = {
                        openUnitDialog.value = false
                    }
                )
            }

            if (openThemeDialog.value) {
                BmiSettingsDialog(
                    dialogTitle = "Choose your theme",
                    settingsTextOne = "Light",
                    settingsTextTwo = "Dark",
                    onSelectedSetting = {},
                    closeDialog = {
                        openThemeDialog.value = false
                    }
                )
            }

            if (openAboutAppDialog.value) {
                BmiAboutAppDialog(
                    closeDialog = {
                        openThemeDialog.value = false
                    }
                )
            }

        }
    }
}