package dev.milic.simplebmi.navigation

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.google.accompanist.navigation.animation.composable
import dev.milic.simplebmi.ui.screens.BmiCalculatorScreen
import dev.milic.simplebmi.ui.screens.BmiSettingsScreen
import dev.milic.simplebmi.ui.viewmodel.CalculatorViewModel
import dev.milic.simplebmi.util.Constants.HOME_GRAPH_ROUTE
import dev.milic.simplebmi.util.DataStoreManager

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.homeNavGraph(
    context: Context,
    navController: NavHostController,
    calculatorViewModel: CalculatorViewModel,
    dataStoreManager: DataStoreManager
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
                dataStoreManager = dataStoreManager
            )
        }
    }
}