package com.example.book.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.book.data.Book


@Composable
fun BookListItem(book: Book, onDelete: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = book.title,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = book.author,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Edit Book",
                tint = MaterialTheme.colorScheme.primary,
            )
        }

        IconButton(onClick = { onDelete(book.id) }) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete Book",
                tint = MaterialTheme.colorScheme.error,
            )
        }
    }
}

