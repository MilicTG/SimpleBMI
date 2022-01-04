package dev.milic.simplebmi.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.milic.simplebmi.presentation.navigation.SetupNavGraph
import dev.milic.simplebmi.presentation.theme.BmiTheme
import dev.milic.simplebmi.presentation.viewmodel.CalculatorViewModel
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
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
                    context = this,
                    navController = navController,
                    calculatorViewModel = calculatorViewModel,
                )
            }
        }
    }
}

