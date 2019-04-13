package dev.bibuti.nimaptest.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CatelogueCategory (

    @SerializedName("CategoryId")
    @Expose
    val categoryId: Int,
    @SerializedName("CategoryName")
    @Expose
    val categoryName: String,
    @SerializedName("categoryImages")
    @Expose
    val categoryImages: List<CategoryImage>


)