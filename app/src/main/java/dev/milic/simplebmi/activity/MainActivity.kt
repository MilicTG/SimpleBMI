package dev.milic.simplebmi.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dev.milic.simplebmi.navigation.SetupNavGraph
import dev.milic.simplebmi.ui.theme.BmiTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiTheme {
                navController = rememberAnimatedNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

