package com.example.catwall.common.data.di

import android.content.Context
import androidx.room.Room
import com.example.catwall.common.data.cache.CatDatabase
import com.example.catwall.common.data.cache.dao.CatDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {
    companion object{
        @Provides
        fun provideDatabase(
            @ApplicationContext context:Context
        ):CatDatabase{
            return Room.databaseBuilder(
                context,
                CatDatabase::class.java,
                "cats_database"
            ).build()
        }

        @Provides
        fun provideCatsDao(
            catsDatabase: CatDatabase
        ):CatDao{
            return catsDatabase.catDao()
        }
    }

}