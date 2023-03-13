package com.divtec.blatnoa.scannermateriel_poc.api

import okhttp3.Response

interface OnApiResponseCallback<T> {
    fun onSuccess(data: T)
    fun onError(response: Response? = null)
}