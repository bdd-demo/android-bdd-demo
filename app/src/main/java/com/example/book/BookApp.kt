package com.example.book

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.book.screens.BookListScreen
import com.example.book.screens.MainScreen

@Composable
fun BookApp() {
    val navController = rememberNavController()
    BookNavHost(
        navController = navController
    )
}

@Composable
fun BookNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(Screen.Main.route) {
            MainScreen(
                onBookList = {
                    navController.navigate(Screen.BookList.route)
                },
            )
        }
        composable(Screen.BookList.route) {
            BookListScreen()
        }
    }
}
