package io.flpmartins88.demo.cucumber

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoCucumberApplication

fun main(args: Array<String>) {
    runApplication<DemoCucumberApplication>(*args)
}
