package com.kironstylo.lolapp.champion_feature.domain.model

data class ChampionModel(
    val blurb: String,
    val id: String,
    val key: String,
    val lore: String,
    val tags: List<String>,
    val title:String
)
