package com.example.book.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.book.compose.AddBookWindow
import com.example.book.compose.BookList
import com.example.book.viewmodels.BookViewModel

@Composable
fun BookListScreen(viewModel: BookViewModel = viewModel()) {
    val allBooks by viewModel.allBooks.collectAsState()

    var open by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        viewModel.getAllBooks()
    }

    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Row {
            IconButton(onClick = viewModel::getAllBooks) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "Refresh Book List",
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = { open = true }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Book",
                )
            }
        }

        BookList(books = allBooks, onDelete = viewModel::deleteBook)

        AddBookWindow(
            open = open,
            onClose = { open = false },
            onSubmit = { book ->
                viewModel.addBook(book)
                open = false
            }
        )
    }
}

