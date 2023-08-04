package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        List<Integer> numeros = leerNumerosDesdeConsola();
        List<Integer> pares = obtenerNumerosPares(numeros);
        int sumaPrimos = calcularSumaPrimos(numeros);

        System.out.println("Números pares ingresados: " + pares);
        System.out.println("Suma de los números primos: " + sumaPrimos);
    }

    public static List<Integer> leerNumerosDesdeConsola() {
        List<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese números (ingrese -1 para detenerse):");

        int numero;
        do {
            numero = scanner.nextInt();
            if (numero != -1) {
                numeros.add(numero);
            }
        } while (numero != -1);

        return numeros;
    }

    public static List<Integer> obtenerNumerosPares(List<Integer> numeros) {
        List<Integer> pares = new ArrayList<>();

        for (int numero : numeros) {
            if (numero % 2 == 0) {
                pares.add(numero);
            }
        }

        return pares;
    }

    public static int calcularSumaPrimos(List<Integer> numeros) {
        int sumaPrimos = 0;

        for (int numero : numeros) {
            if (esPrimo(numero)) {
                sumaPrimos += numero;
            }
        }

        return sumaPrimos;
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false; // Los números menores o iguales a 1 no son primos
        }

        // Verificamos si el número es divisible por algún otro número
        // que no sea 1 o él mismo
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Si es divisible, no es primo
            }
        }

        return true; // Si no es divisible por ningún otro número, es primo
    }
}
