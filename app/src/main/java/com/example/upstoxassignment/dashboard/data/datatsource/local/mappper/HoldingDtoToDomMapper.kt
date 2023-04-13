package com.example.upstoxassignment.dashboard.data.datatsource.local.mappper

import com.example.upstoxassignment.dashboard.data.entities.local.DataDom
import com.example.upstoxassignment.dashboard.data.entities.local.HoldingsDom
import com.example.upstoxassignment.dashboard.data.entities.remote.DataDto
import com.example.upstoxassignment.dashboard.data.entities.remote.HoldingsDto

class HoldingDtoToDomMapper {
    fun map(holdingsDto: HoldingsDto): HoldingsDom {
        return HoldingsDom(
            clientId = holdingsDto.clientId,
            data = dataDtoToDomMap(holdingsDto.data),
            error = holdingsDto.error,
            responseType = holdingsDto.responseType,
            timestamp = holdingsDto.timestamp
        )
    }

    fun dataDtoToDomMap(data: ArrayList<DataDto>): ArrayList<DataDom> {
        val list = ArrayList<DataDom>()
        data.forEach {
            list.add(
                DataDom(
                    avgPrice = it.avgPrice,
                    cncUsedQuantity = it.cncUsedQuantity,
                    collateralQty = it.collateralQty,
                    collateralType = it.collateralType,
                    collateralUpdateQty = it.collateralUpdateQty,
                    companyName = it.companyName,
                    haircut = it.haircut,
                    holdingsUpdateQty = it.holdingsUpdateQty,
                    isin = it.isin,
                    product = it.product,
                    quantity = it.quantity,
                    symbol = it.symbol,
                    t1HoldingQty = it.t1HoldingQty,
                    tokenBse = it.tokenBse,
                    tokenNse = it.tokenNse,
                    withheldCollateralQty = it.withheldCollateralQty,
                    withheldHoldingQty = it.withheldHoldingQty,
                    ltp = it.ltp,
                    close = it.close

                )
            )
        }
        return list

    }
}