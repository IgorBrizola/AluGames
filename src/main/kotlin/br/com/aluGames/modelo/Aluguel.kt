package br.com.aluGames.modelo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
   val periodo: Periodo,

) {
    val valorAluguel: Double = gamer.plano.obterValor(this)


    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} pelo valor de $valorAluguel"
    }
}