package com.divtec.blatnoa.scannermateriel_poc.api

import okhttp3.Response

interface OnApiResponseCallback {
    fun onSuccess(response: Response)
    fun onError()
}