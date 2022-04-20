package com.example.catwall.common.data.cache.mappers

import com.example.catwall.common.data.cache.model.CachedBreed
import com.example.catwall.common.domain.model.details.CatDetails
import javax.inject.Inject

class CachedBreedMappers @Inject constructor() : CachedMapper<List<CatDetails>, List<CachedBreed>> {
    override fun mapToDomain(cacheEntity: List<CachedBreed>): List<CatDetails> {
        return cacheEntity.map { cachedBreed ->
            CatDetails(
                id = cachedBreed.id,
                name = cachedBreed.name,
                image = cachedBreed.image,
                origin = cachedBreed.origin,
                details = cachedBreed.details
            )
        }
    }

    override fun mapFromDomain(domainEntity: List<CatDetails>): List<CachedBreed> {
        return domainEntity.map { catDetails ->
            CachedBreed(
                id = catDetails.id,
                name = catDetails.name,
                image = catDetails.image,
                origin = catDetails.origin,
                details = catDetails.details
            )
        }
    }


}