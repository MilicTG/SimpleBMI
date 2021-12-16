package dev.milic.simplebmi.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import dev.milic.simplebmi.R
import dev.milic.simplebmi.navigation.BmiScreens
import dev.milic.simplebmi.ui.components.*
import dev.milic.simplebmi.ui.theme.EXTRA_LARGE_PADDING
import dev.milic.simplebmi.ui.theme.LARGE_PADDING
import dev.milic.simplebmi.ui.viewmodel.CalculatorViewModel
import kotlin.math.roundToInt

@ExperimentalComposeUiApi
@Composable
fun BmiCalculatorScreen(
    context: Context,
    navController: NavHostController,
    calculatorViewModel: CalculatorViewModel
) {
    val femaleIcon: ImageBitmap = ImageBitmap.imageResource(R.drawable.female)
    val maleIcon: ImageBitmap = ImageBitmap.imageResource(R.drawable.male)

    val ageValue = calculatorViewModel.ageCounter.observeAsState(initial = 0)
    val weightValue = calculatorViewModel.weightCounter.observeAsState(initial = 0)

    val isFemaleIconSelected = calculatorViewModel.isFemaleIconSelected.observeAsState()
    val isMaleIconSelected = calculatorViewModel.isMaleIconSelected.observeAsState()

    val openDialog = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            BmiTopAppbar(
                settingsIcon = Icons.Filled.Settings,
                onSettingsIconClicked = {
                    navController.navigate(BmiScreens.Settings.route)
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
                )
                .verticalScroll(rememberScrollState()),
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
                    value = calculatorViewModel.heightCounter.value,
                    onValueChanged = { height ->
                        calculatorViewModel.updateHeightCounter(height)
                    }
                )
            }
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxWidth()
                    .padding(
                        bottom = EXTRA_LARGE_PADDING
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BmiGenderCard(
                    image = femaleIcon,
                    gender = "Female",
                    onCardClicked = {
                        calculatorViewModel.changeGenderCardState()
                    },
                    isSelected = isFemaleIconSelected.value
                )
                BmiGenderCard(
                    image = maleIcon,
                    gender = "Male",
                    onCardClicked = {
                        calculatorViewModel.changeGenderCardState()
                    },
                    isSelected = isMaleIconSelected.value
                )
            }
            BmiCalculateButton(
                onClick = {
                    openDialog.value = true
                }
            )
            if (openDialog.value) {
                BmiCalculationDialog(
                    calculationResult = calculatorViewModel.calculateBMI().roundToInt(),
                    closeDialog = {
                        openDialog.value = false
                    }
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
