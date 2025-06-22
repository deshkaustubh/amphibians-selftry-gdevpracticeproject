package com.example.amphibians_selftry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.amphibians_selftry.ui.theme.AmphibiansselftryTheme
import com.example.amphibians_selftry.view.AmphibianApp
import com.example.amphibians_selftry.viewModel.AmphibiansViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: AmphibiansViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the AppContainer from the Application class
        val appContainer = (application as AmphibiansApplication).appContainer

        // Get the repository from the app container
        val repository = appContainer.amphibiansRepository

        // Create the ViewModel using the factory with the repository dependency
        val factory = AmphibiansViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[AmphibiansViewModel::class.java]

        // Set up the Compose UI
        setContent {
            AmphibiansselftryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AmphibianApp(
                        modifier = Modifier.fillMaxSize(),
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