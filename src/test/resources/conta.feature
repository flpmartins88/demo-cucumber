#language: pt

  Funcionalidade: Conta

    Cenário: Uma nova conta criada
      Quando uma nova conta é criada
      Então o saldo deve ser 0 reais

    Cenário: Depósito em conta nova
      Quando uma nova conta é criada
      E é feito um depósito de 500 reais
      Então o saldo deve ser 500 reais

    Cenário: Saque em conta sem saldo
      Quando uma nova conta é criada
      E é feito um saque de 500 reais
      Então deve dar erro de saldo insuficiente

    Cenário: Saque em conta com saldo
      Quando uma nova conta é criada
      E é feito um depósito de 900 reais
      E é feito um saque de 400 reais
      Então o saldo deve ser 500 reais