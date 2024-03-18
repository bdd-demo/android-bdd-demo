package com.example.book

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.book.ui.theme.BookTheme

class MainActivity : ComponentActivity() {
    companion object {
        fun create(context: Context): Intent =
            Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookTheme {
                BookApp()
            }
        }
    }
}
