package com.kironstylo.lolapp.champion_feature.data.remote

import android.util.Log
import com.kironstylo.lolapp.champion_feature.data.remote.dto.ChampionDto
import com.kironstylo.lolapp.champion_feature.domain.model.ChampionModel
import com.kironstylo.lolapp.core.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import java.util.HashMap

class ChampionService (
    private val api: ChampionApi
) {
    fun getChampions(): Flow<Resource<List<ChampionModel>>> = flow {
        emit(Resource.Loading())
        try {
            val response = api.getChampions()

            if (response.isSuccessful) {
                val championList = response.body()?.toChampion() ?: emptyList()
                Log.i("Champion Service", "$championList")
                emit(Resource.Success(championList))
            } else {
                Log.i("Unsuccessful response", "${response.code()} - ${response.message()} - ${response.raw().request.url}")
                emit(Resource.Error("API error: ${response.code()} - ${response.message()}"))
            }
        } catch (e: IOException) {
            emit(Resource.Error("Network error: ${e.localizedMessage}"))
        } catch (e: HttpException) {
            emit(Resource.Error("HTTP error: ${e.localizedMessage}"))
        } catch (e: Exception) {
            emit(Resource.Error("Unknown error: ${e.localizedMessage}"))
        }
    }

}