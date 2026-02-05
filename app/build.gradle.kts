plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
}




android {
    namespace = "com.cinedetails.tmdb_movie_app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.cinedetails.tmdb_movie_app"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.3"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }


    buildTypes {
        val tmdbApiKey =
            providers.gradleProperty("TMDBAPIKEY").getOrElse("")
        debug {
            buildConfigField(
                "String",
                "TMDBAPIKEY",
                "\"$tmdbApiKey\""
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }




}




dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Navigation
//    implementation("androidx.navigation:navigation-compose:2.9.6")

    //  HILT

    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")


    // RETROFIT

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // ok http
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")


    //Async Image

    implementation("io.coil-kt:coil-compose:2.4.0")


// Paging runtime
    implementation("androidx.paging:paging-runtime:3.3.6")
// Compose integration
    implementation("androidx.paging:paging-compose:3.3.6")

    // Testing

// Unit testing (JUnit 4)
    testImplementation("junit:junit:4.13.2")

// Coroutines testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

// Mocking
    testImplementation("io.mockk:mockk:1.13.10")

// StateFlow testing
    testImplementation("app.cash.turbine:turbine:1.0.0")


 // lottie animation
    implementation("com.airbnb.android:lottie-compose:6.0.0")

  //  datastore
    implementation("androidx.datastore:datastore-preferences:1.1.1")



    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")


// Optional but recommended
//    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.6")


    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Lifecycle Compose
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)



}