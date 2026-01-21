# TMDB Movie App 🎬

A modern Android movie application built using **Jetpack Compose** and **MVVM architecture**, consuming data from the **TMDB API**.  
This project focuses on clean architecture, proper state management, and modern Android development best practices.

---

## 📱 Features

- Browse popular movies
- Movie details screen
- Pagination (infinite scrolling)
- Loading & error state handling
- Clean UI built with Jetpack Compose
- Added trailer for the movie that click
- Added splash screen
- implemented dark mode 

---

## 🛠 Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **MVVM Architecture**
- **StateFlow**
- **Hilt (Dependency Injection)**
- **Retrofit**
- **Coroutines**
- **TMDB API**

---

## 🧱 Architecture

The app follows **MVVM (Model–View–ViewModel)** architecture:

- **UI (Compose)**: Displays state and reacts to user actions
- **ViewModel**: Handles business logic and exposes UI state using `StateFlow`
- **Repository**: Manages data from remote source (TMDB API)
- **UiState**: Screen-level immutable state using Kotlin `data class`


Unidirectional data flow is used throughout the app.

---

## 🔄 State Management

- UI state is managed using **StateFlow**
- Immutable `UiState` with `copy()` for updates
- Loading, success, and error states are handled cleanly
- Pagination loading is managed within ViewModel

---

## 📸 Screenshots

<img width="1080" height="2424" alt="movieslist" src="https://github.com/user-attachments/assets/d94e2956-c063-4452-b7f2-8c661bd4bcaa" />   this image shows the list of movies....

<img width="1080" height="2424" alt="moviedetail" src="https://github.com/user-attachments/assets/90b245ab-fd0c-4d95-b250-e200fb80b288" />  this image shows the moviedetails.....




## 🎥 Demovideo 

## 🚀 Getting Started

1. Clone the repository
2. Add your TMDB API key
3. Build and run the app in Android Studio

---

## 🧠 What I Learned

- Building UI with Jetpack Compose
- Managing UI state using StateFlow
- Clean MVVM architecture
- Pagination handling in Compose
- Dependency Injection using Hilt
- Writing scalable and maintainable Android code

---

## 📌 Future Improvements

- Offline caching using Room
- Search functionality
- Unit tests for ViewModels
- UI polish & animations

---

## 👤 Author

**Gowthamraj**  
Junior Android Developer
****
