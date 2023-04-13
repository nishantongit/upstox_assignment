package com.example.upstoxassignment.dashboard.data.datatsource.remote

import com.example.upstoxassignment.dashboard.data.entities.remote.HoldingsDto
import retrofit2.Response


interface HoldingsRDS {
    suspend fun fetchHoldings(): Response<HoldingsDto>
}