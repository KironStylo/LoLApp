package com.kironstylo.lolapp.champion_feature.domain.use_cases

import com.kironstylo.lolapp.champion_feature.data.repository.ChampionRepository
import com.kironstylo.lolapp.champion_feature.domain.model.ChampionModel
import com.kironstylo.lolapp.core.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetChampionsUseCase @Inject constructor(
    private val championRepository: ChampionRepository
){
    operator fun invoke (): Flow<Resource<List<ChampionModel>>> = championRepository.getChampions()
}