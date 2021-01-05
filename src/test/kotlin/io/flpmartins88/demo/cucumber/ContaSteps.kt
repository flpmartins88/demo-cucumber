package io.flpmartins88.demo.cucumber

import io.cucumber.java.pt.E
import io.cucumber.java.pt.Então
import io.cucumber.java.pt.Quando
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc

class ContaSteps : SpringIntegrationTest() {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private var conta: Conta? = null
    private var exception: Exception? = null

    @Quando("^uma nova conta é criada$")
    fun createAccount() {
        this.conta = Conta(Usuario(nome = "João"), 1)
    }

    @E("^é feito um depósito de (\\d+) reais$")
    fun realizaDeposito(valorDeposito: Long) {
        this.conta?.depositar(valorDeposito)
    }

    @E("^é feito um saque de (\\d+) reais$")
    fun realizaSaque(valorSaque: Long) {
        try {
            this.conta?.retirar(valorSaque)
        } catch (ex: Exception) {
            // TODO: Segundo um maluco no StackOverflow não devemos testar erros com o cucumber
            exception = ex
        }
    }

    @Então("^deve dar erro de saldo insuficiente")
    fun erroSaldoInsuficiente() {
        MatcherAssert.assertThat(
            this.exception?.javaClass,
            Matchers.`is`(SaldoInsuficienteException::class.java)
        )
    }

    @Então("^o saldo deve ser (\\d+) reais$")
    fun verificaSaldo(saldoEsperado: Long) {
        MatcherAssert.assertThat(
            "saldo incorreto",
            this.conta?.saldo,
            Matchers.`is`(saldoEsperado)
        )
    }

}