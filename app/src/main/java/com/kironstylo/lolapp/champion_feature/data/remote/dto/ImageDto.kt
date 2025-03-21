package com.kironstylo.lolapp.champion_feature.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.kironstylo.lolapp.champion_feature.domain.model.ImageModel

data class ImageDto(
    @SerializedName("full")
    val full: String? = "",
    @SerializedName("group")
    val group: String? = ""
){
    fun toImage(): ImageModel{
        return ImageModel(
            full = full ?: "",
            group = group ?: ""
        )
    }
}