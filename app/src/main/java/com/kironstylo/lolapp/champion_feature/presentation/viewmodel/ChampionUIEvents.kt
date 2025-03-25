package com.kironstylo.lolapp.champion_feature.presentation.viewmodel

sealed class ChampionUIEvents {
    data class SearchChampion(val query: String): ChampionUIEvents()
}