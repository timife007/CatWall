package com.example.catwall.common.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.catwall.common.data.cache.dao.CatDao
import com.example.catwall.common.data.cache.model.CachedBreed

@Database(
    entities = [CachedBreed::class],
    version = 1
)
abstract class CatDatabase:RoomDatabase() {
    abstract fun catDao(): CatDao
}