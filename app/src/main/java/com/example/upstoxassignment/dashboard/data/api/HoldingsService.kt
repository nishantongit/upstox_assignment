package com.example.upstoxassignment.dashboard.data.api

import com.example.upstoxassignment.dashboard.data.entities.remote.HoldingsDto
import retrofit2.Response
import retrofit2.http.GET

interface HoldingsService {
    @GET("holdings")
    suspend fun getHoldings(): Response<HoldingsDto>
}