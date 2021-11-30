package dev.milic.simplebmi.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import dev.milic.simplebmi.navigation.BmiScreens
import dev.milic.simplebmi.ui.components.BmiHeightInputCard
import dev.milic.simplebmi.ui.components.BmiSmallInputCard
import dev.milic.simplebmi.ui.components.BmiTopAppbar
import dev.milic.simplebmi.ui.theme.LARGE_PADDING
import dev.milic.simplebmi.ui.viewmodel.CalculatorViewModel
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@Composable
fun BmiCalculatorScreen(
    navController: NavHostController,
    calculatorViewModel: CalculatorViewModel
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

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
                settingsIcon = Icons.Filled.Settings,
                onSettingsIconClicked = {
                    navController.navigate(BmiScreens.Settings.route)
                    closeDrawer()
                }
            )
        }
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
                    },
                    id = "cardOne"
                )
                BmiSmallInputCard(
                    title = "Weight",
                    result = weightValue.value,
                    onMinusButtonClicked = {
                        calculatorViewModel.decreaseWeight()
                    },
                    onPlusButtonClicked = {
                        calculatorViewModel.increaseWeight()
                    },
                    id = "cardTwo"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = LARGE_PADDING
                    )
            ) {
                BmiHeightInputCard(
                    onValueChanged = {}
                )
            }


        }
    }

}


private fun decoupledConstraints(): ConstraintSet {
    return ConstraintSet {
        val cardOne = createRefFor("cardOne")
        val cardTwo = createRefFor("cardTwo")

        constrain(cardOne) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(cardTwo.start)
        }
        constrain(cardTwo) {
            top.linkTo(parent.top)
            start.linkTo(cardOne.end)
            end.linkTo(parent.end)
        }
    }
}
