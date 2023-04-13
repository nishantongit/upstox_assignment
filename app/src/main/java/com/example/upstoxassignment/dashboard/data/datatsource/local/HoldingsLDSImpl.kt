package com.example.upstoxassignment.dashboard.data.datatsource.local

import com.example.upstoxassignment.dashboard.data.entities.local.HoldingsEntity
import kotlinx.coroutines.flow.Flow


class HoldingsLDSImpl(private val holdingsDao: HoldingsDao) : HoldingsLDS {

    override suspend fun fetchHoldings(): Flow<List<HoldingsEntity>> {
        return holdingsDao.getAllHoldings()
    }

    override suspend fun insertAll(holdings: List<HoldingsEntity>) {
        return holdingsDao.insertAll(holdings)
    }
}