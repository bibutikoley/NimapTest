package dev.bibuti.nimaptest.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NimapResponse(

        @SerializedName("status")
        @Expose
        val status: String,
        @SerializedName("message")
        @Expose
        val message: String,
        @SerializedName("cateloguecategory")
        @Expose
        val catelogueCategoryList: List<CatelogueCategory>

)
