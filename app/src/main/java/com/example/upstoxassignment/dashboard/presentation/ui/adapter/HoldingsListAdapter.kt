package com.example.upstoxassignment.dashboard.presentation.ui.adapter

import com.example.upstoxassignment.R
import com.example.upstoxassignment.base.adapter.RecyclerViewAdapter
import com.example.upstoxassignment.dashboard.data.entities.local.DataDom
import com.example.upstoxassignment.dashboard.presentation.ui.viewmodel.HoldingItemVm

class HoldingsListAdapter : RecyclerViewAdapter() {


    override fun getViewModel(position: Int): RecyclerViewItemViewModel {
        return HoldingItemVm(
            list[position].any as DataDom
        )
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.holding_item
    }

    fun swapData(dataDoms: ArrayList<DataDom>) {
        list.clear()
        dataDoms.forEach {
            list.add(RecyclerViewItem("", it))
        }

        notifyDataSetChanged()
    }


}