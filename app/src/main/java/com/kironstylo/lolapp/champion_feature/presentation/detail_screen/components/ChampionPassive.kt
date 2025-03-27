package com.kironstylo.lolapp.champion_feature.presentation.detail_screen.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kironstylo.lolapp.champion_feature.data.remote.ChampionApi
import com.kironstylo.lolapp.champion_feature.domain.model.PassiveModel

@Composable
fun ChampionPassive(passive: PassiveModel, modifier: Modifier = Modifier){
    ListItem(
        headlineContent = {
            Text(passive.name)
        },
        supportingContent = {
            Text(passive.description)
        },
        leadingContent = {
            AsyncImage(
                model = ChampionApi.ABILITY_URL+passive.image.full,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        },
        modifier = modifier
    )
}