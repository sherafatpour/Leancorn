package net.sherafatpour.leancorn.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.sherafatpour.leancorn.data.remote.MoviesApi
import retrofit2.Retrofit
import javax.inject.Singleton
import net.sherafatpour.leancorn.util.BASE_URL
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    fun provideMovieApi(retrofit: Retrofit):MoviesApi = retrofit.create(MoviesApi::class.java)


}