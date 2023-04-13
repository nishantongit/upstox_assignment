package com.example.upstoxassignment.dashboard.presentation.ui.viewmodel

import androidx.databinding.ObservableField
import com.example.upstoxassignment.base.adapter.RecyclerViewAdapter
import com.example.upstoxassignment.dashboard.data.entities.local.DataDom
import com.example.upstoxassignment.util.HoldingCalculator.getProfitLoss

class HoldingItemVm(data: DataDom) : RecyclerViewAdapter.RecyclerViewItemViewModel {

    val symbol = ObservableField("")
    val quantity = ObservableField("")
    val ltp = ObservableField("")
    val pl = ObservableField("")

    init {

        val profitLoss = getProfitLoss(data)

        symbol.set(data.symbol)
        quantity.set(data.quantity.toString())
        ltp.set("LTP: " + data.ltp.toString())
        pl.set("P/L: $profitLoss")
    }


}