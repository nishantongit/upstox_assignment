package com.example.upstoxassignment.dashboard.data.datatsource.local.mappper

import com.example.upstoxassignment.dashboard.data.entities.local.DataDom
import com.example.upstoxassignment.dashboard.data.entities.local.HoldingsEntity

class HoldingEntToDomMapper {
    private fun map(ent: HoldingsEntity): DataDom {
        return DataDom(
            avgPrice = ent.avgPrice,
            cncUsedQuantity = ent.cncUsedQuantity,
            collateralQty = ent.collateralQty,
            collateralType = ent.collateralType,
            collateralUpdateQty = ent.collateralUpdateQty,
            companyName = ent.companyName,
            haircut = ent.haircut,
            holdingsUpdateQty = ent.holdingsUpdateQty,
            isin = ent.isin,
            product = ent.product,
            quantity = ent.quantity,
            symbol = ent.symbol,
            t1HoldingQty = ent.t1HoldingQty,
            tokenBse = ent.tokenBse,
            tokenNse = ent.tokenNse,
            withheldCollateralQty = ent.withheldCollateralQty,
            withheldHoldingQty = ent.withheldHoldingQty,
            ltp = ent.ltp,
            close = ent.close
        )
    }

    fun mapList(list: List<HoldingsEntity>): ArrayList<DataDom> {
        val result = ArrayList<DataDom>();
        list.forEach {
            result.add(map(it))
        }
        return result
    }


}