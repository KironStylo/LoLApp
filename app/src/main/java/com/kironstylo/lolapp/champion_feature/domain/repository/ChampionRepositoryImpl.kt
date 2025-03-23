package com.kironstylo.lolapp.champion_feature.domain.repository

import com.kironstylo.lolapp.champion_feature.data.remote.ChampionService
import com.kironstylo.lolapp.champion_feature.data.repository.ChampionRepository
import com.kironstylo.lolapp.champion_feature.domain.model.ChampionModel
import com.kironstylo.lolapp.core.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChampionRepositoryImpl @Inject constructor(
    private val championService: ChampionService
): ChampionRepository{

    override fun getChampions(): Flow<Resource<List<ChampionModel>>> {
        return championService.getChampions()
    }

    override fun getChampion(championName: String): Flow<Resource<ChampionModel>> {
        TODO("Not yet implemented")
    }
}