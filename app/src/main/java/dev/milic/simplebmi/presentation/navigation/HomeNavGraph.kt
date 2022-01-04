package dev.milic.simplebmi.presentation.navigation

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.google.accompanist.navigation.animation.composable
import dev.milic.simplebmi.presentation.screens.BmiCalculatorScreen
import dev.milic.simplebmi.presentation.screens.BmiSettingsScreen
import dev.milic.simplebmi.presentation.viewmodel.CalculatorViewModel
import dev.milic.simplebmi.domain.util.Constants.HOME_GRAPH_ROUTE

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.homeNavGraph(
    context: Context,
    navController: NavHostController,
    calculatorViewModel: CalculatorViewModel,
) {
    navigation(
        startDestination = BmiScreens.Calculator.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(
            route = BmiScreens.Calculator.route
        ) {
            BmiCalculatorScreen(
                context = context,
                navController = navController,
                calculatorViewModel = calculatorViewModel
            )
        }
        composable(
            route = BmiScreens.Settings.route
        ) {
            BmiSettingsScreen(
                navController = navController,
                calculatorViewModel = calculatorViewModel,
            )
        }
    }
}