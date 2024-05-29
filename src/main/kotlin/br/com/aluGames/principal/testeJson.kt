import br.com.aluGames.modelo.Periodo
import br.com.aluGames.modelo.PlanoAssinatura
import br.com.aluGames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main(){

    val consumo = ConsumoApi()

    val listaGamers = consumo.buscaGamers()
    val listaJogo = consumo.buscaJogosJson()

    val jogoGtaV = listaJogo.get(1)

    val gamerCaroline2 = listaGamers.get(3)
    val jogoSpiderMan = listaJogo.get(13)

    val gamerCaroline3 = listaGamers.get(3)
    val jogoTheLast = listaJogo.get(2)



    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(14))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(21))
    val periodo4 = Periodo(LocalDate.of(2023,8,2), LocalDate.of(2023,8,15))


  //  println(gamerCaroline.jogosAlugados)

    val gamerCamila = listaGamers.get(5)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogo.get(10)
    val jogoSpider = listaJogo.get(13)
    val jogoTheLastOfUs = listaJogo.get(2)
    val jogoDandara = listaJogo.get(5)
    val jogoAssassins = listaJogo.get(4)
    val jogoCyber = listaJogo.get(6)
    val jogoGod = listaJogo.get(7)
    val jogoSkyrim = listaJogo.get(18)

    gamerCaroline.alugaJogo(jogoSpiderMan,  periodo)

    gamerCaroline2.alugaJogo(jogoGtaV,  periodo2)

    gamerCaroline3.alugaJogo(jogoTheLast,  periodo3)
    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)


    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)

    gamerCamila.alugaJogo(jogoGtaV, periodo)
    gamerCamila.alugaJogo(jogoSpiderMan, periodo2)
    gamerCamila.alugaJogo(jogoTheLast, periodo3)
//    println(gamerCamila.jogosAlugados)


    gamerCamila.recomendar(4)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(10)

 //   println(gamerCamila)

    gamerCamila.alugaJogo(jogoGtaV, periodo2)

   // println(gamerCamila.jogosAlugados)

    gamerCamila.recomendarJogo(jogoSpiderMan, 10)
    gamerCamila.recomendarJogo(jogoTheLast, 7)
    gamerCamila.recomendarJogo(jogoGtaV, 10)

    gamerCaroline.recomendarJogo(jogoSpiderMan, 10)
    gamerCaroline.recomendarJogo(jogoTheLast, 10)
    gamerCaroline.recomendarJogo(jogoGtaV, 5)

    println("RECOMENDAÇÃO DA CAMILA")
    println(gamerCamila.jogosRecomendados)

    println("RECOMENDAÇÃO DA CAROLINE")
    println(gamerCaroline.jogosRecomendados)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)

    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)



}