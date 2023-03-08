package com.divtec.blatnoa.scannermateriel_poc.api

import okhttp3.OkHttpClient
import okhttp3.Request
import kotlinx.serialization.*

class ApiManager(
    private val url: String,
    private val token: String)
{
    private val client = OkHttpClient()

    public fun run(action: String) {
        val request = Request.Builder()
            .url(url+action)
            .build()
    }

}