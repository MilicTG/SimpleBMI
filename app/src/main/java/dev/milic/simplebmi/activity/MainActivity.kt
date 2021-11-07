package dev.milic.simplebmi.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.milic.simplebmi.navigation.SetupNavGraph
import dev.milic.simplebmi.ui.theme.BmiTheme
import dev.milic.simplebmi.ui.viewmodel.CalculatorViewModel

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    private val calculatorViewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiTheme {
                navController = rememberAnimatedNavController()
                SetupNavGraph(
                    navController = navController,
                    calculatorViewModel = calculatorViewModel
                )
            }
        }
    }
}

