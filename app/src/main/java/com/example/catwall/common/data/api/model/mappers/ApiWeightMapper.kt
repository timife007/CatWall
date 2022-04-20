package com.example.catwall.common.data.api.model.mappers

import com.example.catwall.common.data.api.model.ApiWeight
import com.example.catwall.common.domain.model.details.Weight
import javax.inject.Inject

class ApiWeightMapper @Inject constructor():CatWallMapper<ApiWeight,Weight> {
    override fun mapToDomain(apiEntity: ApiWeight): Weight {
        return Weight(
            imperial = apiEntity.imperial,
            metric = apiEntity.metric
        )
    }

}