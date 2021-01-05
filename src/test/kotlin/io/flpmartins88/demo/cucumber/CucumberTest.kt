package io.flpmartins88.demo.cucumber

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

// Rodar o Cucumber sem o Spring
@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/resources"],
    plugin = ["pretty"]
)
class CucumberTest {

}