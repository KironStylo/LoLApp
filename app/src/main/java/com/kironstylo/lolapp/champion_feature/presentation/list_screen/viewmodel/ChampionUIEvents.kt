package com.kironstylo.lolapp.champion_feature.presentation.list_screen.viewmodel

sealed class ChampionUIEvents {
    data class SearchChampion(val query: String): ChampionUIEvents()
}