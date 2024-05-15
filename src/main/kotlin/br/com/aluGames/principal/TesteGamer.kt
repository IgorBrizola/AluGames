import br.com.aluGames.modelo.Gamer

fun main(){


    val gamer1 = Gamer("Igor", "igor@alugamer.com")

    print(gamer1)


    val gamer2 = Gamer("Thauanny", "thauanny@alugamer.com", "09/03/2006", "thau")

    print(gamer2)

    gamer1.let {
        it.dataNascimento = "23/12/2005"
        it.usuario = "igu"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)

    gamer1.usuario = "igor"

    println(gamer1)
}