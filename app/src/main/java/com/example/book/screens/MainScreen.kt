package com.example.book.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(onBookList: () -> Unit) {
    Column {
        Text(text = "Welcome to the Book App")

        Button(onClick = onBookList) {
            Text(text = "Book List")
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(onBookList = {})
}
