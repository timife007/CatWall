package com.example.catwall.common.data.cache

import com.example.catwall.common.data.cache.dao.CatDao
import com.example.catwall.common.data.cache.model.CachedBreed
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatLocalDataSourceImpl @Inject constructor(private val catDao: CatDao) : CatLocalDataSource {
    override suspend fun getCats(): Flow<List<CachedBreed>> {
        return catDao.getAllCatBreeds()
    }

    override suspend fun insertCats(cachedBreed: CachedBreed) {
        TODO("Not yet implemented")
    }
}