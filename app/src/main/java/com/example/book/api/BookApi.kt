package com.example.book.api

import com.example.book.data.Book
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BookApi {
    @GET("book/")
    suspend fun getAllBooks(): List<Book>

    @POST("book/")
    suspend fun addBook(@Body book: Book): Response<Book>

    @DELETE("book/{id}/")
    suspend fun deleteBook(@Path("id") id: String): Response<Unit>
}
