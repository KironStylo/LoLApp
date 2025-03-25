package com.kironstylo.lolapp.champion_feature.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kironstylo.lolapp.champion_feature.domain.use_cases.GetChampionsUseCase
import com.kironstylo.lolapp.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampionViewModel @Inject constructor(
    private val getChampionsUseCase: GetChampionsUseCase
) : ViewModel() {

    private val _championUIState = MutableStateFlow(ChampionUIState())
    val championUIState = _championUIState.asStateFlow()

    init{
        viewModelScope.launch {
            getChampionsUseCase().onEach { result ->
                when(result){
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        _championUIState.value = championUIState.value.copy(
                            championList = result.data ?: emptyList(),
                            filteredList = result.data ?: emptyList()
                        )
                    }
                }
            }
        }
    }

    fun onEvent(championUIEvents: ChampionUIEvents){
        when(championUIEvents){
            is ChampionUIEvents.SearchChampion -> {
                searchChampion(championUIEvents.query)
            }
        }
    }

    private fun searchChampion(championName: String){
        _championUIState.value = championUIState.value.copy(
            filteredList = championUIState.value.championList.filter{
                championName.contains(championName, ignoreCase = true)
            }
        )
    }
}