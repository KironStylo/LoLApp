package com.kironstylo.lolapp.champion_feature.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("full")
    val full: String? = "",
    @SerializedName("group")
    val group: String? = ""
)