package ejercicios;

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer número:");
        int numero1 = scanner.nextInt();

        System.out.println("Ingrese el segundo número:");
        int numero2 = scanner.nextInt();

        System.out.println("Ingrese el tercer número:");
        int numero3 = scanner.nextInt();

        int mayor = encontrarMayor(numero1, numero2, numero3);

        System.out.println("El número mayor es: " + mayor);
    }

    public static int encontrarMayor(int a, int b, int c) {
        int mayor = a;
        if (b > mayor) {
            mayor = b;
        }
        if (c > mayor) {
            mayor = c;
        }
        return mayor;
    }
}
