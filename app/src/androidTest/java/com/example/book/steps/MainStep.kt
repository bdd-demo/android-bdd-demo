package com.example.book.steps

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.book.BaseStep
import com.example.book.MainActivity
import com.example.book.test.ActivityScenarioHolder
import com.example.book.test.ComposeRuleHolder
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainStep(
    composeRuleHolder: ComposeRuleHolder,
    scenarioHolder: ActivityScenarioHolder,
) : BaseStep(composeRuleHolder, scenarioHolder) {

    @Given("I initially visit the Main page")
    fun iInitiallyVisitTheMainPage() {
        val appContext = createContext()!!
        scenarioHolder.launch(MainActivity.create(appContext))
    }

    @Then("I should see {string}")
    fun iShouldSee(string: String) {
        onNodeWithText(string).assertIsDisplayed()
    }
}
