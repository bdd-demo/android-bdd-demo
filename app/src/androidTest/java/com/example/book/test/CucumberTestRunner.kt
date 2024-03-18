package com.example.book.test

import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions


@CucumberOptions(
    features = ["features"],
    glue = ["com.example.book"],
)
class CucumberTestRunner : CucumberAndroidJUnitRunner()
