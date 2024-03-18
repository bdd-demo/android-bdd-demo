package com.example.book

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ServerManager {
    val mockWebServer: MockWebServer
    val retrofit: Retrofit

    fun startServer()
    fun stopServer()
    fun addResponse(body: String, statusCode: Int)
}

class MockServerManager : ServerManager {
    override lateinit var mockWebServer: MockWebServer
    override lateinit var retrofit: Retrofit

    override fun startServer() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun stopServer() {
        mockWebServer.shutdown()
    }

    override fun addResponse(body: String, statusCode: Int) {
        val mockResponse = MockResponse()
            .setBody(body)
            .setResponseCode(statusCode)
        mockWebServer.enqueue(mockResponse)
    }
}
