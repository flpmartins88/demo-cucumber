package io.flpmartins88.demo.cucumber

import io.cucumber.junit.CucumberOptions
import io.cucumber.spring.CucumberContextConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

@CucumberContextConfiguration
@SpringBootTest
@CucumberOptions(
    features = ["src/test/resources"],
    plugin = ["pretty"]
)
@AutoConfigureMockMvc
class SpringIntegrationTest
