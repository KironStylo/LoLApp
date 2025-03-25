package com.kironstylo.lolapp.champion_feature.domain.model

data class ChampionModel(
    val blurb: String = "",
    val id: String = "",
    val key: String = "",
    val lore: String = "",
    val name: String = "",
    val passive: PassiveModel = PassiveModel(),
    val spells: List<SpellModel> = emptyList(),
    val tags: List<String> = emptyList(),
    val title:String = ""
)
