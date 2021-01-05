package io.flpmartins88.demo.cucumber

import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith
import org.springframework.http.HttpStatus

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/resources"],
    plugin = ["pretty"]
)
class CucumberTest {

}