package com.kironstylo.lolapp.champion_feature.presentation.list_screen.viewmodel

import com.kironstylo.lolapp.champion_feature.domain.model.ChampionModel

data class ChampionUIState (
    val championList: List<ChampionModel> = emptyList(),
    val filteredList: List<ChampionModel> = emptyList()
)