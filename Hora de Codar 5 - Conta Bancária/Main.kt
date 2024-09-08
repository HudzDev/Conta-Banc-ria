fun main(){

    println("\nDigite seu nome: ")
    var nome = readln()

    println("\nOlá $nome é um prazer ter você por aqui!")

    val conta = Conta()

    inicio(conta, nome)

}

class Conta {
    var saldoConta = 20000
}

fun inicio(conta: Conta, nome: String){

    println("\nOque deseja fazer?")
    println("1- Saldo")
    println("2- Extrato")
    println("3- Saque")
    println("4- Depósito")
    println("5- Transferência")
    println("6- Sair\n")
    val função = readln().toInt()

    when(função) {
        1 -> saldo(conta, nome)
        2 -> extrato(conta, nome)
        3 -> saque(conta, nome)
        4 -> deposito(conta, nome)
        5 -> transferencia(conta, nome)
        6 -> sair(nome)
    }

}

fun saldo(conta: Conta, nome: String){

    var senha = ""
    println("\nPara ver saldo digite sua senha: ")
    senha = readln()

    while(senha != "3589"){
        println("\nSenha incorreta")
        saldo(conta, nome)
    }

    println("\nSaldo em conta: R$${conta.saldoConta}")

    var resposta: String
    println("\nDigite (ok) para voltar ao menu principal: ")
    resposta = readln()

    if (resposta == "ok") {
        inicio(conta, nome)
    }

}

fun extrato(conta: Conta, nome: String){

    var senha = ""
    println("\nPara ver extrato digite sua senha: ")
    senha = readln()

    while(senha != "3589"){
        println("\nSenha incorreta")
        extrato(conta, nome)
    }

    println("\npix para Fulano   07/09/24\n-R$ 130,00")
    println("\nfatura do cartão   06/09/24\n-R$ 1.500,00")
    println("\nspotify   06/09/24\n-R$ 27,90")
    println("\npix recebido   06/09/24\n+R$ 150,00")
    println("\nuber   06/09/24\n-R$ 15,00")
    println("\nmercado   06/09/24\n-R$ 750,00")
    println("\nsalario   05/09/24\n+R$ 15.000,00")
    println("\nsorveteria   05/09/24\n-R$ 50,00")
    println("\npix para Fulano   04/09/24\n-R$ 250,00")
    println("\npix recebido   04/09/24\n+R$ 390,00")

    var resposta: String
    println("\nDigite (ok) para voltar ao menu principal: ")
    resposta = readln()

    if (resposta == "ok"){
        inicio(conta, nome)
    }

}

fun saque(conta: Conta, nome: String) {

    var senha = ""
    println("\nPara fazer saque digite sua senha: ")
    senha = readln()

    while (senha != "3589") {
        println("\nSenha incorreta")
        saque(conta, nome)
    }

    if (conta.saldoConta == 0) {
        println("\nVocê está sem saldo, faça um depósito ou volte ao menu principal")
        var resposta_deposito: String
        println("\nDigite (sim) para fazer depósito ou (não) para retornar ao menu principal: ")
        resposta_deposito = readln()

        if (resposta_deposito == "sim") {
            deposito(conta, nome)
        } else {
            inicio(conta, nome)
        }

    } else {

        var valorSaque: Int
        println("\nDigite o valor que deseja sacar: ")
        valorSaque = readln().toInt()

        while (valorSaque > conta.saldoConta) {
            println("\nOperação não autorizada")
            println("Digite um novo valor: ")
            valorSaque = readln().toInt()
        }

        while (valorSaque <= 0) {
            println("\nOperação não autorizada")
            println("Digite um novo valor: ")
            valorSaque = readln().toInt()
        }

        conta.saldoConta -= valorSaque

        println("\nSaque no valor de R$$valorSaque realizado com sucesso!")

        var resposta: String
        println("\nDigite (ok) para voltar ao menu principal: ")
        resposta = readln()

        if (resposta == "ok") {
            inicio(conta, nome)
        }

    }
}

fun deposito(conta: Conta, nome: String){

    var deposito: Int
    println("\nDigite o valor do depósito: ")
    deposito = readln().toInt()

    println("\nValor de R$$deposito adicionado ao seu saldo")
    conta.saldoConta += deposito

    var resposta: String
    println("\nDigite (ok) para voltar ao menu principal: ")
    resposta = readln()

    if (resposta == "ok") {
        inicio(conta, nome)
    }
}

fun transferencia(conta: Conta, nome: String) {

    var senha = ""
    println("\nPara fazer transfêrencia digite sua senha: ")
    senha = readln()

    while (senha != "3589") {
        println("\nSenha incorreta")
        transferencia(conta, nome)
    }

    if (conta.saldoConta == 0) {
        println("\nVocê está sem saldo, faça um depósito ou volte ao menu principal")
        var resposta_deposito: String
        println("\nDigite (sim) para fazer depósito ou (não) para retornar ao menu principal: ")
        resposta_deposito = readln()

        if (resposta_deposito == "sim") {
            deposito(conta, nome)
        } else {
            inicio(conta, nome)
        }

    } else {

        println("\nDigite o número da conta que deseja transferir: ")
        var numeroConta = readln().toIntOrNull()

        while (numeroConta == null) {
            println("\nDigite apenas números")
            println("Tente novamente: ")
            numeroConta = readln().toIntOrNull()
        }

        println("\nDigite o valor da transferência: ")
        var valorTransf = readln().toInt()

        while (valorTransf > conta.saldoConta) {
            println("\nOperação não autorizada")
            println("Digite um valor válido: ")
            valorTransf = readln().toInt()
        }

        println("\nTransferência para a conta $numeroConta no valor de R$$valorTransf, realizada com sucesso.")
        conta.saldoConta -= valorTransf

        var resposta: String
        println("\nDigite (ok) para voltar ao menu principal: ")
        resposta = readln()

        if (resposta == "ok") {
            inicio(conta, nome)
        }
    }
}

fun sair(nome: String){

    println("\n$nome, foi um prazer ter você por aqui!")

}