package com.example.agerasimenko.demoproject.data.retrofit

import okhttp3.Interceptor
import okhttp3.Response


class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        return chain?.run {
            val originalHttpUrl = request().url()
            val url = originalHttpUrl.newBuilder()
                    .build()
            val request = request().newBuilder()
                    .url(url).build()
            proceed(request)
        }
    }
}