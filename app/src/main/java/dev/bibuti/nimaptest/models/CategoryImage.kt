package dev.bibuti.nimaptest.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryImage (

    @SerializedName("createddate")
    @Expose
    var createddate: String,
    @SerializedName("hdpi")
    @Expose
    var hdpi: Any,
    @SerializedName("imageid")
    @Expose
    var imageid: Int,
    @SerializedName("ipad")
    @Expose
    var ipad: Any,
    @SerializedName("ipadretina")
    @Expose
    var ipadretina: Any,
    @SerializedName("iphone")
    @Expose
    var iphone: String,
    @SerializedName("iphone6")
    @Expose
    var iphone6: Any,
    @SerializedName("iphone6plus")
    @Expose
    var iphone6plus: Any,
    @SerializedName("mdpi")
    @Expose
    var mdpi: Any,
    @SerializedName("modifieddate")
    @Expose
    var modifieddate: String,
    @SerializedName("xhdpi")
    @Expose
    var xhdpi: Any,
    @SerializedName("xxhdpi")
    @Expose
    var xxhdpi: Any,
    @SerializedName("xxxhdpi")
    @Expose
    var xxxhdpi: Any

)
