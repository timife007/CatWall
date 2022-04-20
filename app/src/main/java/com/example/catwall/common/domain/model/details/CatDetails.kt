package com.example.catwall.common.domain.model.details

import android.os.Parcelable
import com.example.catwall.common.domain.model.Image
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatDetails(
    val id:String,
    val name: String,
    val image: Image,
    val origin:String,
    val details:Details
):Parcelable