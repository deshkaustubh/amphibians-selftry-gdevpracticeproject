# Amphibians Android App

This project is a modern Android application built with Kotlin and Jetpack Compose that fetches and displays detailed information about amphibians from a REST API.

## Project Overview

The app demonstrates:
- Modern Android architecture (MVVM with Repository pattern)
- Jetpack Compose for declarative UI
- Dependency Injection pattern with AppContainer
- Clean separation of concerns with well-organized package structure
- Asynchronous data fetching from a remote API
- Error handling and loading state management

## API Used
This app fetches amphibian data from:
[https://android-kotlin-fun-mars-server.appspot.com/amphibians](https://android-kotlin-fun-mars-server.appspot.com/amphibians)

The API returns a JSON array with information about various amphibians including their name, type, description, and image URL.

## Project Architecture

```
┌─────────────────────┐     ┌─────────────────────┐     ┌─────────────────────┐
│                     │     │                     │     │                     │
│      UI Layer       │────▶│   ViewModel Layer   │────▶│    Data Layer       │
│  (Jetpack Compose)  │◀────│  (State Handling)   │◀────│ (Repository & API)  │
│                     │     │                     │     │                     │
└─────────────────────┘     └─────────────────────┘     └─────────────────────┘
```

### Detailed Flow

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│                 │     │                 │     │                 │     │                 │
│  AmphibiansApp  │────▶│   HomeScreen   │────▶│ AmphibiansView  │────▶│ AmphibiansRepo  │────┐
│    (View)       │◀────│    (View)      │◀────│    Model        │◀────│   sitory        │◀───┘
│                 │     │                 │     │                 │     │                 │
└─────────────────┘     └─────────────────┘     └─────────────────┘     └─────────────────┘
                                                                               │
                                                                               ▼
                                                                        ┌─────────────────┐
                                                                        │                 │
                                                                        │  Amphibians API │
                                                                        │  Service        │
                                                                        │                 │
                                                                        └─────────────────┘
```

## Package Structure

- **com.example.amphibians_selftry**
  - **AmphibiansApplication.kt**: Application class for dependency injection setup
  - **MainActivity.kt**: Entry point for the application
  - **data/**
    - **AmphibiansRepository.kt**: Repository that manages data operations
    - **AppContainer.kt**: Dependency injection container
  - **network/**
    - **AmphibiansApiService.kt**: Retrofit service for API calls
    - **AmphibiansDataClass.kt**: Data classes representing API response
  - **ui/**
    - **theme/**: Contains styling and theming for Jetpack Compose
  - **view/**
    - **AmphibiansApp.kt**: Main composable that sets up the app UI
    - **HomeScreen.kt**: Screen composable that displays amphibian data
  - **viewModel/**
    - **AmphibiansViewModel.kt**: ViewModel that manages UI state and business logic

## Key Components

### UI Layer
The UI layer is built with Jetpack Compose and consists of:
- **AmphibiansApp.kt**: The root composable that sets up the navigation and theme
- **HomeScreen.kt**: Displays the list of amphibians with images and details

### ViewModel Layer
- **AmphibiansViewModel.kt**: Manages UI state (loading, success, error) and communicates with the repository
  - Exposes data as state for the UI to observe
  - Handles user interactions and triggers data operations

### Data Layer
- **AmphibiansRepository.kt**: Single source of truth for data
  - Manages data fetching from the API
  - Handles caching if implemented
- **AmphibiansApiService.kt**: Defines API endpoints using Retrofit
- **AmphibiansDataClass.kt**: Kotlin data classes that model the API response

### Dependency Injection
- **AmphibiansApplication.kt**: Sets up the application-level dependencies
- **AppContainer.kt**: Manages the creation and lifetime of dependencies

## Technology Stack

- **Kotlin**: Modern programming language for Android
- **Jetpack Compose**: Declarative UI toolkit
- **ViewModel**: Lifecycle-aware data holder
- **Retrofit**: Type-safe HTTP client for API calls
- **Coil**: Image loading library for Compose
- **Coroutines**: For asynchronous programming
- **Dependency Injection**: Custom implementation with AppContainer

## Getting Started

1. Clone the repository
2. Open the project in Android Studio
3. Run the app on an emulator or physical device

## Future Improvements

- Implement local caching with Room database
- Add offline support
- Enhance UI with animations and transitions
- Add search functionality
- Implement unit and UI tests
