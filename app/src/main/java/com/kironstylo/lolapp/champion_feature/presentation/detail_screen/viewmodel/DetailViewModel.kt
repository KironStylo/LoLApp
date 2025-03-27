package com.kironstylo.lolapp.champion_feature.presentation.detail_screen.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kironstylo.lolapp.champion_feature.domain.model.ChampionModel
import com.kironstylo.lolapp.champion_feature.domain.use_cases.GetChampionUseCase
import com.kironstylo.lolapp.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getChampionUseCase: GetChampionUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _detailUIState = MutableStateFlow(DetailUIState())
    val detailUIState = _detailUIState.asStateFlow()

    init {
        val name = savedStateHandle.get<String>("name")
        name?.let {
            viewModelScope.launch {
                getChampionUseCase(name).onEach { result ->
                    when (result) {
                        is Resource.Error -> {}
                        is Resource.Loading -> {}
                        is Resource.Success -> {
                            _detailUIState.value = detailUIState.value.copy(
                                championDetail = result.data ?: ChampionModel()
                            )
                        }
                    }
                }.collect()
            }
        }
    }

}