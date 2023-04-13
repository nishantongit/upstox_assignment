package com.example.upstoxassignment.dashboard.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        fun getService(): HoldingsService {
            return Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/6d0ad460-f600-47a7-b973-4a779ebbaeaf/")
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(HoldingsService::class.java)
        }
    }
}
