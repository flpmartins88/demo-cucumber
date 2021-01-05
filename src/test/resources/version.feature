#language: pt

  Funcionalidade: recuperar a versão do sistema

    Cenário: O cliente faz uma requisição GET para /version
      Quando o cliente chama /version
      Então o cliente recebe o status 200
      E o cliente recebe a versão 1.0
