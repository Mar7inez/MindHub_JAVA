package ejercicios;

import java.util.Scanner;

public class Ejercicio01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        System.out.println("Hola, " + nombre + " " + apellido + ". Tienes " + edad + " años.");

        scanner.close();
    }


    public static void main() {
        main();
    }
}
