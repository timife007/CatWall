package com.example.catwall.common.data.api.model.mappers

import com.example.catwall.common.data.api.model.ApiImage
import com.example.catwall.common.domain.model.Image
import javax.inject.Inject

class ApiImageMapper @Inject constructor():CatWallMapper<ApiImage,Image> {
    override fun mapToDomain(apiEntity: ApiImage): Image {
        return Image(
            height = apiEntity.height!!,
            id = apiEntity.id!!,
            url = apiEntity.url!!,
            width = apiEntity.width!!
        )
    }
}