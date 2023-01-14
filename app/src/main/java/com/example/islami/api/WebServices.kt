package com.example.islami.api

import com.example.islami.model.RadioResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface WebServices {
    @GET("radios?language=ar")
    fun getRadioChannels():Call<RadioResponse>
}