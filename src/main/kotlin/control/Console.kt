package control

class Console private constructor(){

    companion object {
        fun readInt(msg: String): Int {
            var convertResponse: Int? = null

            do {
                print(msg)
                val response = readlnOrNull()

                if (response != null && response != "" ) {
                    convertResponse = response.toIntOrNull();

                    if (convertResponse == null || convertResponse <= 0) {
                        println("Valor inválido, informe corretamente.")
                    }
                } else {
                    println("Valor inválido, informe corretamente.")
                }

            } while (convertResponse == null || convertResponse <= 0)

            return  convertResponse;
        }

        fun readString(msg: String): String {
            var convertResponse: String? = null

            do {
                print(msg)
                val response = readlnOrNull()

                if (response != null && response != "" ) {
                    convertResponse = response.lowercase()

                } else {
                    println("Valor inválido, informe corretamente.")
                }

            } while (convertResponse == null)

            return convertResponse
        }
    }

}