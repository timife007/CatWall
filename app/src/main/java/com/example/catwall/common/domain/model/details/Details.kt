package com.example.catwall.common.domain.model.details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Details(
    val adaptability: Int?,
    val affectionLevel: Int?,
    val altNames: String?,
    val childFriendly: Int?,
    val countryCode: String?,
    val description: String?,
    val energyLevel: Int?,
    val health_issues: Int?,
    val intelligence: Int?,
    val lifeSpan: String?,
    val origin: String?,
    val strangerFriendly: Int?,
    val temperament: String?,
    val weight: Weight?,
    val wikipediaUrl: String?
):Parcelable