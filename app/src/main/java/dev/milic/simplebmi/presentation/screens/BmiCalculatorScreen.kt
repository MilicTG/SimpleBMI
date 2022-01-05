package dev.milic.simplebmi.presentation.screens

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.milic.simplebmi.R
import dev.milic.simplebmi.presentation.navigation.BmiScreens
import dev.milic.simplebmi.presentation.components.*
import dev.milic.simplebmi.presentation.theme.EXTRA_LARGE_PADDING
import dev.milic.simplebmi.presentation.theme.LARGE_PADDING
import dev.milic.simplebmi.presentation.theme.SMALL_PADDING
import dev.milic.simplebmi.presentation.viewmodel.CalculatorViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlin.math.roundToInt

@DelicateCoroutinesApi
@ExperimentalComposeUiApi
@Composable
fun BmiCalculatorScreen(
    navController: NavHostController,
    calculatorViewModel: CalculatorViewModel = hiltViewModel()
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
                    start = LARGE_PADDING,
                    end = LARGE_PADDING,
                    bottom = SMALL_PADDING
                )
                .verticalScroll(rememberScrollState()),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = SMALL_PADDING),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BmiSmallInputCard(
                    modifier = Modifier
                        .weight(1.0f, true),
                    title = "Age",
                    result = ageValue.value.toInt(),
                    onMinusButtonClicked = {
                        calculatorViewModel.decreaseAge()
                    },
                    onPlusButtonClicked = {
                        calculatorViewModel.increaseAge()
                    },
                    id = "cardOne"
                )
                BmiSmallInputCard(
                    modifier = Modifier
                        .weight(1f, true), title = "Weight",
                    result = weightValue.value.toInt(),
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
                    value = calculatorViewModel.heightCounter.value?.toInt(),
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
