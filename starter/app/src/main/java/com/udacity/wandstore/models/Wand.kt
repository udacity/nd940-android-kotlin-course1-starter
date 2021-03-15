package com.udacity.wandstore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wand(var name: String, var length: Double, var wood: String, var core: String,
                val images: List<String> = mutableListOf()) : Parcelable {
}