package com.example.book.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.book.data.Book


@Composable
fun BookList(books: List<Book>, onDelete: (String) -> Unit) {
    LazyColumn {
        items(books) { book ->
            BookListItem(book, onDelete = onDelete)
        }
    }
}
