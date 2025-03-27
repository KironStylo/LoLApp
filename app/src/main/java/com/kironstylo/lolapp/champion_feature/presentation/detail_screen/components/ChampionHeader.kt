package com.kironstylo.lolapp.champion_feature.presentation.detail_screen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kironstylo.lolapp.champion_feature.data.remote.ChampionApi
import com.kironstylo.lolapp.champion_feature.domain.model.ChampionModel
import com.kironstylo.lolapp.ui.theme.LoLAppTheme

@Composable
fun ChampionHeader(
    modifier: Modifier = Modifier,
    champion: ChampionModel
){
    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(
                text = champion.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        },
        supportingContent = {
            Text(
                text = champion.tags.firstOrNull() ?: ""
            )
        },
        leadingContent = {
            AsyncImage(
                model = ChampionApi.SQUARE_URL + "${champion.id}.png",
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        },
        trailingContent = {
            Text(
                text = champion.title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun ChampionHeaderPreview(){
    LoLAppTheme {
        ChampionHeader(
           champion =  ChampionModel(
                name = "Draven",
                id = "Draven",
                tags = listOf("tag1", "tag2")
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}