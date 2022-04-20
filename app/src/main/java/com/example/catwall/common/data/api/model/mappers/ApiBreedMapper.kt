package com.example.catwall.common.data.api.model.mappers

import com.example.catwall.common.data.api.model.ApiBreed
import com.example.catwall.common.domain.model.details.CatDetails
import com.example.catwall.common.domain.model.details.Details
import javax.inject.Inject

class ApiBreedMapper @Inject constructor(
   private val apiImageMapper: ApiImageMapper,
   private val apiWeightMapper: ApiWeightMapper
):CatWallMapper<List<ApiBreed>,List<CatDetails>> {

    override fun mapToDomain(apiEntity: List<ApiBreed>): List<CatDetails> {
        return apiEntity.map { apiBreed ->
            CatDetails(
                id = apiBreed.id!!,
                name = apiBreed.name!!,
                image = apiImageMapper.mapToDomain(apiBreed.image!!),
                origin = apiBreed.origin!!,
                details = parseCatDetails(apiBreed)
            )
        }
    }

    private fun parseCatDetails(apiEntity: ApiBreed): Details {
        return Details(
            adaptability = apiEntity.adaptability,
            affectionLevel = apiEntity.affectionLevel,
            altNames = apiEntity.altNames,
            childFriendly = apiEntity.childFriendly,
            countryCode = apiEntity.countryCode,
            description = apiEntity.description,
            energyLevel = apiEntity.energyLevel,
            intelligence = apiEntity.intelligence,
            lifeSpan = apiEntity.lifeSpan,
            origin = apiEntity.origin,
            strangerFriendly = apiEntity.strangerFriendly,
            temperament = apiEntity.temperament,
            weight = apiWeightMapper.mapToDomain(apiEntity.weight!!),
            wikipediaUrl = apiEntity.wikipediaUrl,
            health_issues = apiEntity.healthIssues
        )
    }


}

