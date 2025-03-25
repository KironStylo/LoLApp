package com.kironstylo.lolapp.champion_feature.presentation.viewmodel

sealed class ChampionUIEvents {
    data class searchChampion(val query: String): ChampionUIEvents()
}