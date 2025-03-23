package com.kironstylo.lolapp.di

import com.kironstylo.lolapp.champion_feature.data.remote.ChampionApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ChampionApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}