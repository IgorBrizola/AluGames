package br.com.aluGames.principal

import br.com.aluGames.modelo.Gamer
import br.com.aluGames.servicos.ConsumoApi
import br.com.aluGames.modelo.Jogo
import transformarEmIdade
import java.util.*


fun main() {

    val leitura = Scanner(System.`in`)

    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluido com sucesso. Dados do gamer: ")
    println(gamer)

    println("Idade do gamer: " + gamer.dataNascimento?.transformarEmIdade())

    do {

        println("Digite um codigo de jogo para buscar: ")

        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()

        val informacaoJogo = buscaApi.buscaJogosJson()

        var meuJogo: Jogo? = null

        val resultado = runCatching {


        }

        resultado.onFailure {
            println("Jogo inexistente. Tente outro id")
        }

        resultado.onSuccess {
            println("\nDeseja inserir um descrição personalizada? S/N")

            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)){

                println("Insira a descrição personalizada para o jogo: ")
                val descricaoPersonalizada = leitura.nextLine()

                meuJogo?.descricao = descricaoPersonalizada


            }else{

                meuJogo?.descricao = meuJogo?.titulo

            }
                gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja busca um novo jogo? S/N")

        val resposta = leitura.nextLine()


    } while (resposta.equals("s",  true))

    println("Jogos buscados: ")
    println(gamer.jogosBuscados)

    println("\nJogos ordenados por titulos:")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach{


        println("Titulo: " + it?.titulo)


    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }
    println("\nJogos Filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()

    if (opcao.equals("s", true)){
        println(gamer.jogosBuscados)
        println("\nInforme a posição do jogo que deseja exlcuir: ")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("Lista atualizada: ")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso!")





}