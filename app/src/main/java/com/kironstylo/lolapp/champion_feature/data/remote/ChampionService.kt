package com.kironstylo.lolapp.champion_feature.data.remote

import com.kironstylo.lolapp.champion_feature.data.remote.dto.ChampionDto
import com.kironstylo.lolapp.core.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
import java.util.HashMap

class ChampionService @Inject constructor(
    private val api: ChampionApi
) {
    fun getChampions(): Flow<Resource<List<ChampionDto>>> = flow {
        emit(Resource.Loading())
        try{
            val championList = api.getChampions().body()?.toChampion()
            emit(Resource.Success(championList))
        }
        catch(e: IOException){
            emit(Resource.Error())
        }
    }
}