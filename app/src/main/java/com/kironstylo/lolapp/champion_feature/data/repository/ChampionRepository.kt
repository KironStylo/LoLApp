package com.kironstylo.lolapp.champion_feature.data.repository

import com.kironstylo.lolapp.champion_feature.domain.model.ChampionModel
import com.kironstylo.lolapp.core.Resource
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {
    fun getChampions(): Flow<Resource<List<ChampionModel>>>
    fun getChampion(championName: String): Flow<Resource<ChampionModel>>
}