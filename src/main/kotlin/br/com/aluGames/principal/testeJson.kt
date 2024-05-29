import br.com.aluGames.modelo.Periodo
import br.com.aluGames.modelo.PlanoAssinatura
import br.com.aluGames.servicos.ConsumoApi
import java.time.LocalDate

fun main(){

    val consumo = ConsumoApi()

    val listaGamers = consumo.buscaGamers()
    val listaJogo = consumo.buscaJogosJson()

    val gamerCaroline = listaGamers.get(3)
    val jogoGtaV = listaJogo.get(1)

    val gamerCaroline2 = listaGamers.get(3)
    val jogoSpiderMan = listaJogo.get(13)

    val gamerCaroline3 = listaGamers.get(3)
    val jogoTheLast = listaJogo.get(2)


    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(14))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(21))
    val periodo4 = Periodo(LocalDate.of(2023,8,2), LocalDate.of(2023,8,15))

   gamerCaroline.alugaJogo(jogoSpiderMan,  periodo)

    gamerCaroline2.alugaJogo(jogoGtaV,  periodo2)

    gamerCaroline3.alugaJogo(jogoTheLast,  periodo3)

  //  println(gamerCaroline.jogosAlugados)

    val gamerCamila = listaGamers.get(5)

    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)

    gamerCamila.alugaJogo(jogoGtaV, periodo)
    gamerCamila.alugaJogo(jogoSpiderMan, periodo2)
    gamerCamila.alugaJogo(jogoTheLast, periodo3)
    println(gamerCamila.jogosAlugados)


    gamerCamila.recomendar(4)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(10)

    println(gamerCamila)

    gamerCamila.alugaJogo(jogoGtaV, periodo2)

    println(gamerCamila.jogosAlugados)



}