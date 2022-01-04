package dev.milic.simplebmi.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val LightColorsTheme = lightColors(
    primary = LightPrimaryColor,
    secondary = LightSecondaryColor,
    background = LightBackgroundColor,
    surface = LightSurfaceColor,
    error = LightErrorColor,
    onPrimary = LightOnPrimaryColor,
    onSecondary = LightOnSecondaryColor,
    onBackground = LightOnBackgroundColor,
    onSurface = LightOnSurfaceColor,
    onError = LightOnErrorColor
)

private val DarkColorsTheme = darkColors(
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
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        if (darkTheme) {
            systemUiController.setStatusBarColor(
                color = DarkBackgroundColor,
                darkIcons = false
            )
        } else {
            systemUiController.setStatusBarColor(
                color = LightBackgroundColor,
                darkIcons = true
            )
        }
    }

    val colors = if (darkTheme) {
        DarkColorsTheme
    } else {
        LightColorsTheme
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
