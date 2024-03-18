package com.example.book.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.book.data.Book

@Composable
fun AddBookWindow(open: Boolean, onClose: () -> Unit, onSubmit: (Book) -> Unit) {
    var newBook by remember { mutableStateOf(Book(title = "", author = "")) }
    var hasError by remember { mutableStateOf(false) }

    if (open) {
        AlertDialog(
            title = { Text("Add Book") },
            text = {
                Column {
                    TextField(
                        value = newBook.title,
                        label = { Text("Title") },
                        onValueChange = {
                            newBook = newBook.copy(title = it)
                            hasError = false
                        }
                    )
                    TextField(
                        value = newBook.author,
                        label = { Text("Author") },
                        onValueChange = {
                            newBook = newBook.copy(author = it)
                            hasError = false
                        },
                    )
                    if (hasError) {
                        Text("Title and Author are required", color = Color.Red)
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (newBook.title.isEmpty() || newBook.author.isEmpty()) {
                            hasError = true
                        }
                        else {
                            onSubmit(newBook)
                            newBook = Book(title = "", author = "")
                        }
                    }
                ) {
                    Text("Add")
                }
            },
            onDismissRequest = onClose,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddBookWindowPreview() {
    AddBookWindow(open = true, onClose = {}, onSubmit = {})
}
