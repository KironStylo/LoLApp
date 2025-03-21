package com.kironstylo.lolapp.champion_feature.data.remote

import com.kironstylo.lolapp.champion_feature.data.remote.dto.ChampionDto
import com.kironstylo.lolapp.champion_feature.data.remote.dto.ResultDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ChampionApi {

    @GET
    suspend fun getChampions(): Response<ResultDto>

    @GET("/champion/{champion}")
    suspend fun getChampion(
        @Path("champion") championName:String
    ): ResultDto

    companion object{
        const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/15.6.1/data/en_US"
    }
}