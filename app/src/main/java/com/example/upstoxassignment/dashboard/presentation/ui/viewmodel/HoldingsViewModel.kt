package com.example.upstoxassignment.dashboard.presentation.ui.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.upstoxassignment.base.network.NetworkResult
import com.example.upstoxassignment.dashboard.data.entities.local.DataDom
import com.example.upstoxassignment.dashboard.domain.usecase.GetHoldings
import com.example.upstoxassignment.util.HoldingCalculator.getCurrentValue
import com.example.upstoxassignment.util.HoldingCalculator.getInvetmentValue
import com.example.upstoxassignment.util.HoldingCalculator.getTodaysProfitLoss
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HoldingsViewModel(val getHoldings: GetHoldings) : ViewModel() {

    val holdingLive = MutableLiveData<ArrayList<DataDom>>()

    val totalCurrentValueObservable = ObservableField("")
    val totalInvestmentObservable = ObservableField("")
    val todayProfitLossObservable = ObservableField("")
    val profitAndLossObservable = ObservableField("")

    fun onLoad() {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()

            //Handle exception

            viewModelScope.launch(Dispatchers.IO) {
                loadFromLocal()
            }
        }

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            loadFromRemote()
        }
    }

    private suspend fun loadFromLocal() {
        getHoldings.getFromLocal().collect {
            holdingLive.postValue(it)
            updateValues(it)
        }
    }

    suspend fun loadFromRemote() {
        when (val result = getHoldings.invoke()) {
            is NetworkResult.Error -> {
                //send error to UI
                loadFromLocal()
            }

            is NetworkResult.Success<*> -> {
                val items = result.data as ArrayList<DataDom>
                holdingLive.postValue(items)
                Log.d("response vm", items.toString())
                updateValues(items)
            }
        }
    }

    fun updateValues(dataDoms: ArrayList<DataDom>) {
        var invetmentValue = 0.0
        var currentValue = 0.0
        var todaysPL = 0.0
        dataDoms.forEach {
            invetmentValue += getInvetmentValue(it)
            currentValue += getCurrentValue(it)
            todaysPL += getTodaysProfitLoss(it)
        }

        totalCurrentValueObservable.set(currentValue.toString())
        totalInvestmentObservable.set(invetmentValue.toString())
        todayProfitLossObservable.set(todaysPL.toString())

        profitAndLossObservable.set((currentValue - invetmentValue).toString())

    }

}