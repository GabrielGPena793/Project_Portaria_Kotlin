package control

import business.ConvidadoBusiness
import entity.Convidado

class Portaria {

    private val conviteBusiness = ConvidadoBusiness()

    init {
        println("Portaria inicializada")
        println(controle())
    }

    private fun controle(): String {
        val idade = Console.readInt("Qual a sua idade? ")
        val convidado = Convidado(idade = idade)

        if (!conviteBusiness.eMaiorDeIdade(convidado.idade)) {
            return "Negado. Menores de idade não são permitidos."
        }

        val inviteType = Console.readString("Qual é o tipo de convite? ")
        convidado.tipo = inviteType
        if(!conviteBusiness.convidadoValido(convidado.tipo)) {
            return "Negado. Convite inválido."
        }

        val codigo = Console.readString("Qual o código do convite?  ")
        convidado.codigo = codigo
        if(!conviteBusiness.codigoValido(convidado)) {
            return "Negado. Convite inválido."
        }

        return "Welcome! :)"
    }
}


// Função portaria usada para consulta

fun portaria() {


    print("Qual é o tipo de convite? ")
    var tipoConvite = readLine()

    if (tipoConvite != null && tipoConvite != "") {
        tipoConvite = tipoConvite.lowercase()

        // Validação do tipo de convite
        if (tipoConvite != "comum" && tipoConvite != "premium" && tipoConvite != "luxo") {
            println("Negado. entity.Convite inválido.")
            return
        }

        print("Qual o código do convite? ")
        var codigo = readLine()

        if (codigo != null && codigo != "") {
            codigo = codigo.lowercase()

            if (tipoConvite == "comum" && codigo.startsWith("xt")) {
                println("Welcome :)")
            } else if ((tipoConvite == "premium" || tipoConvite == "luxo") && codigo.startsWith("xl")
            ) {
                println("Welcome :)")
            } else {
                println("Negado. entity.Convite inválido")
            }
        }
    }
}
