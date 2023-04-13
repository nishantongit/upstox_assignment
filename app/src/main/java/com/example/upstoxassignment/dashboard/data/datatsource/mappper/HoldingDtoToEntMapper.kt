package com.example.upstoxassignment.dashboard.data.datatsource.mappper

import com.example.upstoxassignment.dashboard.data.entities.local.HoldingsEntity
import com.example.upstoxassignment.dashboard.data.entities.remote.DataDto

class HoldingDtoToEntMapper {
    fun map(data: DataDto): HoldingsEntity {
        return HoldingsEntity(
            avgPrice = data.avgPrice,
            cncUsedQuantity = data.cncUsedQuantity,
            collateralQty = data.collateralQty,
            collateralType = data.collateralType,
            collateralUpdateQty = data.collateralUpdateQty,
            companyName = data.companyName,
            haircut = data.haircut,
            holdingsUpdateQty = data.holdingsUpdateQty,
            isin = data.isin,
            product = data.product,
            quantity = data.quantity,
            symbol = data.symbol ?: "",
            t1HoldingQty = data.t1HoldingQty,
            tokenBse = data.tokenBse,
            tokenNse = data.tokenNse,
            withheldCollateralQty = data.withheldCollateralQty,
            withheldHoldingQty = data.withheldHoldingQty,
            ltp = data.ltp,
            close = data.close
        )
    }

    fun mapList(list: ArrayList<DataDto>): ArrayList<HoldingsEntity> {
        val result = ArrayList<HoldingsEntity>()
        list.forEach {
            result.add(map(it))
        }
        return result
    }

}