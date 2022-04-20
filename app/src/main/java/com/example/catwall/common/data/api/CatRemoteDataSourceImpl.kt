package com.example.catwall.common.data.api

import CatRemoteDataSource
import com.example.catwall.common.data.api.model.ApiBreed
import com.example.catwall.common.data.api.model.ApiCatBreeds
import com.example.catwall.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CatRemoteDataSourceImpl @Inject constructor(
    private val api: CatWallApi
) : CatRemoteDataSource {
    override fun getCats(): Flow<Result<List<ApiBreed>>> {
        return flow {
            val result = api.getCats()
            try {
                if (result.isSuccessful) {
                    val catBreeds = result.body()?.breeds
                    emit(Result.Success(catBreeds))
                } else {
                    emit(Result.Success(null))
                }
            } catch (e: Exception) {
                    emit(Result.Error(e))
            }
        }
    }
}