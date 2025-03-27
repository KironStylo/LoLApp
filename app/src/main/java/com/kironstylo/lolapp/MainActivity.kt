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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kironstylo.lolapp.champion_feature.presentation.detail_screen.components.ChampionDetailScreen
import com.kironstylo.lolapp.champion_feature.presentation.detail_screen.viewmodel.DetailViewModel
import com.kironstylo.lolapp.champion_feature.presentation.list_screen.components.ChampionListScreen
import com.kironstylo.lolapp.champion_feature.presentation.list_screen.viewmodel.ChampionViewModel
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
                val navController = rememberNavController()
                val championListState by championViewModel.championUIState.collectAsState()
                NavHost(navController, startDestination = "ChampionList") {
                    composable("ChampionList"){
                        ChampionListScreen(
                            championListState,
                            championViewModel::onEvent
                        ) { name ->
                           navController.navigate("ChampionDetails/$name")
                        }
                    }
                    composable("ChampionDetails/{name}"){
                        val detailViewModel: DetailViewModel = hiltViewModel()
                        val detail by detailViewModel.detailUIState.collectAsState()
                        ChampionDetailScreen(
                            detail
                        )
                    }
                }



            }
        }
    }
}