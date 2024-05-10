fun readNumber(): Int {
    var inputNumber = 0

    do {
        println("Introduzca un número:")
        try {
            inputNumber = readln().toIntOrNull()!!

            if (isNumberPositive(inputNumber)) break
            else println("Debe introducir un número positivo mayor que 0.")

        } catch (e: NullPointerException) {
            println("Debe introducir un número válido.")
        } catch (e: Exception) {
            println("Error : ${e.message}")
        }

    } while (inputNumber <= 0)

    return inputNumber

}

fun isNumberPositive(number: Int) = number > 0

fun isNumberPair(number: Int): Boolean = number % 2 == 0

fun printTitule(number: Int) {
    if (isNumberPair(number)) println("Serie del número par $number")
    else println("Serie del número impar $number")
}

fun printNumbers(number: Int) {
    printTitule(number)

    for (i in number downTo 1 step 2) {
        println(i)
    }
}
