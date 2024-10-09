package com.example.examenprueba

import kotlin.math.sqrt
import kotlin.math.abs

// Funcion para resolver una ecuacion de segundo grado o primer grado
fun f1(a: Double, b: Double, c: Double): Array<Double> {
    val TAG = "ECUACION_SEGUNDO_GRADO"

    if (a == 0.0) {
        return if (b != 0.0) {
            val x1 = -c / b
            println("[$TAG] Ecuacion de primer grado con una solucion: x1 = $x1")
            arrayOf(2.0, x1, 0.0)
        } else {
            println("[$TAG] No hay solucion (ni ecuacion valida)")
            arrayOf(0.0, 0.0, 0.0)
        }
    }

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
        0 -> 0.0
        1 -> abs(resultado[1]) + abs(resultado[2])
        2 -> resultado[1]
        else -> 0.0
    }
}

// Lambda para el ejercicio 2: Multiplicacion de tres valores
val multiplicacionLambda: (Double, Double, Double) -> Double = { x, y, z ->
    if (x == 0.0 && y == 0.0 && z == 0.0) 1.0 else x * y * z
}

// Funcion para el ejercicio 3: Calcular sumatorio de un array usando una lambda
fun f2(array: Array<Double>, x1: Double, x2: Double, x3: Double, lambda: (Double, Double, Double) -> Double): Double {
    return array.sumOf { it * lambda(x1, x2, x3) }
}

// Funcion principal para probar los 4 casos y ejercicios adicionales
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
    println()

    // Ejercicio 2: Multiplicacion de tres valores usando la lambda
    println("=== Ejercicio 2: Multiplicacion ===")
    val multiplicacionResultado1 = multiplicacionLambda(1.0, 2.0, 3.0)
    println("[$TAG] Resultado de la multiplicacion 1: $multiplicacionResultado1")

    val multiplicacionResultado2 = multiplicacionLambda(0.0, 0.0, 0.0)
    println("[$TAG] Resultado de la multiplicacion 2 (deberia ser 1): $multiplicacionResultado2")
    println()

    // Ejercicio 3: Sumatorio usando la funcion f2 y la lambda
    println("=== Ejercicio 3: Sumatorio ===")
    val array = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
    val sumatorioResultado = f2(array, 1.0, 2.0, 3.0) { x1, x2, x3 -> x1 - x2 * x3 }
    println("[$TAG] Resultado del sumatorio: $sumatorioResultado")
}
