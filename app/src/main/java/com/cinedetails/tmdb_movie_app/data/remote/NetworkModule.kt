package com.cinedetails.tmdb_movie_app.data.remote

import android.util.Log
import com.cinedetails.tmdb_movie_app.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun okhttpclient(): OkHttpClient {
        return OkHttpClient.Builder()

            .addInterceptor { chain ->
                val original= chain.request()
                val  originalurl= original.url

                val url= originalurl.newBuilder()
                    .addQueryParameter("api_key", BuildConfig.TMDBAPIKEY)
                    .build()

                Log.d("KEY_CHECK", BuildConfig.TMDBAPIKEY)
              val request=original.newBuilder()
                  .url(url)
                  .build()
                chain.proceed(request)
            }

            .addInterceptor(HttpLoggingInterceptor().apply {
                level= HttpLoggingInterceptor.Level.BODY
            })

            .build()
    }


  @Provides
  @Singleton
  fun provideRetrofit(client: OkHttpClient): Retrofit {
     return Retrofit.Builder()
         .baseUrl("https://api.themoviedb.org/3/")
         .client(client)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
  }

@Provides
@Singleton
fun provideMovieApi(retrofit: Retrofit): MovieApi{
    return retrofit.create(MovieApi::class.java)

}

}