package com.kironstylo.lolapp.champion_feature.presentation.list_screen.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kironstylo.lolapp.R
import com.kironstylo.lolapp.champion_feature.data.remote.ChampionApi
import com.kironstylo.lolapp.champion_feature.domain.model.ChampionModel

@Composable
fun ChampionCard(
    championModel: ChampionModel,
    onClick: (String) -> Unit
) {
    Row (
        modifier = Modifier
            .padding(4.dp)
            .height(180.dp)
            .clickable{
                onClick(championModel.id)
            },
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        AsyncImage(
            model = ChampionApi.LOADING_URL + "${championModel.id}_0.jpg",
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .weight(0.3f)
        )
        Column (
            modifier = Modifier
                .padding(vertical = 8.dp)
                .weight(0.9f),
        ){
            Text(
                text = championModel.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(0.2f)
            )
            Box(
                modifier = Modifier
                    .weight(0.8f),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = championModel.blurb,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 6,
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = 24.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChampionCardPreview(){
}