package com.example.amphibians_selftry.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians_selftry.networking.Amphibians
import com.example.amphibians_selftry.networking.AmphibiansApiService
import com.example.amphibians_selftry.viewModel.AmphibianUiState
import com.example.amphibians_selftry.viewModel.AmphibianViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianApp(
    modifier: Modifier = Modifier,
    viewModel: AmphibianViewModel
) {
    val uiState = viewModel.amphibianUiState
    Column(modifier = modifier) {
        TopAppBar(
            title = {
                Text("Amphibians", style = MaterialTheme.typography.titleLarge)
            }
        )
        when (uiState) {
            is AmphibianUiState.Loading -> {
                Text("Loading...", modifier = Modifier.padding(16.dp))
            }
            is AmphibianUiState.Error -> {
                Text("Error loading amphibians.", modifier = Modifier.padding(16.dp))
            }
            is AmphibianUiState.Success -> {
                LazyColumn {
                    items(uiState.photos) { amphibian ->
                        AmphibianCard(amphibians = amphibian)
                    }
                }
            }
        }
    }
}

@Composable
fun AmphibianCard(amphibians: Amphibians) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {

        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = amphibians.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = amphibians.type,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibians.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = "Amphibian Image",
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = amphibians.description,
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun AmphibianPreview() {
//    AmphibianCard()
}