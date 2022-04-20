package com.example.catwall.common.data.api

import com.example.catwall.common.data.api.model.ApiCatBreeds
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatWallApi {
    @GET(ApiConstants.BREEDS_ENDPOINT)
    suspend fun getCats(
        @Query("page")
        page:Int? = 1
    ):Response<ApiCatBreeds>
}