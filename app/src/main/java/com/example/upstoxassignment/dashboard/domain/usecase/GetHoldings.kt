package com.example.upstoxassignment.dashboard.domain.usecase

import com.example.upstoxassignment.base.network.NetworkResult
import com.example.upstoxassignment.dashboard.data.entities.local.DataDom
import com.example.upstoxassignment.dashboard.domain.repository.HoldingsRepository
import kotlinx.coroutines.flow.Flow

class GetHoldings(private val repository: HoldingsRepository) {
    suspend operator fun invoke(): NetworkResult {
        return repository.getHoldings()
    }

    suspend fun getFromLocal(): Flow<ArrayList<DataDom>> {
        return repository.getHoldingsFromLocal()
    }
}