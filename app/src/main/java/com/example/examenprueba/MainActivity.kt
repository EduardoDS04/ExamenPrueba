package com.example.examenprueba
import kotlin.math.sqrt
import kotlin.math.abs

// Funcion para resolver una ecuacion de segundo grado o primer grado
fun f1(a: Double, b: Double, c: Double): Array<Double> {
    val TAG = "ECUACION_SEGUNDO_GRADO"

    // Caso especial: Si 'a' es 0, tenemos una ecuacion de primer grado
    if (a == 0.0) {
        // Si 'b' es diferente de 0, resolvemos bx + c = 0
        return if (b != 0.0) {
            val x1 = -c / b
            println("[$TAG] Ecuacion de primer grado con una solucion: x1 = $x1")
            arrayOf(2.0, x1, 0.0)
        } else {
            // Si 'b' es tambien 0, entonces no es una ecuacion valida
            println("[$TAG] No hay solucion (ni ecuacion valida)")
            arrayOf(0.0, 0.0, 0.0)
        }
    }

    // Si 'a' no es cero, procedemos con la solucion de segundo grado
    val valorDiscriminante = b * b - 4 * a * c

    return when {
        valorDiscriminante > 0 -> {
            val x1 = (-b + sqrt(valorDiscriminante)) / (2 * a)
            val x2 = (-b - sqrt(valorDiscriminante)) / (2 * a)
            println("[$TAG] Dos soluciones reales: x1 = $x1, x2 = $x2")
            arrayOf(1.0, x1, x2)
        }
        valorDiscriminante == 0.0 -> {
            val x1 = -b / (2 * a)
            println("[$TAG] Solucion doble: x1 = x2 = $x1")
            arrayOf(1.0, x1, x1)
        }
        else -> {
            println("[$TAG] No hay soluciones reales")
            arrayOf(0.0, 0.0, 0.0)
        }
    }
}

// Funcion para obtener el resultado segun el array devuelto por f1
fun operacion(resultado: Array<Double>): Double {
    return when (resultado[0].toInt()) {
        0 -> 0.0 // No tiene solucion
        1 -> abs(resultado[1]) + abs(resultado[2]) // Dos soluciones: valor absoluto de x1 + x2
        2 -> resultado[1] // Una sola solucion
        else -> 0.0
    }
}

// Funcion principal para probar los 4 casos
fun main() {
    val TAG = "ECUACION_SEGUNDO_GRADO"

    // Caso 1: Dos soluciones
    println("=== Caso 1: Dos soluciones ===")
    val resultado1 = f1(1.0, -3.0, 2.0)
    println("[$TAG] Array devuelto: ${resultado1.contentToString()}")
    println("[$TAG] Resultado de la operacion: ${operacion(resultado1)}")
    println()

    // Caso 2: Solucion doble
    println("=== Caso 2: Solucion doble ===")
    val resultado2 = f1(1.0, -2.0, 1.0)
    println("[$TAG] Array devuelto: ${resultado2.contentToString()}")
    println("[$TAG] Resultado de la operacion: ${operacion(resultado2)}")
    println()

    // Caso 3: Una unica solucion
    println("=== Caso 3: Una unica solucion ===")
    val resultado3 = f1(0.0, 4.0, -8.0)
    println("[$TAG] Array devuelto: ${resultado3.contentToString()}")
    println("[$TAG] Resultado de la operacion: ${operacion(resultado3)}")
    println()

    // Caso 4: No tiene solucion
    println("=== Caso 4: No tiene solucion ===")
    val resultado4 = f1(1.0, 2.0, 3.0)
    println("[$TAG] Array devuelto: ${resultado4.contentToString()}")
    println("[$TAG] Resultado de la operacion: ${operacion(resultado4)}")
}
