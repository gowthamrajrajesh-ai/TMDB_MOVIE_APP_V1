import com.android.tools.build.jetifier.core.utils.Log


plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
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
        versionName = "1.0"













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


        release {
            isMinifyEnabled = true
            buildConfigField(
                "String",
                "TMDBAPIKEY",
                "\"$tmdbApiKey\""
            )
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
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
    implementation("androidx.navigation:navigation-compose:2.9.6")

    //  HILT

    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")

    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")


    // RETROFIT

    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // ok http
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")


    //Async Image

    implementation("io.coil-kt:coil-compose:2.4.0")


// Paging runtime
    implementation("androidx.paging:paging-runtime:3.2.0")
// Compose integration
    implementation("androidx.paging:paging-compose:3.2.0")



}