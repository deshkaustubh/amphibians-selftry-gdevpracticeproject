package com.example.amphibians_selftry.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians_selftry.R
import com.example.amphibians_selftry.viewModel.AmphibiansViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { AmphibiansAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val marsViewModel: AmphibiansViewModel = viewModel()
            HomeScreen(
                amphibiansUiState = marsViewModel.amphibiansUiState,
                contentPadding = it
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}








//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Warning
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import coil.compose.SubcomposeAsyncImage
//import coil.request.ImageRequest
//import com.example.amphibians_selftry.viewModel.AmphibiansUiState
//import com.example.amphibians_selftry.viewModel.AmphibiansViewModel
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AmphibianApp(
//    modifier: Modifier = Modifier,
//    viewModel: AmphibiansViewModel
//) {
//    val uiState = viewModel.AmphibiansUiState.collectAsState().value
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        "Amphibians",
//                        style = MaterialTheme.typography.headlineMedium.copy(
//                            fontWeight = FontWeight.Bold
//                        )
//                    )
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
//                )
//            )
//        }
//    ) { paddingValues ->
//        Surface(
//            modifier = modifier.padding(paddingValues),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            when (uiState) {
//                is AmphibiansUiState.Loading -> {
//                    LoadingScreen()
//                }
//
//                is AmphibiansUiState.Error -> {
//                    ErrorScreen(message = uiState.message)
//                }
//
//                is AmphibiansUiState.Success -> {
//                    AmphibiansList(amphibians = uiState.amphibians)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun AmphibiansList(amphibians: List<Amphibian>) {
//    LazyColumn(
//        contentPadding = PaddingValues(16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        items(amphibians) { amphibian ->
//            AmphibianCard(amphibian = amphibian)
//        }
//    }
//}
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AmphibianCard(amphibian: Amphibians) {
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(12.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surface
//        )
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp)
//        ) {
//            // Header with name and type
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(8.dp)),
//                color = MaterialTheme.colorScheme.secondaryContainer
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(12.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(
//                        text = amphibian.name,
//                        style = MaterialTheme.typography.titleLarge.copy(
//                            fontWeight = FontWeight.Bold
//                        ),
//                        color = MaterialTheme.colorScheme.onSecondaryContainer
//                    )
//
//                    Surface(
//                        color = MaterialTheme.colorScheme.primary,
//                        shape = RoundedCornerShape(20.dp)
//                    ) {
//                        Text(
//                            text = amphibian.type,
//                            style = MaterialTheme.typography.bodyMedium,
//                            color = MaterialTheme.colorScheme.onPrimary,
//                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
//                        )
//                    }
//                }
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Image with loading and error states
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(8.dp))
//                    .border(
//                        width = 1.dp,
//                        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
//                        shape = RoundedCornerShape(8.dp)
//                    ),
//                contentAlignment = Alignment.Center
//            ) {
//                SubcomposeAsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(amphibian.imageUrl)
//                        .crossfade(true)
//                        .build(),
//                    contentDescription = "Image of ${amphibian.name}",
//                    contentScale = ContentScale.FillWidth,
//                    modifier = Modifier.fillMaxWidth(),
//                    loading = {
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(200.dp),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            CircularProgressIndicator(
//                                modifier = Modifier.size(40.dp),
//                                strokeWidth = 2.dp
//                            )
//                        }
//                    },
//                    error = {
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(200.dp),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                                Icon(
//                                    imageVector = Icons.Default.Warning,
//                                    contentDescription = "Error loading image",
//                                    tint = MaterialTheme.colorScheme.error
//                                )
//                                Spacer(modifier = Modifier.height(8.dp))
//                                Text(
//                                    "Failed to load image",
//                                    style = MaterialTheme.typography.bodyMedium,
//                                    color = MaterialTheme.colorScheme.error
//                                )
//                            }
//                        }
//                    }
//                )
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Description
//            Text(
//                text = amphibian.description,
//                textAlign = TextAlign.Justify,
//                style = MaterialTheme.typography.bodyLarge,
//                color = MaterialTheme.colorScheme.onSurface,
//                modifier = Modifier.padding(4.dp)
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun AmphibianPreview() {
//    // Create a sample amphibian for preview
//    val sampleAmphibian = Amphibian(
//        name = "Great Basin Spadefoot",
//        type = "Toad",
//        description = "This toad spends most of its life underground. It uses the spade on its hind feet to dig itself underground and create burrows where it can rest during dry conditions.",
//        imageUrl = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
//    )
//
//    AmphibianCard(amphibian = sampleAmphibian)
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun LoadingScreenPreview() {
//    LoadingScreen()
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun ErrorScreenPreview() {
//    ErrorScreen(message = "Failed to load amphibians data")
//}