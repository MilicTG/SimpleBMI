package dev.milic.simplebmi.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Smartphone
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.milic.simplebmi.presentation.navigation.BmiScreens
import dev.milic.simplebmi.presentation.components.BmiAboutAppDialog
import dev.milic.simplebmi.presentation.components.BmiSettingsAppbar
import dev.milic.simplebmi.presentation.components.BmiSettingsDialog
import dev.milic.simplebmi.presentation.components.BmiSettingsOptionsRow
import dev.milic.simplebmi.presentation.theme.LARGE_PADDING
import dev.milic.simplebmi.presentation.viewmodel.CalculatorViewModel
import kotlinx.coroutines.*

@DelicateCoroutinesApi
@Composable
fun BmiSettingsScreen(
    navController: NavHostController,
    calculatorViewModel: CalculatorViewModel = hiltViewModel()
) {

    val openUnitDialog = remember { mutableStateOf(false) }
    val openAboutAppDialog = remember { mutableStateOf(false) }
    val unitChecked by calculatorViewModel.unitSelectedState.collectAsState()

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

            //In Plan
//            BmiSettingsOptionsRow(
//                rowTitle = "Change units",
//                icon = Icons.Outlined.Thermostat,
//                onRowClicked = { openUnitDialog.value = it }
//            )

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
                    selectedSetting = unitChecked,
                    onSelectedSetting = {
                        calculatorViewModel.saveUnitRadioSelectorState(it)
                    },
                    closeDialog = {
                        openUnitDialog.value = false
                    }
                )
            }

            if (openAboutAppDialog.value) {
                BmiAboutAppDialog(
                    closeDialog = {
                        openAboutAppDialog.value = false
                    }
                )
            }

        }
    }
}