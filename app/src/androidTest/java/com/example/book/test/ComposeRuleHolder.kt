package com.example.book.test


import androidx.compose.ui.test.junit4.createComposeRule
import io.cucumber.junit.WithJunitRule
import org.junit.Rule


@WithJunitRule
class ComposeRuleHolder {

    @get:Rule
    val composeRule = createComposeRule()
}
