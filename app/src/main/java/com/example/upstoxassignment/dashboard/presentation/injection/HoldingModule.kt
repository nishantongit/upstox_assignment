package com.example.upstoxassignment.dashboard.presentation.injection

import android.content.Context
import com.example.upstoxassignment.base.db.AppDatabase
import com.example.upstoxassignment.dashboard.data.api.ApiClient
import com.example.upstoxassignment.dashboard.data.api.HoldingsService
import com.example.upstoxassignment.dashboard.data.datatsource.local.HoldingsDao
import com.example.upstoxassignment.dashboard.data.datatsource.local.HoldingsLDS
import com.example.upstoxassignment.dashboard.data.datatsource.local.HoldingsLDSImpl
import com.example.upstoxassignment.dashboard.data.datatsource.remote.HoldingsRDS
import com.example.upstoxassignment.dashboard.data.datatsource.remote.HoldingsRDSImpl
import com.example.upstoxassignment.dashboard.data.repository.HoldingsRepositoryImpl
import com.example.upstoxassignment.dashboard.domain.repository.HoldingsRepository
import com.example.upstoxassignment.dashboard.domain.usecase.GetHoldings
import com.example.upstoxassignment.dashboard.presentation.ui.viewmodel.HoldingViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HoldingModule(var context: Context) {


    @Provides
    fun provideHoldingRepository(
        holdingsLDS: HoldingsLDS,
        holdingsRDS: HoldingsRDS
    ): HoldingsRepository {
        return HoldingsRepositoryImpl(holdingsRDS, holdingsLDS)
    }

    @Provides
    fun provideHoldingRDS(holdingsService: HoldingsService): HoldingsRDS {
        return HoldingsRDSImpl(holdingsService)
    }

    @Provides
    fun provideHoldingService(): HoldingsService {
        return ApiClient.getService()
    }

    @Provides
    fun provideHoldingLDS(holdingsDao: HoldingsDao): HoldingsLDS {
        return HoldingsLDSImpl(holdingsDao)
    }

    @Provides
    fun provideHoldingDao(): HoldingsDao {
        return AppDatabase.getDatabase(context).holdingsDao()
    }

    @Provides
    fun provideHoldingViewModelFactory(holdingsUsecase: GetHoldings): HoldingViewModelFactory {
        return HoldingViewModelFactory(holdingsUsecase)
    }

    @Provides
    fun provideHoldingsUseCase(holdingsRepository: HoldingsRepository): GetHoldings {
        return GetHoldings(holdingsRepository)
    }


}