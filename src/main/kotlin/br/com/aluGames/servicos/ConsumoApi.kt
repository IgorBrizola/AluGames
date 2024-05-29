package br.com.aluGames.servicos

import InfoJogoJson
import br.com.aluGames.modelo.Gamer
import br.com.aluGames.modelo.InfoGameJson
import br.com.aluGames.modelo.Jogo
import br.com.aluGames.ultilitarios.criaGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import criaJogo
import org.example.br.com.aluGames.modelo.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {

   private  fun consomeDados(endereco:String): String {

        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        return    response.body()

    }

    fun buscaJogosJson(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consomeDados(endereco)

        val gson = Gson()
        val meuJogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogo: List<InfoJogoJson> = gson.fromJson(json, meuJogoTipo)

        val listaJogoConvertida = listaJogo.map { infoJogoJson -> infoJogoJson.criaJogo() }

        return listaJogoConvertida
    }


    fun buscaGamers():List<Gamer> {

        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consomeDados(endereco)

        val gson = Gson();

        val meuGamerTipo = object : TypeToken<List<InfoGameJson>> () {}.type

        val listaGamer: List<InfoGameJson> = gson.fromJson(json, meuGamerTipo)

       val listaGamerConvertida = listaGamer.map { infoGameJson -> infoGameJson.criaGamer()   }

        return listaGamerConvertida

    }



}