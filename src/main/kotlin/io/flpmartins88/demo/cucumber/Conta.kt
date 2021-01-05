package io.flpmartins88.demo.cucumber

data class Conta(
    val usuario: Usuario,
    val numero: Long
) {

    var saldo: Long = 0
        private set

    fun depositar(valor: Long) {
        this.saldo += valor
    }

    fun retirar(valor: Long) {
        if (this.saldo < valor) {
            throw SaldoInsuficienteException()
        }

        this.saldo -= valor
    }

}

class SaldoInsuficienteException : Exception()