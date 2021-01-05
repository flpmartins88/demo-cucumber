package io.flpmartins88.demo.cucumber

import java.util.UUID

data class Usuario (
    val id: String = UUID.randomUUID().toString(),
    val nome: String
)