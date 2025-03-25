package com.kironstylo.lolapp.champion_feature.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.kironstylo.lolapp.champion_feature.domain.model.ChampionModel

data class ResultDto(
    @SerializedName("data")
    val data: Map<String, ChampionDto> = emptyMap(),
    @SerializedName("format")
    val format: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("version")
    val version: String? = ""
){
    fun toChampion(): List<ChampionModel>{
        return data.values.toList().map{
            it.toChampion()
        }
    }
}

