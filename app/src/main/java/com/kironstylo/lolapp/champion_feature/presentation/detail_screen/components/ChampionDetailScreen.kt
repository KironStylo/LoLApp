package com.kironstylo.lolapp.champion_feature.presentation.detail_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kironstylo.lolapp.champion_feature.data.remote.ChampionApi
import com.kironstylo.lolapp.champion_feature.domain.model.ChampionModel
import com.kironstylo.lolapp.champion_feature.presentation.detail_screen.viewmodel.DetailUIState

@Composable
fun ChampionDetailScreen(
    detailUIState: DetailUIState
){
    Scaffold { innerPadding ->
        LazyColumn (
            contentPadding = innerPadding
        ){
            val champion = detailUIState.championDetail
            item{
                AsyncImage(
                    model = ChampionApi.SPLASH_URL+"${champion.id}_0.jpg",
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                ChampionHeader(
                    champion = champion,
                    modifier = Modifier.padding(
                        vertical = 6.dp,
                        horizontal = 10.dp
                    )
                )
                ChampionLore(
                    lore = champion.lore,
                    modifier = Modifier.padding(
                        vertical = 6.dp,
                        horizontal = 20.dp
                    )
                )
                ChampionPassive(
                    passive = champion.passive,
                    modifier = Modifier.padding(
                        vertical = 10.dp,
                        horizontal = 6.dp
                    )
                )
                champion.spells.forEach { spell ->
                    ChampionSpell(
                        spell,
                        modifier = Modifier.padding(
                            vertical = 10.dp,
                            horizontal = 6.dp
                        )
                    )
                }
            }
        }
    }
}