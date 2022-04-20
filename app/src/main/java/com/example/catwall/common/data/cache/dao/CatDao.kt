package com.example.catwall.common.data.cache.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.catwall.common.data.cache.model.CachedBreed
import kotlinx.coroutines.flow.Flow

interface CatDao{
    @Query("SELECT * FROM breed_table ORDER BY id")
    suspend fun getAllCatBreeds(): Flow<List<CachedBreed>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCatDetails(cachedBreed: CachedBreed)
}