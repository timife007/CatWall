package com.example.catwall.common.data.cache.mappers

interface CachedMapper<D,C> {
    fun mapToDomain(cacheEntity:C):D
    fun mapFromDomain(domainEntity:D):C
}