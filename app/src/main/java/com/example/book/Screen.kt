package com.example.book

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    data object Main : Screen("main")
    data object BookList : Screen("bookList")
}
