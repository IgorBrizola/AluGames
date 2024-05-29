package br.com.aluGames.modelo

import java.time.LocalDate
import java.time.Period

data class Periodo(val dataIncial: LocalDate, val dataFinal: LocalDate){


    val emDias =  Period.between(dataIncial, dataFinal).days
}
