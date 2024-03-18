package com.example.book.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.book.api.Api
import com.example.book.api.BookApi
import com.example.book.data.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel(private val bookApi: BookApi = Api.bookApi) : ViewModel() {

    private val _allBooks = MutableStateFlow<List<Book>>(emptyList())
    val allBooks: StateFlow<List<Book>> = _allBooks

    fun getAllBooks() {
        viewModelScope.launch {
            try {
                _allBooks.value = bookApi.getAllBooks()
            }
            catch (e: Exception) {
                _allBooks.value = emptyList()
                Log.e("getBooks", "Failed:", e)
            }
        }
    }

    fun addBook(book: Book) {
        viewModelScope.launch {
            try {
                val response = bookApi.addBook(book)
                if (response.isSuccessful) {
                    getAllBooks()
                }
                else {
                    Log.e("addBook", "Failed: ${response.errorBody()}")
                }
            }
            catch (e: Exception) {
                Log.e("addBook", "Failed:", e)
            }
        }
    }

    fun deleteBook(id: String) {
        viewModelScope.launch {
            try {
                val response = bookApi.deleteBook(id)
                if (response.isSuccessful) {
                    getAllBooks()
                }
                else {
                    Log.e("deleteBook", "Failed: ${response.errorBody()}")
                }
            }
            catch (e: Exception) {
                Log.e("deleteBook", "Failed:", e)
            }
        }
    }
}
