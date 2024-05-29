package br.com.aluGames.ultilitarios

import br.com.aluGames.modelo.Gamer
import br.com.aluGames.modelo.InfoGameJson

fun InfoGameJson.criaGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario)
}