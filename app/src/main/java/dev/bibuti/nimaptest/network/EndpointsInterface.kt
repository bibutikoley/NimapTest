package dev.bibuti.nimaptest.network

import dev.bibuti.nimaptest.models.NimapResponse
import retrofit2.Call
import retrofit2.http.GET

interface EndpointsInterface {

    @get:GET("/getcategorydata.json")
    val getResponse: Call<NimapResponse>

}