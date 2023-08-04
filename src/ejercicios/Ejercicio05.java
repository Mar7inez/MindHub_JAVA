package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio05
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("Ingrese números (ingrese 0 para detenerse):");

        int numero;
        do {
            numero = scanner.nextInt();
            if (numero != 0) {
                numeros.add(numero);
            }
        } while (numero != 0);

        System.out.println("Números ingresados: " + numeros);
    }
}
