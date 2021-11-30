package dev.milic.simplebmi.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import dev.milic.simplebmi.ui.viewmodel.CalculatorViewModel
import dev.milic.simplebmi.util.Constants.ROOT_GRAPH_ROUTE
import dev.milic.simplebmi.util.Constants.SPLASH_GRAPH_ROUTE

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    calculatorViewModel: CalculatorViewModel
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = SPLASH_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        splashNavGraph(
            navController = navController
        )
        homeNavGraph(
            navController = navController,
            calculatorViewModel = calculatorViewModel
        )
    }
}
