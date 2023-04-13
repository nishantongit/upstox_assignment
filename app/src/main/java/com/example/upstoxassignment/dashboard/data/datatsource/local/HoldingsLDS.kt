package com.example.upstoxassignment.dashboard.data.datatsource.local

import com.example.upstoxassignment.dashboard.data.entities.local.HoldingsEntity
import kotlinx.coroutines.flow.Flow


interface HoldingsLDS {
    suspend fun fetchHoldings(): Flow<List<HoldingsEntity>>
    suspend fun insertAll(holdings: List<HoldingsEntity>)
}