/**
 * Clase que contiene algoritmos relacionados con operaciones numéricas.
 * Incluye funciones para contar dígitos pares y verificar números capicúa.
 * 
 * @author Práctica de Algoritmos
 * @version 1.0
 */
public class AlgoritmosNumericos {

    /**
     * Cuenta los dígitos pares de un número entero.
     * 
     * Complejidad temporal: O(d) donde d es el número de dígitos
     * Complejidad espacial: O(1)
     * 
     * @param n el número entero a analizar
     * @return número de dígitos pares en el número
     */
    public static int contarDigitosPares(long n) {
        n = Math.abs(n);
        if (n == 0) return 1; // 0 tiene un dígito y es par
        
        int count = 0;
        while (n > 0) {
            long dig = n % 10;
            if ((dig % 2) == 0) count++;
            n /= 10;
        }
        return count;
    }

    /**
     * Verifica si un número es capicúa (palíndromo numérico).
     * Un número capicúa es aquel que se lee igual de izquierda a derecha.
     * 
     * Complejidad temporal: O(d) donde d es el número de dígitos
     * Complejidad espacial: O(1)
     * 
     * @param n el número a verificar
     * @return true si el número es capicúa, false en caso contrario
     */
    public static boolean esCapicua(long n) {
        if (n < 0) return false; // Por convención, los números negativos no son capicúa
        
        long original = n;
        long reverso = 0;
        
        while (n > 0) {
            reverso = reverso * 10 + (n % 10);
            n /= 10;
        }
        
        return reverso == original;
    }

    /**
     * Obtiene la suma de los dígitos de un número.
     * 
     * @param n el número entero
     * @return suma de todos los dígitos
     */
    public static int sumarDigitos(long n) {
        n = Math.abs(n);
        int suma = 0;
        while (n > 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }

    /**
     * Cuenta el número total de dígitos en un número.
     * 
     * @param n el número entero
     * @return número total de dígitos
     */
    public static int contarDigitos(long n) {
        if (n == 0) return 1;
        n = Math.abs(n);
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    /**
     * Verifica si un número es primo.
     * 
     * @param n el número a verificar
     * @return true si es primo, false en caso contrario
     */
    public static boolean esPrimo(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
