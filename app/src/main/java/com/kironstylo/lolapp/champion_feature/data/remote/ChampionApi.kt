package com.kironstylo.lolapp.champion_feature.data.remote

import com.kironstylo.lolapp.champion_feature.data.remote.dto.ChampionDto
import com.kironstylo.lolapp.champion_feature.data.remote.dto.ResultDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ChampionApi {

    @GET("/champions.json")
    suspend fun getChampions(): Response<ResultDto>

    @GET("/champion/{champion}.json")
    suspend fun getChampion(
        @Path("champion") championName:String
    ): ResultDto

    companion object{
        const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/15.6.1/data/en_US"

        const val SPLASH_URL = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/"
        const val LOADING_URL = "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/"
        const val SQUARE_URL = "https://ddragon.leagueoflegends.com/cdn/9.19.1/img/champion/"
        const val PASSIVE_URL = "https://ddragon.leagueoflegends.com/cdn/9.19.1/img/passive/"
        const val ABILITY_URL = "https://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/"


    }
}