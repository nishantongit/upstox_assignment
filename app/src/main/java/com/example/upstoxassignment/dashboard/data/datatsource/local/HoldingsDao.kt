package com.example.upstoxassignment.dashboard.data.datatsource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.upstoxassignment.dashboard.data.entities.local.HoldingsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HoldingsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(holdings: List<HoldingsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(holdings: HoldingsEntity)

    @Query("SELECT * FROM holdings")
    fun getAllHoldings(): Flow<List<HoldingsEntity>>
}