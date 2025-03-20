package com.kironstylo.lolapp.champion_feature.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ChampionDto(
    @SerializedName("blurb")
    val blurb: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("image")
    val image: ImageDto? = ImageDto(),
    @SerializedName("key")
    val key: String? = "",
    @SerializedName("lore")
    val lore: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("passive")
    val passive: PassiveDto? = PassiveDto(),
    @SerializedName("spells")
    val spells: List<SpellDto>? = emptyList(),
    @SerializedName("tags")
    val tags: List<String>? = emptyList(),
    @SerializedName("title")
    val title: String? = ""
)