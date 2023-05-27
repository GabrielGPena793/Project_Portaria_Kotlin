package business

import entity.Convidado

class ConvidadoBusiness {

    fun convidadoValido(tipo: String): Boolean = (tipo == "comum" || tipo == "premium" || tipo == "luxo")

    fun eMaiorDeIdade(idade: Int) = idade >= 18

    fun codigoValido(convidado: Convidado) = when (convidado.tipo) {
        "comum" -> convidado.codigo.startsWith("xt")
        "luxo", "premium" -> convidado.codigo.startsWith("xl")
        else -> false
    }

}