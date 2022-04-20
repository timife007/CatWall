package com.example.catwall.common.data.api.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ApiCatBreeds(
    @SerializedName("breeds")
    val breeds: List<ApiBreed>?
) : Parcelable