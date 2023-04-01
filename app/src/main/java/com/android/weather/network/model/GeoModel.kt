package com.android.weather.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class GeoModel {
    @JsonClass(generateAdapter = true)
    data class Response(
        @Json(name ="name"  )
        var name  : String?  = null,
        @Json(name ="lat"  )
        var lat  : Double?  = null,
        @Json(name ="lon"  )
        var lon  : Double?  = null,
        @Json(name ="country"  )
        var country  : String?  = null,
        @Json(name ="state"  )
        var state  : String?  = null
    )
}