package ejercicios;

import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la primera cadena:");
        String cadena1 = scanner.nextLine();

        System.out.println("Ingrese la segunda cadena:");
        String cadena2 = scanner.nextLine();

        if (sonCadenasIguales(cadena1, cadena2)) {
            System.out.println("Las cadenas ingresadas son iguales.");
        } else {
            System.out.println("Las cadenas ingresadas son diferentes.");
        }
    }

    public static boolean sonCadenasIguales(String cadena1, String cadena2) {
        return cadena1.equals(cadena2);
    }
}
