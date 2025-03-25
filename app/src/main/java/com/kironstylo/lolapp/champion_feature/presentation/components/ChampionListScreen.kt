package com.kironstylo.lolapp.champion_feature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kironstylo.lolapp.champion_feature.presentation.viewmodel.ChampionUIEvents
import com.kironstylo.lolapp.champion_feature.presentation.viewmodel.ChampionUIState

@Composable
fun ChampionListScreen(
    championUIState: ChampionUIState,
    championUIEvent: (ChampionUIEvents) -> Unit
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            var text by rememberSaveable { mutableStateOf("") }
            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                    championUIEvent(ChampionUIEvents.SearchChampion(text))
                },
                placeholder = {
                    Text(
                        text = "Search for champs"
                    )
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(
                    championUIState.filteredList
                ){
                    ChampionCard(it)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ChampionListScreenPreview(){
}