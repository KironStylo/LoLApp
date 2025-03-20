package com.kironstylo.lolapp.champion_feature.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("data")
    val data: Map<String, ChampionDto> = emptyMap(),
    @SerializedName("format")
    val format: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("version")
    val version: String? = ""
)