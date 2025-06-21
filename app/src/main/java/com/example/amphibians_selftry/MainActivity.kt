package com.example.amphibians_selftry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.amphibians_selftry.networking.Amphibians
import com.example.amphibians_selftry.ui.theme.AmphibiansselftryTheme
import com.example.amphibians_selftry.view.AmphibianApp
import com.example.amphibians_selftry.viewModel.AmphibianViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: AmphibianViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AmphibiansselftryTheme {
                Surface {
                    AmphibianApp(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AmphibiansselftryTheme {
        Greeting("Android")
    }
}