package dev.milic.simplebmi.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val LightColors = lightColors(
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

private val DarkColors = darkColors(
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
fun SimpleBMITheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}