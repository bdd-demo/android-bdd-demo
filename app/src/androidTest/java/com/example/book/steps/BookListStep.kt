package com.example.book.steps

import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.book.BaseStep
import com.example.book.MockServerManager
import com.example.book.ServerManager
import com.example.book.api.BookApi
import com.example.book.screens.BookListScreen
import com.example.book.test.ActivityScenarioHolder
import com.example.book.test.ComposeRuleHolder
import com.example.book.viewmodels.BookViewModel
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class BookListStep(
    composeRuleHolder: ComposeRuleHolder,
    scenarioHolder: ActivityScenarioHolder,
    mockServerManager: MockServerManager = MockServerManager(),
) : BaseStep(composeRuleHolder, scenarioHolder), ServerManager by mockServerManager {


    @Before
    fun setup() {
        startServer()
    }

    @After
    fun tearDown() {
        stopServer()
    }


    @Given("User is on the book list page")
    fun userIsOnTheBookListPage() {
        addResponse(
            """[{"id": "1", "title": "Mock Book 1", "author": "Mock Author 1"}]""",
            200,
        )
        val mockApi = retrofit.create(BookApi::class.java)
        val viewModel = BookViewModel(bookApi = mockApi)

        composeRuleHolder.composeRule.setContent {
            BookListScreen(viewModel)
        }
    }

    @When("the book list page has loaded")
    fun theBookListPageHasLoaded() {

    }

    @Then("the page should display multiple book data")
    fun thePageShouldDisplayMultipleBookData() {
        onNodeWithText("Mock Book 1").assertExists()
    }
}
