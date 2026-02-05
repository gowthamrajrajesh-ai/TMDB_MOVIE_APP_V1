package com.cinedetails.tmdb_movie_app.data.remote

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton




val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            """
            CREATE TABLE IF NOT EXISTS favourite_movies (
                id INTEGER PRIMARY KEY NOT NULL,
                title TEXT NOT NULL,
                posterPath TEXT NOT NULL,
                rating REAL NOT NULL
            )
           
            """
        )
    }
}


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun providedatabase(@ApplicationContext context: Context): AppDataBase= Room.databaseBuilder(
         context, AppDataBase::class.java,"TMDB_TAB").addMigrations(MIGRATION_1_2)
        .build()

    @Provides
    fun provideMoviedao(dataBase: AppDataBase): MovieDao=dataBase.moviedao()

    @Provides
    fun providefavmoviedao(dataBase: AppDataBase): FavMovieDao=dataBase.favouritemoviedao()


}