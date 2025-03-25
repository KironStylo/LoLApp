package com.kironstylo.lolapp.champion_feature.presentation.detail_screen.viewmodel

import com.kironstylo.lolapp.champion_feature.domain.model.ChampionModel

data class DetailUIState(
    val championDetail: ChampionModel = ChampionModel()
)