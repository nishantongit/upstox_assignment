package com.example.upstoxassignment

import com.example.upstoxassignment.base.network.NetworkResult
import com.example.upstoxassignment.dashboard.data.entities.local.DataDom
import com.example.upstoxassignment.dashboard.data.entities.local.HoldingsDom
import com.example.upstoxassignment.dashboard.data.entities.remote.DataDto
import com.example.upstoxassignment.dashboard.data.entities.remote.HoldingsDto
import com.example.upstoxassignment.dashboard.domain.repository.HoldingsRepository
import com.example.upstoxassignment.dashboard.domain.usecase.GetHoldings
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock

class HoldingRepositoryTest {

    lateinit var holdingRepository : HoldingsRepository

    @Before
    fun before() {
        holdingRepository = mockk()
    }

    @Test
    fun testHoldingUseCase() {
        val getHoldingUseCase = GetHoldings(holdingRepository)

        val item = HoldingsDom(data = arrayListOf(DataDom(avgPrice = 25.0)))
        runBlocking {
            coEvery {
                holdingRepository.getHoldings()
            }returns NetworkResult.Success(item)

            val avgResult = (getHoldingUseCase.invoke() as NetworkResult.Success<HoldingsDom>).data.data[0].avgPrice

            assert(avgResult == 25.0)

        }
    }
}