package dev.milic.simplebmi.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController
import dev.milic.simplebmi.navigation.BmiScreens
import dev.milic.simplebmi.ui.components.BmiSideDrawer
import dev.milic.simplebmi.ui.components.BmiSmallInputCard
import dev.milic.simplebmi.ui.components.BmiTopAppbar
import dev.milic.simplebmi.ui.theme.LARGE_PADDING
import dev.milic.simplebmi.ui.theme.SMALL_PADDING
import dev.milic.simplebmi.ui.viewmodel.CalculatorViewModel
import kotlinx.coroutines.launch

@Composable
fun BmiCalculatorScreen(
    navController: NavHostController,
    calculatorViewModel: CalculatorViewModel
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val openDrawer = {
        scope.launch {
            drawerState.open()
        }
    }
    val closeDrawer = {
        scope.launch {
            drawerState.close()
        }
    }

    val ageValue = calculatorViewModel.ageCounter.observeAsState(initial = 0)
    val weightValue = calculatorViewModel.weightCounter.observeAsState(initial = 0)

    Scaffold(
        topBar = {
            BmiTopAppbar(
                navIcon = Icons.Filled.Menu,
                settingsIcon = Icons.Filled.Settings,
                onNavIconClicked = {
                    if (drawerState.isOpen) {
                        closeDrawer()
                    }
                    openDrawer()
                },
                onSettingsIconClicked = {
                    navController.navigate(BmiScreens.Settings.route)
                    closeDrawer()
                }
            )
        }
    ) {
        ModalDrawer(
            drawerState = drawerState,
            drawerContent = { BmiSideDrawer() }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                    .padding(
                        all = LARGE_PADDING
                    ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BmiSmallInputCard(
                        title = "Age",
                        result = ageValue.value,
                        onMinusButtonClicked = {
                            calculatorViewModel.decreaseAge()
                        },
                        onPlusButtonClicked = {
                            calculatorViewModel.increaseAge()
                        }
                    )
                    BmiSmallInputCard(
                        title = "Weight",
                        result = weightValue.value,
                        onMinusButtonClicked = {
                            calculatorViewModel.decreaseWeight()
                        },
                        onPlusButtonClicked = {
                            calculatorViewModel.increaseWeight()
                        }
                    )
                }
            }
        }
    }
}
