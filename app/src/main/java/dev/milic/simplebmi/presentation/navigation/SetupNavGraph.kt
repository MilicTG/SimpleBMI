package dev.milic.simplebmi.presentation.navigation

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import dev.milic.simplebmi.presentation.viewmodel.CalculatorViewModel
import dev.milic.simplebmi.domain.util.Constants.ROOT_GRAPH_ROUTE
import dev.milic.simplebmi.domain.util.Constants.SPLASH_GRAPH_ROUTE

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
    context: Context,
    navController: NavHostController,
    calculatorViewModel: CalculatorViewModel,
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
            context = context,
            navController = navController,
            calculatorViewModel = calculatorViewModel,
        )
    }
}
