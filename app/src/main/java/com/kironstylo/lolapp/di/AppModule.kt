package com.kironstylo.lolapp.di

import com.kironstylo.lolapp.champion_feature.data.remote.ChampionApi
import com.kironstylo.lolapp.champion_feature.data.remote.ChampionService
import com.kironstylo.lolapp.champion_feature.data.repository.ChampionRepository
import com.kironstylo.lolapp.champion_feature.domain.repository.ChampionRepositoryImpl
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
    fun provideChampionApi(): ChampionApi {
        return Retrofit.Builder()
            .baseUrl(ChampionApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChampionApi::class.java)
    }

    @Provides
    @Singleton
    fun provideService(api: ChampionApi): ChampionService{
        return ChampionService(api)
    }

    @Provides
    @Singleton
    fun provideChampionRepository(championService: ChampionService): ChampionRepository{
        return ChampionRepositoryImpl(championService)
    }
}