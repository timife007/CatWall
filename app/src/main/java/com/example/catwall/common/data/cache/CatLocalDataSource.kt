package com.example.catwall.common.data.cache

import com.example.catwall.common.data.cache.model.CachedBreed
import kotlinx.coroutines.flow.Flow

interface CatLocalDataSource {
    suspend fun getCats(): Flow<List<CachedBreed>>
    suspend fun insertCats(cachedBreed: CachedBreed)
}