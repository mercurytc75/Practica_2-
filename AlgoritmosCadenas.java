/**
 * Clase que contiene algoritmos relacionados con manipulación de cadenas.
 * Incluye funciones para verificar palíndromos y otras operaciones de texto.
 * 
 * @author Práctica de Algoritmos
 * @version 1.0
 */
public class AlgoritmosCadenas {

    /**
     * Verifica si una cadena es palíndromo.
     * Un palíndromo es una palabra o frase que se lee igual de izquierda a derecha.
     * 
     * Complejidad temporal: O(n) donde n es la longitud de la cadena
     * Complejidad espacial: O(1)
     * 
     * @param s la cadena a verificar
     * @return true si es palíndromo, false en caso contrario
     */
    public static boolean esPalindromo(String s) {
        if (s == null) return false;
        
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            
            if (ci != cj) return false;
            i++; 
            j--;
        }
        return true;
    }

    /**
     * Verifica si una cadena es palíndromo ignorando espacios y diferencias de mayúsculas.
     * 
     * @param s la cadena a verificar
     * @return true si es palíndromo (ignorando espacios y mayúsculas), false en caso contrario
     */
    public static boolean esPalindromoIgnorandoEspacios(String s) {
        if (s == null) return false;
        
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ci = Character.toLowerCase(s.charAt(i));
            char cj = Character.toLowerCase(s.charAt(j));
            
            // Saltar espacios
            while (i < j && Character.isWhitespace(ci)) {
                i++;
                ci = Character.toLowerCase(s.charAt(i));
            }
            while (i < j && Character.isWhitespace(cj)) {
                j--;
                cj = Character.toLowerCase(s.charAt(j));
            }
            
            if (ci != cj) return false;
            i++; 
            j--;
        }
        return true;
    }

    /**
     * Invierte una cadena.
     * 
     * @param s la cadena a invertir
     * @return la cadena invertida
     */
    public static String invertirCadena(String s) {
        if (s == null) return null;
        
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * Cuenta el número de vocales en una cadena.
     * 
     * @param s la cadena a analizar
     * @return número de vocales (a, e, i, o, u) en la cadena
     */
    public static int contarVocales(String s) {
        if (s == null) return 0;
        
        int count = 0;
        String vocales = "aeiouAEIOU";
        
        for (char c : s.toCharArray()) {
            if (vocales.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta el número de consonantes en una cadena.
     * 
     * @param s la cadena a analizar
     * @return número de consonantes en la cadena
     */
    public static int contarConsonantes(String s) {
        if (s == null) return 0;
        
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) && !esVocal(c)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Verifica si un carácter es vocal.
     * 
     * @param c el carácter a verificar
     * @return true si es vocal, false en caso contrario
     */
    private static boolean esVocal(char c) {
        char lower = Character.toLowerCase(c);
        return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
    }

    /**
     * Elimina todos los espacios de una cadena.
     * 
     * @param s la cadena original
     * @return la cadena sin espacios
     */
    public static String eliminarEspacios(String s) {
        if (s == null) return null;
        
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
