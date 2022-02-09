package mx.kodemia.excepciones

import java.lang.ArithmeticException
import java.lang.NullPointerException
import java.lang.NumberFormatException

fun main() {
    askNombre()
}

fun askNombre() {
    println("Escribe tu nombre: ")

    try {
        var nombre: String? = readLine()
        nombre = invalidNombre(nombre)
        lengthNombre(nombre)
        indexNombre(nombre)
        divNombre(nombre)

    } catch (e: NullPointerException) {
        println("No escribiste nada")
    } catch (e: NumberFormatException) {
        println("Por favor, escribe un numero")
    } catch (e: StringIndexOutOfBoundsException) {
        println("El numero es muy grande, escribe un numero dentro del rango de caracteres de tu nombre")
    } catch (e: ArithmeticException) {
        println("No se puede dividir entre ese numero")
    }
}

fun lengthNombre(nombre: String?) {
    println("Tu nombre tiene: ${nombre!!.length} caracteres")
}

fun invalidNombre(nombre: String?): String? {
    if (nombre == "") {
        return null
    } else if (nombre!!.lowercase() == "alan") {
        throw NombreInvalidoException()
    }
    return nombre
}

fun indexNombre(nombre: String?) {
    println("Escribe un número")
    val indice = readLine()?.toInt()
    println("El indice: $indice contiene la letra: ${nombre!![indice!! - 1]}")
}

fun divNombre(nombre: String?) {
    println("Escribe otro numero")
    val div = readLine()?.toInt()
    println("El tamaño de caracteres ahora es de: ${nombre!!.length / div!!}")
}