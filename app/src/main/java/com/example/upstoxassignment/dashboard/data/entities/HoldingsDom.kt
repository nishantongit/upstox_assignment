package com.example.upstoxassignment.dashboard.data.entities

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class HoldingsDto(
    @SerializedName("client_id") var clientId: String? = null,
    @SerializedName("data") var data: ArrayList<Data> = arrayListOf(),
    @SerializedName("error") var error: String? = null,
    @SerializedName("response_type") var responseType: String? = null,
    @SerializedName("timestamp") var timestamp: Long? = null
)


@Keep
data class Data(
    @SerializedName("avg_price") var avgPrice: String? = null,
    @SerializedName("cnc_used_quantity") var cncUsedQuantity: Double? = null,
    @SerializedName("collateral_qty") var collateralQty: Double? = null,
    @SerializedName("collateral_type") var collateralType: String? = null,
    @SerializedName("collateral_update_qty") var collateralUpdateQty: Double? = null,
    @SerializedName("company_name") var companyName: String? = null,
    @SerializedName("haircut") var haircut: Double? = null,
    @SerializedName("holdings_update_qty") var holdingsUpdateQty: Double? = null,
    @SerializedName("isin") var isin: String? = null,
    @SerializedName("product") var product: String? = null,
    @SerializedName("quantity") var quantity: Double? = null,
    @SerializedName("symbol") var symbol: String? = null,
    @SerializedName("t1_holding_qty") var t1HoldingQty: Double? = null,
    @SerializedName("token_bse") var tokenBse: String? = null,
    @SerializedName("token_nse") var tokenNse: String? = null,
    @SerializedName("withheld_collateral_qty") var withheldCollateralQty: Double? = null,
    @SerializedName("withheld_holding_qty") var withheldHoldingQty: Double? = null,
    @SerializedName("ltp") var ltp: Double? = null,
    @SerializedName("close") var close: Double? = null
)