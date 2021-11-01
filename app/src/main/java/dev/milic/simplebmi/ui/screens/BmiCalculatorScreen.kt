package dev.milic.simplebmi.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController
import dev.milic.simplebmi.navigation.BmiScreens
import dev.milic.simplebmi.ui.components.BmiSideDrawer
import dev.milic.simplebmi.ui.components.BmiTopAppbar
import kotlinx.coroutines.launch

@Composable
fun BmiCalculatorScreen(
    navController: NavHostController
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
                    .fillMaxSize(fraction = 1f)
                    .background(MaterialTheme.colors.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Calculator",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.h3.fontSize,
                    )
                )
            }
        }
    }
}
