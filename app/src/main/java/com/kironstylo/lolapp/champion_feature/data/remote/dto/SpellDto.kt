package com.kironstylo.lolapp.champion_feature.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.kironstylo.lolapp.champion_feature.domain.model.ImageModel
import com.kironstylo.lolapp.champion_feature.domain.model.SpellModel

data class SpellDto(
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("image")
    val image: ImageDto? = ImageDto(),
    @SerializedName("name")
    val name: String? = ""
){
    fun toSpell(): SpellModel {
        return SpellModel(
            description = description ?: "",
            id = id ?: "",
            image = image?.toImage() ?: ImageModel(),
            name = name ?: ""
        )
    }
}