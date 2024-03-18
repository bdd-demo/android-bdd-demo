package com.example.book.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val bookApi: BookApi = retrofit.create(BookApi::class.java)
}
