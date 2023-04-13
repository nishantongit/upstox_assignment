package com.example.upstoxassignment.dashboard.data.entities.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "holdings",
    indices = [
        Index(value = ["symbol"])
    ]
)

data class HoldingsEntity(
    @PrimaryKey
    @ColumnInfo("symbol")
    var symbol: String,
    @ColumnInfo("avg_price")
    var avgPrice: Double = 0.0,
    @ColumnInfo("cnc_used_quantity")
    var cncUsedQuantity: Double? = null,
    @ColumnInfo("collateral_qty")
    var collateralQty: Double? = null,
    @ColumnInfo("collateral_type")
    var collateralType: String? = null,
    @ColumnInfo("collateral_update_qty")
    var collateralUpdateQty: Double? = null,
    @ColumnInfo("company_name")
    var companyName: String? = null,
    @ColumnInfo("haircut")
    var haircut: Double? = null,
    @ColumnInfo("holdings_update_qty")
    var holdingsUpdateQty: Double? = null,
    @ColumnInfo("isin")
    var isin: String? = null,
    @ColumnInfo("product")
    var product: String? = null,
    @ColumnInfo("quantity")
    var quantity: Double = 0.0,
    @ColumnInfo("t1_holding_qty")
    var t1HoldingQty: Double? = null,
    @ColumnInfo("token_bse")
    var tokenBse: String? = null,
    @ColumnInfo("token_nse")
    var tokenNse: String? = null,
    @ColumnInfo("withheld_collateral_qty")
    var withheldCollateralQty: Double? = null,
    @ColumnInfo("withheld_holding_qty")
    var withheldHoldingQty: Double? = null,
    @ColumnInfo("ltp")
    var ltp: Double = 0.0,
    @ColumnInfo("close")
    var close: Double = 0.0
)