package dev.milic.simplebmi.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navigation
import dev.milic.simplebmi.ui.screens.BmiSplashScreen
import dev.milic.simplebmi.util.Constants.SPLASH_GRAPH_ROUTE

@ExperimentalAnimationApi
fun NavGraphBuilder.splashNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = BmiScreens.Splash.route,
        route = SPLASH_GRAPH_ROUTE
    ) {
        composable(
            route = BmiScreens.Splash.route
        ) {
            BmiSplashScreen(
                navController = navController
            )
        }
    }

}