package com.neo.myapplication.data.remote.response

import java.io.Serializable

data class ResponseLocationData (
    val documents : List<LocationData>
        ) {
    data class LocationData (
        val road_address_name : String,
        val place_name : String,
    )
}