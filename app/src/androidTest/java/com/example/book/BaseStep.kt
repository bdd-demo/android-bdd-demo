package com.example.book

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.test.platform.app.InstrumentationRegistry
import com.example.book.test.ActivityScenarioHolder
import com.example.book.test.ComposeRuleHolder

abstract class BaseStep(
    protected val composeRuleHolder: ComposeRuleHolder,
    protected val scenarioHolder: ActivityScenarioHolder,
) : SemanticsNodeInteractionsProvider by composeRuleHolder.composeRule {

    fun createContext(): Context? {
        return InstrumentationRegistry.getInstrumentation().targetContext
    }
}
