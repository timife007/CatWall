package com.example.catwall.common.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.catwall.common.domain.model.Image
import com.example.catwall.common.domain.model.details.Details

@Entity(tableName = "breed_table")
data class CachedBreed(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:String,

    @ColumnInfo(name = "name")
    val name: String,

//    @Embedded
    val image: Image,

    @ColumnInfo(name = "origin")
    val origin:String,

    @Embedded
    val details: Details
)