package io.flpmartins88.demo.cucumber

import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.junit.CucumberOptions
import io.cucumber.spring.CucumberContextConfiguration
import org.hamcrest.MatcherAssert
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.hamcrest.Matchers
import org.junit.Assert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.get

@CucumberContextConfiguration
@SpringBootTest
@CucumberOptions(
    features = ["src/test/resources"],
    plugin = ["pretty"]
)
@AutoConfigureMockMvc
class SpringIntegrationTest


class StepDefs : SpringIntegrationTest() {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private var result: MvcResult? = null

    @When("^o cliente chama /version$")
    fun `client gets the version`() {
        result = mockMvc.get("/version")
            .andDo { print() }
            .andExpect { status { isOk() } }
            .andReturn()
    }

    @Then("^o cliente recebe o status (\\d+)$")
    fun `client receives status code of`(statusCode: Int) {
        val currentStatusCode = result?.response?.status
        MatcherAssert.assertThat("incorrect status", currentStatusCode, Matchers.`is`(statusCode))
    }


    @Then("^o cliente recebe a versão (.+)$")
    fun `client receives server version body`(version: String) {
        val responseBody = result?.response?.contentAsString
        MatcherAssert.assertThat("incorrect body", responseBody, Matchers.`is`(version))

    }

}
