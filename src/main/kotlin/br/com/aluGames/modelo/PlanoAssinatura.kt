package br.com.aluGames.modelo

 class PlanoAssinatura(
     tipo: String,
     val mensalidade: Double,
     val jogosIncluidos: Int
 ): Plano(tipo) {

     override fun obterValor(aluguel: Aluguel): Double {

         val totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataIncial.monthValue).size+1

         return if (totalJogosNoMes <= jogosIncluidos) {
             0.0
         } else {
             super.obterValor(aluguel)
         }
     }
}
