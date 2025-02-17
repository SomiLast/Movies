package com.example.mobile_development_lab_09.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://www.omdbapi.com/"
    private const val API_KEY = "39e646c9" // Ваш API-ключ

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(ApiInterceptor(API_KEY)) // Добавляем перехватчик
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient) // Устанавливаем OkHttpClient с перехватчиком
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
