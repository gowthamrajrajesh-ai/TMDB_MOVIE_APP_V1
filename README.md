TMDB Movie App 🎬

A modern Android movie application built using Jetpack Compose and MVVM architecture, consuming data from the TMDB API.
This project focuses on clean architecture, proper state management, and modern Android development best practices.

📱 Features

Browse popular movies

Movie details screen

Infinite scrolling with pagination

Loading & error state handling

Clean UI built with Jetpack Compose

Movie trailer playback

Splash screen

Light & Dark mode support

🛠 Tech Stack

Kotlin

Jetpack Compose

MVVM Architecture

StateFlow

Hilt (Dependency Injection)

Retrofit

Coroutines

TMDB API

🧱 Architecture

The app follows MVVM (Model–View–ViewModel) architecture:

UI (Compose): Displays UI state and handles user interactions

ViewModel: Manages business logic and exposes UI state using StateFlow

Repository: Handles data fetching from the TMDB API

UiState: Immutable screen-level state using Kotlin data class

The app follows unidirectional data flow for better maintainability.

🔄 State Management

UI state managed using StateFlow

Immutable UiState with copy() for updates

Clean handling of loading, success, and error states

Pagination state managed inside the ViewModel

📸 Screenshots
Movie List Screen
<img width="300" alt="Movie List Screen" src="https://github.com/user-attachments/assets/d94e2956-c063-4452-b7f2-8c661bd4bcaa" />
Movie Detail Screen
<img width="300" alt="Movie Detail Screen" src="https://github.com/user-attachments/assets/90b245ab-fd0c-4d95-b250-e200fb80b288" />
🎥 Demo Video

▶️ Watch Demo Video

🚀 Getting Started

Clone the repository

git clone https://github.com/gowthamrajrajesh-ai/TMDB_MOVIE_APP_V1.git


Open the project in Android Studio

Add your TMDB API key in local.properties

TMDB_API_KEY=your_api_key_here


Build and run the app

🧠 What I Learned

Building modern UI using Jetpack Compose

Managing UI state using StateFlow

Implementing clean MVVM architecture

Handling pagination in Compose

Dependency Injection using Hilt

Writing scalable and maintainable Android code

📌 Future Improvements

Offline caching using Room

Search functionality

Unit tests for ViewModels

UI polish and animations

👤 Author

Gowtham Raj
Junior Software Developer (Android)
