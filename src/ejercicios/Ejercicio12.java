package ejercicios;

import java.util.Scanner;

public class Ejercicio12 {
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
                    realizarSuma();
                    break;
                case 2:
                    realizarResta();
                    break;
                case 3:
                    realizarMultiplicacion();
                    break;
                case 4:
                    realizarDivision();
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

    public static void realizarSuma() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer número:");
        double numero1 = scanner.nextDouble();

        System.out.println("Ingrese el segundo número:");
        double numero2 = scanner.nextDouble();

        double resultado = numero1 + numero2;
        System.out.println("Resultado: " + resultado);
    }

    public static void realizarResta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer número:");
        double numero1 = scanner.nextDouble();

        System.out.println("Ingrese el segundo número:");
        double numero2 = scanner.nextDouble();

        double resultado = numero1 - numero2;
        System.out.println("Resultado: " + resultado);
    }

    public static void realizarMultiplicacion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer número:");
        double numero1 = scanner.nextDouble();

        System.out.println("Ingrese el segundo número:");
        double numero2 = scanner.nextDouble();

        double resultado = numero1 * numero2;
        System.out.println("Resultado: " + resultado);
    }

    public static void realizarDivision() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el dividendo:");
        double dividendo = scanner.nextDouble();

        System.out.println("Ingrese el divisor:");
        double divisor = scanner.nextDouble();

        if (divisor != 0) {
            double resultado = dividendo / divisor;
            System.out.println("Resultado: " + resultado);
        } else {
            System.out.println("Error: No se puede dividir por cero.");
        }
    }
}
