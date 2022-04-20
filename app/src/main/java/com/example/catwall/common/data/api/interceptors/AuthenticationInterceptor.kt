package com.example.catwall.common.data.api.interceptors

import com.example.catwall.BuildConfig
import com.example.catwall.common.data.api.ApiParameters
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

const val AUTH_HEADER = ApiParameters.AUTH_HEADER

class AuthenticationInterceptor @Inject constructor():Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val interceptedRequest: Request = chain.headerRequest()
        return chain.proceed(interceptedRequest)
    }

    private fun Interceptor.Chain.headerRequest():Request{
//        val check = BuildConfig.apikey
        return request()
            .newBuilder()
            .addHeader(AUTH_HEADER,BuildConfig.apikey)
            .build()
    }
}