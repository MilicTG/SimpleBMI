package dev.milic.simplebmi.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val BmiColorsTheme = darkColors(
    primary = DarkPrimaryColor,
    secondary = DarkSecondaryColor,
    background = DarkBackgroundColor,
    surface = DarkSurfaceColor,
    error = DarkErrorColor,
    onPrimary = DarkOnPrimaryColor,
    onSecondary = DarkOnSecondaryColor,
    onBackground = DarkOnBackgroundColor,
    onSurface = DarkOnSurfaceColor,
    onError = DarkOnErrorColor
)

@Composable
fun BmiTheme(
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
            systemUiController.setStatusBarColor(
                color = DarkBackgroundColor,
                darkIcons = false
            )
    }

    MaterialTheme(
        colors = BmiColorsTheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
