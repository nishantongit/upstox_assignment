package com.example.upstoxassignment.util

import com.example.upstoxassignment.dashboard.data.entities.local.DataDom

object HoldingCalculator {

    fun getCurrentValue(data: DataDom): Double {
        return data.ltp * data.quantity
    }

    fun getInvetmentValue(data: DataDom): Double {
        return data.avgPrice * data.quantity
    }

    fun getProfitLoss(data: DataDom): Double {
        return getCurrentValue(data) - getInvetmentValue(data)
    }

    fun getTodaysProfitLoss(data: DataDom): Double {
        return (data.close - data.ltp) * data.quantity
    }

}