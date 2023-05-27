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