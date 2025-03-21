package com.kironstylo.lolapp.champion_feature.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.kironstylo.lolapp.champion_feature.domain.model.ImageModel
import com.kironstylo.lolapp.champion_feature.domain.model.PassiveModel

data class PassiveDto(
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("image")
    val image: ImageDto? = ImageDto(),
    @SerializedName("name")
    val name: String? = ""
){
    fun toPassive(): PassiveModel{
        return PassiveModel(
            description = description ?: "",
            image = image?.toImage() ?: ImageModel(),
            name = name ?: ""
        )
    }
}