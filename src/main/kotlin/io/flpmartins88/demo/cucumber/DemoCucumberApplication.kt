package io.flpmartins88.demo.cucumber

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.RestController




@SpringBootApplication
class DemoCucumberApplication

fun main(args: Array<String>) {
    runApplication<DemoCucumberApplication>(*args)
}

@RestController
class VersionController {

    @GetMapping("/version")
    fun version(): String = "1.0"
}