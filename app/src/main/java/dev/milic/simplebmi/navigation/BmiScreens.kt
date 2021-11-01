package dev.milic.simplebmi.navigation

sealed class BmiScreens(val route: String) {
    object Splash : BmiScreens(route = "splash_screen")
    object Calculator : BmiScreens(route = "calculator_screen")
    object Settings : BmiScreens(route = "settings_screen")
}