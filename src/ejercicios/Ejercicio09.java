package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
        List<Integer> numeros = leerNumerosDesdeConsola();
        List<Integer> impares = obtenerNumerosImpares(numeros);
        int sumaImpares = sumarNumeros(impares);

        System.out.println("Los números impares ingresados son: " + impares);
        System.out.println("La suma de los números impares es: " + sumaImpares);
    }

    public static List<Integer> leerNumerosDesdeConsola() {
        List<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese números (ingrese 0 para detenerse):");

        int numero;
        do {
            numero = scanner.nextInt();
            if (numero != 0) {
                numeros.add(numero);
            }
        } while (numero != 0);

        return numeros;
    }

    public static List<Integer> obtenerNumerosImpares(List<Integer> numeros) {
        List<Integer> impares = new ArrayList<>();

        for (int numero : numeros) {
            if (numero % 2 != 0) {
                impares.add(numero);
            }
        }

        return impares;
    }

    public static int sumarNumeros(List<Integer> numeros) {
        int suma = 0;

        for (int numero : numeros) {
            suma += numero;
        }

        return suma;
    }
}

