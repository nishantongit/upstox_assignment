package com.example.upstoxassignment.dashboard.presentation.injection

import android.content.Context
import com.example.upstoxassignment.dashboard.presentation.ui.view.HoldingsFragment
import dagger.Component

@Component(modules = [HoldingModule::class])
interface HoldingComponent {

    fun inject(holdingsFragment: HoldingsFragment)

    object Initializer {
        fun init(context: Context): HoldingComponent {
            val holdingModule = HoldingModule(context)
            holdingModule.context = context
            return DaggerHoldingComponent.builder()
                .holdingModule(holdingModule).build()
        }
    }
}