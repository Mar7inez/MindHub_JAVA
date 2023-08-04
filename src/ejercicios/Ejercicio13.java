package ejercicios;

import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacidadMaxima = 500;
        int capacidadDisponible = capacidadMaxima;
        int dineroRecaudado = 0;
        int valorEntradaNormal = 2500;
        int valorEntradaVIP = 5000;

        int opcion;
        do {
            System.out.println("---- Boliche MindHub AP ----");
            System.out.println("1. Ingreso de datos.");
            System.out.println("2. Capacidad disponible.");
            System.out.println("3. Dinero recaudado.");
            System.out.println("4. Salir del sistema.");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (capacidadDisponible > 0) {
                        dineroRecaudado += ingresarDatos(scanner, capacidadDisponible, valorEntradaNormal, valorEntradaVIP);
                        capacidadDisponible--;
                    } else {
                        System.out.println("Lo sentimos, el boliche está lleno.");
                    }
                    break;
                case 2:
                    System.out.println("Capacidad disponible: " + capacidadDisponible + " personas");
                    break;
                case 3:
                    System.out.println("Dinero recaudado: $" + dineroRecaudado);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }

            System.out.println();
        } while (opcion != 4);
    }

    public static int ingresarDatos(Scanner scanner, int capacidadDisponible, int valorEntradaNormal, int valorEntradaVIP) {
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.next();

        System.out.println("Ingrese su edad:");
        int edad = scanner.nextInt();

        if (edad >= 21) {
            System.out.println("Ingrese su DNI:");
            int dni = scanner.nextInt();

            System.out.println("Tiene pase VIP? (S/N):");
            String tienePaseVIP = scanner.next();

            if (tienePaseVIP.equalsIgnoreCase("S")) {
                System.out.println("Bienvenido, " + nombre + "! Puede ingresar al boliche VIP de forma gratuita.");
                return 0; // Pase VIP, no se recauda dinero
            } else {
                System.out.println("Tiene pase con descuento? (S/N):");
                String tienePaseDescuento = scanner.next();

                if (tienePaseDescuento.equalsIgnoreCase("S")) {
                    System.out.println("Elija el tipo de entrada (1 para normal, 2 para VIP):");
                    int tipoEntrada = scanner.nextInt();

                    if (tipoEntrada == 1) {
                        System.out.println("Bienvenido, " + nombre + "! Ha adquirido una entrada normal con descuento.");
                        return valorEntradaNormal / 2;
                    } else if (tipoEntrada == 2) {
                        System.out.println("Bienvenido, " + nombre + "! Ha adquirido una entrada VIP con descuento.");
                        return valorEntradaVIP / 2;
                    } else {
                        System.out.println("Opción no válida. No se ha realizado el cobro.");
                        return 0;
                    }
                } else {
                    System.out.println("Elija el tipo de entrada (1 para normal, 2 para VIP):");
                    int tipoEntrada = scanner.nextInt();

                    if (tipoEntrada == 1) {
                        System.out.println("Bienvenido, " + nombre + "! Ha adquirido una entrada normal.");
                        return valorEntradaNormal;
                    } else if (tipoEntrada == 2) {
                        System.out.println("Bienvenido, " + nombre + "! Ha adquirido una entrada VIP.");
                        return valorEntradaVIP;
                    } else {
                        System.out.println("Opción no válida. No se ha realizado el cobro.");
                        return 0;
                    }
                }
            }
        } else {
            System.out.println("Lo sentimos, solo pueden ingresar mayores de 21 años.");
            return 0; // No se recauda dinero si no cumple con la edad mínima
        }
    }
}