package com.android.weather.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class WeatherByCurrentLocModel {
 @JsonClass(generateAdapter = true)
 data class Response(
     @Json(name = "coord")
     var coord: Coord? = Coord(),
     @Json(name ="weather")
     var weather : List<WeatherDetails> = emptyList<WeatherDetails>(),
     @Json(name ="base")
     var base : String?= null,
     @Json(name ="main")
     var main : Main? = Main(),
     @Json(name ="visibility" )
     var visibility : Int?  = null,
     @Json(name ="wind")
     var wind : Wind? = Wind(),
     @Json(name ="clouds")
     var clouds: Clouds?= Clouds(),
     @Json(name ="dt")
     var dt: Int?  = null,
     @Json(name ="sys")
     var sys  : Sys?  = Sys(),
     @Json(name ="timezone")
     var timezone: Int?  = null,
     @Json(name ="id")
     var id: Int?  = null,
     @Json(name ="name" )
     var name : String?= null,
     @Json(name ="cod"  )
     var cod  : Int?  = null,
     @Json(name ="message"  )
     var message  : String?  = null
 )
    @JsonClass(generateAdapter = true)
    data class Wind (
        @Json(name ="speed")
        var speed: Double?  = null,
        @Json(name ="deg")
        var deg: Double?  = null,
        @Json(name ="gust")
        var gust: Double?  = null
    )

    @JsonClass(generateAdapter = true)
    data class Sys (
        @Json(name ="type")
        var type: Int?  = null,
    @Json(name ="id")
    var id: Int?  = null,
    @Json(name ="country")
    var country: String?  = null,
    @Json(name ="sunrise")
    var sunrise: Int?  = null,
    @Json(name ="sunset")
    var sunset: Int?  = null
    )
    @JsonClass(generateAdapter = true)
    data class Clouds (
    @Json(name ="all")
    var all: Int?  = null
    )
    @JsonClass(generateAdapter = true)
    data class Coord (
        @Json(name ="lon")
        var lon: Double?  = null,
    @Json(name ="lat")
    var lat: Double?  = null
    )
    @JsonClass(generateAdapter = true)
    data class Main (
        @Json(name ="temp")
        var temp: Double?  = null,
        @Json(name ="feels_like")
        var feels_like: Double?  = null,
        @Json(name ="temp_min")
        var temp_min: Double?  = null,
        @Json(name ="temp_max")
        var temp_max: Double?  = null,
        @Json(name ="pressure")
        var pressure: Int?  = null,
        @Json(name ="humidity")
        var humidity: Int?  = null,
        @Json(name ="sea_level")
        var sea_level: Int?  = null,
        @Json(name ="grnd_level")
        var grnd_level: Int?  = null
    )
    @JsonClass(generateAdapter = true)
    data class WeatherDetails (
        @Json(name ="id")
        var id: Int?  = null,
        @Json(name ="main")
        var main: String?  = null,
         @Json(name ="description")
        var description: String?  = null,
        @Json(name ="icon")
          var icon: String?  = null
    )
}