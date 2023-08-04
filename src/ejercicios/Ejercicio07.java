package ejercicios;

public class Ejercicio07 {
    public static void main(String[] args) {
        int numero = 17; // Puedes cambiar este número para probar la función
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
}
