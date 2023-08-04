package ejercicios;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("---- Calculadora Básica ----");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Suma");
                    break;
                case 2:
                    System.out.println("Resta");
                    break;
                case 3:
                    System.out.println("Multiplicación");
                    break;
                case 4:
                    System.out.println("División");
                    break;
                case 0:
                    System.out.println("Saliendo de la calculadora MindHub. ¡Saludines terricola!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }

            System.out.println();
        } while (opcion != 0);
    }


}
