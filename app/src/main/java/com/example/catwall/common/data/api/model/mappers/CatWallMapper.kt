package com.example.catwall.common.data.api.model.mappers

interface CatWallMapper<F,T> {
    fun mapToDomain(apiEntity:F):T
}