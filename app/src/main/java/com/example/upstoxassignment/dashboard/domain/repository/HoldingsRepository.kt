package com.example.upstoxassignment.dashboard.domain.repository

import com.example.upstoxassignment.base.network.NetworkResult
import com.example.upstoxassignment.dashboard.data.entities.local.DataDom
import kotlinx.coroutines.flow.Flow


interface HoldingsRepository {
    suspend fun getHoldings(): NetworkResult
    suspend fun getHoldingsFromLocal(): Flow<ArrayList<DataDom>>
    suspend fun getHoldingDetails(id: String)
}