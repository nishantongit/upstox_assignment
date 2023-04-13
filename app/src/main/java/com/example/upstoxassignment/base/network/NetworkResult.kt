package com.example.upstoxassignment.base.network

public sealed class NetworkResult {
    public final data class Error(val code: Int) : NetworkResult()

    public final data class Success<out T> public constructor(val data: T) : NetworkResult()
}