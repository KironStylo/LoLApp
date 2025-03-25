package com.kironstylo.lolapp.champion_feature.presentation.list_screen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kironstylo.lolapp.champion_feature.domain.use_cases.GetChampionsUseCase
import com.kironstylo.lolapp.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
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
        Log.i("ViewModel", "Launch Use Case")
        viewModelScope.launch {
            getChampionsUseCase().onEach { result ->
                when(result){
                    is Resource.Error -> {
                        Log.i("View Model Search Error", "${result.data}")

                    }
                    is Resource.Loading -> {
                        Log.i("View Model Search Loading", "${result.data}")

                    }
                    is Resource.Success -> {
                        Log.i("View Model Search success", "${result.data}")
                        _championUIState.value = championUIState.value.copy(
                            championList = result.data ?: emptyList(),
                            filteredList = result.data ?: emptyList()
                        )
                    }
                }
            }.collect()
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
            filteredList = championUIState.value.championList.filter{ it ->
                it.name.contains(championName, ignoreCase = true)
            }
        )
    }
}