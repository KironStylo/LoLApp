package com.kironstylo.lolapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kironstylo.lolapp.champion_feature.presentation.components.ChampionListScreen
import com.kironstylo.lolapp.champion_feature.presentation.viewmodel.ChampionViewModel
import com.kironstylo.lolapp.ui.theme.LoLAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val championViewModel: ChampionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoLAppTheme {
                 val championListState by championViewModel.championUIState.collectAsState()
                 ChampionListScreen(
                     championListState
                 ) {
                     championViewModel.onEvent(it)
                 }
            }
        }
    }
}