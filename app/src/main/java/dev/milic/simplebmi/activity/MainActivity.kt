package dev.milic.simplebmi.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import dev.milic.simplebmi.ui.theme.BmiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(name = "Halid")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        style = TextStyle(
            fontSize = MaterialTheme.typography.h4.fontSize
        )

    )
}

