package com.kironstylo.lolapp.champion_feature.presentation.components

import android.media.Image
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kironstylo.lolapp.R

@Composable
fun ChampionCard() {
    Row (
        modifier = Modifier
            .padding(4.dp)
            .height(140.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Image(
            painter = painterResource(R.drawable.draven),
            contentDescription = null,
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
                text = "Draven",
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
                    text = "In Noxus, warriors known as Reckoners face one another in arenas where blood is spilled and strength tested—but none has ever been as celebrated as Draven. A former soldier, he found that the crowds uniquely appreciated his flair for the dramatic, and...",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 6,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChampionCardPreview(){
    ChampionCard()
}