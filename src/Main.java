/*
 *Escriba un algoritmo que lea un número entero y determine si es par o impar. Si es par, que escriba
 * todos los pares de manera descendiente desde sí mismo y hasta cero. Si es impar, que escriba todos
 * los impares de manera descendiente desde sí mismo hasta el uno. Utilice la instrucción LEER NUMERO
 * al inicio del programa para cargar un número en la variable NUMERO.
 * */

public class Main {
    public static void main(String[] args) {
        var number = AlgorithmKt.readNumber();
        AlgorithmKt.printNumbers(number);


    }
}