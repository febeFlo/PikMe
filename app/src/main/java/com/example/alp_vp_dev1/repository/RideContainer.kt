package com.example.alp_vp_dev1.repository

import com.example.alp_vp_dev1.services.AuthServices
import com.example.alp_vp_dev1.services.RideServices
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RideContainer {

    private val BASE_URL = "https://7168-36-90-48-14.ngrok-free.app/api/"

    private val client = OkHttpClient.Builder()
        .hostnameVerifier { _, _ -> true }
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    private val retrofitService: RideServices by lazy {
        retrofit.create(RideServices::class.java)
    }

    val rideRepositories: RideRepositories by lazy {
        RideRepositories(retrofitService)
    }

}