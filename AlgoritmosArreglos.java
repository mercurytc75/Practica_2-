import java.util.*;

/**
 * Clase que contiene algoritmos relacionados con manipulación de arreglos.
 * Incluye funciones para contar ocurrencias, reordenar elementos y encontrar colores únicos.
 * 
 * @author Práctica de Algoritmos
 * @version 1.0
 */
public class AlgoritmosArreglos {

    /**
     * Cuenta las ocurrencias de un valor específico en un arreglo de flotantes.
     * 
     * Complejidad temporal: O(n) donde n es la longitud del arreglo
     * Complejidad espacial: O(1)
     * 
     * @param arr el arreglo de flotantes
     * @param x el valor a buscar
     * @return número de ocurrencias del valor x en el arreglo
     */
    public static int contarOcurrencias(float[] arr, float x) {
        if (arr == null) return 0;
        
        int count = 0;
        for (float v : arr) {
            if (Float.compare(v, x) == 0) count++;
        }
        return count;
    }

    /**
     * Reordena chaquiras (cuentas) en parejas por orden 1,2,3,4,5 repetido.
     * Omite colores inexistentes y devuelve un NUEVO arreglo.
     * 
     * Complejidad temporal: O(n + K) donde K=5
     * Complejidad espacial: O(K)
     * 
     * @param colores arreglo de colores (valores 1-5)
     * @return nuevo arreglo con las chaquiras reordenadas en parejas
     */
    public static int[] reordenarChaquirasEnParejas(int[] colores) {
        if (colores == null) return new int[0];
        
        int[] count = new int[6]; // Índices 1-5 para colores 1-5
        for (int c : colores) {
            if (c >= 1 && c <= 5) count[c]++;
        }
        
        List<Integer> resultado = new ArrayList<>(colores.length);
        boolean quedanParejas = true;
        
        while (quedanParejas) {
            quedanParejas = false;
            for (int color = 1; color <= 5; color++) {
                if (count[color] >= 2) {
                    resultado.add(color);
                    resultado.add(color);
                    count[color] -= 2;
                    quedanParejas = true;
                }
            }
        }
        
        // Convertir List<Integer> a int[]
        int[] res = new int[resultado.size()];
        for (int i = 0; i < resultado.size(); i++) {
            res[i] = resultado.get(i);
        }
        return res;
    }

    /**
     * Reordena chaquiras en parejas de forma in-place.
     * Modifica el arreglo original.
     * 
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(1) extra
     * 
     * @param colores arreglo de colores a reordenar (modificado in-place)
     */
    public static void reordenarChaquirasEnParejasInPlace(int[] colores) {
        if (colores == null) return;
        
        int[] count = new int[6];
        for (int c : colores) {
            if (c >= 1 && c <= 5) count[c]++;
        }

        int i = 0;
        boolean quedanParejas = true;
        
        while (quedanParejas && i + 1 < colores.length) {
            quedanParejas = false;
            for (int color = 1; color <= 5 && i + 1 < colores.length; color++) {
                if (count[color] >= 2) {
                    colores[i++] = color;
                    colores[i++] = color;
                    count[color] -= 2;
                    quedanParejas = true;
                }
            }
        }
        
        // Rellenar con ceros si sobran posiciones
        while (i < colores.length) {
            colores[i++] = 0;
        }
    }

    /**
     * Encuentra los colores únicos en una imagen.
     * Mantiene el orden de primera aparición.
     * 
     * Complejidad temporal: O(n) donde n es el número de píxeles
     * Complejidad espacial: O(k) donde k es el número de colores únicos
     * 
     * @param img la imagen a analizar
     * @return arreglo con los colores únicos en orden de aparición
     */
    public static int[] coloresUnicos(ImagenTeaching img) {
        if (img == null) return new int[0];
        
        int[] pixeles = img.getPixeles();
        LinkedHashSet<Integer> coloresUnicos = new LinkedHashSet<>();
        
        for (int pixel : pixeles) {
            coloresUnicos.add(pixel);
        }
        
        int[] resultado = new int[coloresUnicos.size()];
        int i = 0;
        for (int color : coloresUnicos) {
            resultado[i++] = color;
        }
        
        return resultado;
    }

    /**
     * Busca un elemento en un arreglo y devuelve su índice.
     * 
     * @param arr el arreglo donde buscar
     * @param elemento el elemento a buscar
     * @return índice del elemento, o -1 si no se encuentra
     */
    public static int buscarElemento(int[] arr, int elemento) {
        if (arr == null) return -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Encuentra el elemento máximo en un arreglo.
     * 
     * @param arr el arreglo a analizar
     * @return el valor máximo, o Integer.MIN_VALUE si el arreglo está vacío
     */
    public static int encontrarMaximo(int[] arr) {
        if (arr == null || arr.length == 0) return Integer.MIN_VALUE;
        
        int maximo = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maximo) {
                maximo = arr[i];
            }
        }
        return maximo;
    }

    /**
     * Encuentra el elemento mínimo en un arreglo.
     * 
     * @param arr el arreglo a analizar
     * @return el valor mínimo, o Integer.MAX_VALUE si el arreglo está vacío
     */
    public static int encontrarMinimo(int[] arr) {
        if (arr == null || arr.length == 0) return Integer.MAX_VALUE;
        
        int minimo = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minimo) {
                minimo = arr[i];
            }
        }
        return minimo;
    }

    /**
     * Calcula el promedio de los elementos en un arreglo de flotantes.
     * 
     * @param arr el arreglo a analizar
     * @return el promedio de los elementos, o 0.0 si el arreglo está vacío
     */
    public static double calcularPromedio(float[] arr) {
        if (arr == null || arr.length == 0) return 0.0;
        
        double suma = 0.0;
        for (float elemento : arr) {
            suma += elemento;
        }
        return suma / arr.length;
    }
}
