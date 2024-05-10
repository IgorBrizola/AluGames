package br.com.aluGames.principal

import br.com.aluGames.servicos.ConsumoApi
import org.example.br.com.aluGames.modelo.Jogo
import java.util.*


fun main() {

    val leitura = Scanner(System.`in`)

    println("Digite um codigo de jogo para buscar: ")

    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()

    val informacaoJogo = buscaApi.buscaJogo(busca)

    var meuJogo: Jogo? = null

    val resultado = runCatching {

          meuJogo = Jogo(
              informacaoJogo.info.title,
              informacaoJogo.info.thumb)
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

        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso!")
    }


}