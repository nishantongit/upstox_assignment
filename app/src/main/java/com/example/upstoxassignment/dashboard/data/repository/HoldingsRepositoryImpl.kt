package com.example.upstoxassignment.dashboard.data.repository

import com.example.upstoxassignment.base.network.NetworkResult
import com.example.upstoxassignment.dashboard.data.datatsource.local.HoldingsLDS
import com.example.upstoxassignment.dashboard.data.datatsource.local.mappper.HoldingDtoToDomMapper
import com.example.upstoxassignment.dashboard.data.datatsource.local.mappper.HoldingDtoToEntMapper
import com.example.upstoxassignment.dashboard.data.datatsource.local.mappper.HoldingEntToDomMapper
import com.example.upstoxassignment.dashboard.data.datatsource.remote.HoldingsRDS
import com.example.upstoxassignment.dashboard.data.entities.local.DataDom
import com.example.upstoxassignment.dashboard.domain.repository.HoldingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HoldingsRepositoryImpl(private val rds: HoldingsRDS, private val lds: HoldingsLDS) :
    HoldingsRepository {

    private var dtoToDomMapper: HoldingDtoToDomMapper = HoldingDtoToDomMapper()
    private var entToDomMapper = HoldingEntToDomMapper()
    private var dtoToEntMapper = HoldingDtoToEntMapper()


    override suspend fun getHoldings(): NetworkResult {
        val result = rds.fetchHoldings()
        if (result.isSuccessful) {

            //save to DB
            result.body()?.data?.let {
                lds.insertAll(dtoToEntMapper.mapList(it))
            }

            return NetworkResult.Success(
                result.body()?.let {
                    dtoToDomMapper.map(it).data
                }
            )


            // return  dtoToDomMapper.map(result.body()).data
            //return to UI
        } else {
            return NetworkResult.Error(
                404
            )
        }
    }

    override suspend fun getHoldingsFromLocal(): Flow<ArrayList<DataDom>> {
        return lds.fetchHoldings().map {
            entToDomMapper.mapList(it)
        }
    }

    override suspend fun getHoldingDetails(id: String) {
        TODO("Not yet implemented")
    }
}