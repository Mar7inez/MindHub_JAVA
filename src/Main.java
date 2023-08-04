import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||                                                                                       ||");
            System.out.println("||                   Seleccione el ejercicio que desea ejecutar                          ||");
            System.out.println("||                                                                                       ||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("1. Leer datos personales e imprimir en una oración.");
            System.out.println("2. Encontrar el mayor entre tres números ingresados.");
            System.out.println("3. Identificar la paridad de un número ingresado.");
            System.out.println("4. Comparar dos cadenas de caracteres.");
            System.out.println("5. Almacenar números en una colección hasta ingresar 0.");
            System.out.println("6. Imprimir mensaje de bienvenida en la consola.");
            System.out.println("7. Determinar si un número es par o impar.");
            System.out.println("8. Verificar si un número es primo.");
            System.out.println("9. Calcular la suma de números impares en una colección.");
            System.out.println("10. Imprimir números pares y suma de números primos.");
            System.out.println("11. Mostrar un menú de opciones para una calculadora.");
            System.out.println("12. Crear una calculadora funcional");
            System.out.println("13. Algoritmo para gestionar el ingreso a un boliche.");
            System.out.println("0. Salir");

            System.out.println("-------------------------------------------------------------------");

            System.out.print("Ingrese el número del ejercicio que desea ejecutar: ");
            opcion = scanner.nextInt();


            switch (opcion) {
                case 1:
                    ejercicio1();
                    break;
                case 2:
                    ejercicio02();
                    break;
                case 3:
                    ejercicio03();
                    break;
                case 4:
                    ejercicio04();
                    break;
                case 5:
                    ejercicio05();
                    break;
                case 6:
                    ejercicio06();
                    break;
                case 7:
                    ejercicio07();
                    break;
                case 8:
                    ejercicio08();
                    break;
                case 9:
                    ejercicio09();
                    break;
                case 10:
                    ejercicio10();
                    break;
                case 11:
                    ejercicio11();
                    break;
                case 12:
                    ejercicio12();
                    break;
                case 13:
                    ejercicio13();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }

    //Ejercicios

    // 1
    private static void ejercicio1() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||             1. Leer datos personales e imprimir en una oración.                       ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        System.out.println("Hola, " + nombre + " " + apellido + ". Tienes " + edad + " años.");

        scanner.nextLine(); // Consumir el salto de línea pendiente

    }

    //2
    public static void ejercicio02() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||             2. Encontrar el mayor entre tres números ingresados.                      ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

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

    //3
    public static void ejercicio03() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||             3. Identificar la paridad de un número ingresado.                         ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

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

    //4
    public static void ejercicio04() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||             4. Comparar dos cadenas de caracteres.                                    ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

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

    //5
    public static void ejercicio05() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||             5. Almacenar números en una colección, ingresar 0 para salir.             ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

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

    //06
    public static void ejercicio06() {
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|                                                                                         |");
        System.out.println("|                      ¡Bienvenido al Bootcamp Java de MindHub!                           |");
        System.out.println("|               Estoy seguro que va a ser una gran experiencia experiencia.               |");
        System.out.println("|                                                                                         |");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }

    //07
    public static void ejercicio07() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||             7. Determinar si un número es par o impar.                                ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        String numeroStr = scanner.nextLine();

        int numero = Integer.parseInt(numeroStr);

        String resultado = obtenerParidadTexto(numero);
        System.out.println("El número " + numero + " es " + resultado);


    }

    public static String obtenerParidadTexto(int numero) {
        if (numero % 2 == 0) {
            return "par";
        } else {
            return "impar";
        }
    }

//08

    public static void ejercicio08() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||             8. Verificar si un número es primo.                                       ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

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

    //09
    public static void ejercicio09() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||             9. Calcular la suma de números impares en una colección.                  ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

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

    //10
    public static void ejercicio10() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||            10. Imprimir números pares y suma de números primos.                       ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        List<Integer> numeros = leerNumerosDesdeConsola();
        List<Integer> pares = obtenerNumerosPares(numeros);
        int sumaPrimos = calcularSumaPrimos(numeros);

        System.out.println("Números pares ingresados: " + pares);
        System.out.println("Suma de los números primos: " + sumaPrimos);
    }

    public static List<Integer> leerNumerosDesdeConsole() {
        List<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese números (ingrese -1 para detenerse):");

        int numero;
        do {
            numero = scanner.nextInt();
            if (numero != -1) {
                numeros.add(numero);
            }
        } while (numero != -1);

        return numeros;
    }

    public static List<Integer> obtenerNumerosPares(List<Integer> numeros) {
        List<Integer> pares = new ArrayList<>();

        for (int numero : numeros) {
            if (numero % 2 == 0) {
                pares.add(numero);
            }
        }

        return pares;
    }

    public static int calcularSumaPrimos(List<Integer> numeros) {
        int sumaPrimos = 0;

        for (int numero : numeros) {
            if (esPrimo(numero)) {
                sumaPrimos += numero;
            }
        }

        return sumaPrimos;
    }

    public static boolean esPrim(int numero) {
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

    //11
    public static void ejercicio11() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||            11. Mostrar un menú de opciones para una calculadora.                      ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

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

    //12
    public static void ejercicio12() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||            12. Crear una calculadora funcional                                        ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

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

    //13
    private static void ejercicio13() {

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                                                       ||");
        System.out.println("||            13. Algoritmo para gestionar el ingreso a un boliche.                      ||");
        System.out.println("||                                                                                       ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

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
