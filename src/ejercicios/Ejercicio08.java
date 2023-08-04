package ejercicios;

import java.util.Scanner;

public class Ejercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un número:");
        int numero = scanner.nextInt();

        if (esPrimo(numero)) {
            System.out.println("El número " + numero + " es primo.");
        } else {
            System.out.println("El número " + numero + " no es primo.");
        }
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
