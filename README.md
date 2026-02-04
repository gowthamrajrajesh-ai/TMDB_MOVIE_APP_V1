# TMDB Movie App 🎬

A modern Android movie application built using **Jetpack Compose**, **MVVM Architecture**, and **TMDB API**.
This project focuses on clean architecture, reactive UI using Flow, local caching with Room, and polished user experience with animations and undo actions.

---

## 📱 Features

### 🎥 Movie Browsing

* Browse popular movies from TMDB API
* Infinite scrolling (pagination)
* Smooth loading and error state handling
* Clean grid-based UI using Jetpack Compose

---

### 📄 Movie Details Screen

* Detailed movie information:

  * Overview
  * Rating
  * Release date
  * Language
  * Popularity
* Favourite toggle with animated heart icon
* Trailer playback support

---

### ❤️ Favourite Movies

* Add movies to favourites
* Remove favourites with **shrink + fade animation**
* Local persistence using **Room Database**
* Real-time UI updates using **Kotlin Flow**
* Snackbar with **Undo delete support**

---

### 🌗 Theme Support

* Light Mode
* Dark Mode
* System Default Mode
* Theme preference saved locally

---

### 🚀 Additional Features

* Splash screen
* Trailer playback support
* Modern Material3 UI
* Smooth Compose animations

---

## 🛠 Tech Stack

### Core

* Kotlin
* Jetpack Compose
* MVVM Architecture
* StateFlow / Flow
* Hilt (Dependency Injection)

### Networking

* Retrofit
* TMDB API
* Coroutines

### Local Storage

* Room Database
* Kotlin Flow (Reactive DB updates)

### Image Loading

* Coil Compose

### UI & Animation

* AnimatedVisibility
* Snackbar Undo Action
* Compose Material3
* Custom Heart Animation

---

## 🧱 Architecture

The app follows **MVVM (Model–View–ViewModel)** with **Repository Pattern** and Unidirectional Data Flow.

```
UI (Jetpack Compose)
        ↓
ViewModel (StateFlow / UI State)
        ↓
Repository
        ↓
Remote API (TMDB) + Local Database (Room)
```

---

## 🔄 State Management

* UI state handled using **StateFlow**
* Immutable UI State using Kotlin `data class`
* Room database emits reactive updates using Flow
* UI automatically updates when database changes

---

## ❤️ Favourite Feature Implementation

### Key Highlights

* Favourites stored in a **separate Room table**
* UI listens to database using Flow
* Smooth card removal animation using `AnimatedVisibility`
* Snackbar provides Undo support
* Clean MVVM separation between UI and Data layer

---

## 🎞 Animations Implemented

### Favourite Removal Animation

* Shrink + Fade exit animation
* Database update triggered after animation completion

### Favourite Heart Animation

* Scale pop animation
* Color transition based on favourite state

---

## 📸 Screenshots

### Movie List Screen

<img width="1080" height="2424" alt="movieslist" src="https://github.com/user-attachments/assets/d94e2956-c063-4452-b7f2-8c661bd4bcaa" />

---

### Movie Details Screen

<img width="1080" height="2424" alt="moviedetail" src="https://github.com/user-attachments/assets/90b245ab-fd0c-4d95-b250-e200fb80b288" />

---

## 🎥 Demo Video

▶️ [Watch Demo Video](https://image2url.com/r2/default/videos/1768995369227-a15d1986-385f-412e-bd57-47e5566d68d9.webm)

---

## 🚀 Getting Started

1. Clone the repository
2. Add your TMDB API key in `local.properties`
3. Build and run the project in Android Studio

---

## 🔐 API Key Handling

The TMDB API key is stored using `BuildConfig` and excluded from version control.

> In production apps, API keys should be secured via backend or proxy services.

---

## 📚 What I Learned

* Building scalable UI using Jetpack Compose
* Managing UI state using StateFlow & Flow
* Implementing Room with reactive UI updates
* Applying Clean MVVM architecture
* Implementing animations in Compose
* Handling pagination efficiently
* Using Hilt for dependency injection
* Designing modern Android UI using Material3

---

## 📌 Future Improvements

* Search movies feature
* Offline caching for movie list
* Unit testing ViewModels
* UI testing with Compose Test
* Improved animation transitions
* Multi-language support

---

## 👤 Author

**Gowthamraj**
Junior Android Developer

---

## ⭐ Support

If you like this project, consider giving it a star ⭐ on GitHub!

---
