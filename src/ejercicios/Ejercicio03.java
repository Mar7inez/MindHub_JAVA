package ejercicios;
import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un número:");
        int numero = scanner.nextInt();

        if (esPar(numero)) {
            System.out.println("El número ingresado es PAR.");
        } else {
            System.out.println("El número ingresado es IMPAR.");
        }
    }

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }
}
