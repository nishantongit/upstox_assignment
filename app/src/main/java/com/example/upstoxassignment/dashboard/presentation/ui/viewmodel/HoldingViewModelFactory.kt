package com.example.upstoxassignment.dashboard.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.upstoxassignment.dashboard.domain.usecase.GetHoldings

class HoldingViewModelFactory(val getHolding: GetHoldings) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HoldingsViewModel::class.java) -> HoldingsViewModel(
                getHolding
            ) as T
            else -> throw java.lang.IllegalArgumentException("No ViewModel Found")
        }
    }
}