package com.example.upstoxassignment.dashboard.data.datatsource.remote

import com.example.upstoxassignment.dashboard.data.api.HoldingsService
import com.example.upstoxassignment.dashboard.data.entities.remote.HoldingsDto
import retrofit2.Response

class HoldingsRDSImpl(private val service: HoldingsService) : HoldingsRDS {
    override suspend fun fetchHoldings(): Response<HoldingsDto> {
        return service.getHoldings()
    }
}