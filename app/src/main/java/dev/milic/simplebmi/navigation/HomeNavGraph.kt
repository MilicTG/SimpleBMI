package dev.milic.simplebmi.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.google.accompanist.navigation.animation.composable
import dev.milic.simplebmi.ui.screens.BmiCalculatorScreen
import dev.milic.simplebmi.ui.screens.BmiSettingsScreen
import dev.milic.simplebmi.util.Constants.HOME_GRAPH_ROUTE

@ExperimentalAnimationApi
fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = BmiScreens.Calculator.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(
            route = BmiScreens.Calculator.route
        ) {
            BmiCalculatorScreen(
                navController = navController
            )
        }
        composable(
            route = BmiScreens.Settings.route
        ) {
            BmiSettingsScreen(
                navController = navController
            )
        }
    }
}