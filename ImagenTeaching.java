/**
 * Clase que representa una imagen con píxeles RGB.
 * Cada píxel es un entero que representa un color en formato RGB.
 * 
 * @author Práctica de Algoritmos
 * @version 1.0
 */
public class ImagenTeaching {
    private final int renglones;    // filas de la imagen
    private final int columnas;     // columnas de la imagen
    private final int[] pixeles;    // colores RGB normalizados (#000000..#FFFFFF en int)

    /**
     * Constructor de la clase ImagenTeaching.
     * 
     * @param renglones número de filas de la imagen
     * @param columnas número de columnas de la imagen
     * @param pixeles arreglo de píxeles donde cada elemento representa un color RGB
     * @throws IllegalArgumentException si el número de píxeles no coincide con renglones*columnas
     */
    public ImagenTeaching(int renglones, int columnas, int[] pixeles) {
        if (renglones <= 0 || columnas <= 0) {
            throw new IllegalArgumentException("Las dimensiones deben ser positivas");
        }
        if (pixeles == null) {
            throw new IllegalArgumentException("El arreglo de píxeles no puede ser null");
        }
        if (renglones * columnas != pixeles.length) {
            throw new IllegalArgumentException("El número de píxeles (" + pixeles.length + 
                                             ") no coincide con renglones*columnas (" + 
                                             renglones * columnas + ")");
        }
        this.renglones = renglones;
        this.columnas = columnas;
        this.pixeles = pixeles.clone(); // Crear copia para inmutabilidad
    }

    /**
     * Obtiene el número de renglones (filas) de la imagen.
     * 
     * @return número de renglones
     */
    public int getRenglones() { 
        return renglones; 
    }

    /**
     * Obtiene el número de columnas de la imagen.
     * 
     * @return número de columnas
     */
    public int getColumnas() { 
        return columnas; 
    }

    /**
     * Obtiene una copia del arreglo de píxeles.
     * 
     * @return copia del arreglo de píxeles
     */
    public int[] getPixeles() { 
        return pixeles.clone(); 
    }

    /**
     * Obtiene el píxel en una posición específica.
     * 
     * @param fila índice de la fila (0-based)
     * @param columna índice de la columna (0-based)
     * @return valor del píxel en la posición especificada
     * @throws IllegalArgumentException si los índices están fuera de rango
     */
    public int getPixel(int fila, int columna) {
        if (fila < 0 || fila >= renglones || columna < 0 || columna >= columnas) {
            throw new IllegalArgumentException("Índices fuera de rango: (" + fila + ", " + columna + ")");
        }
        return pixeles[fila * columnas + columna];
    }

    /**
     * Obtiene el número total de píxeles en la imagen.
     * 
     * @return número total de píxeles
     */
    public int getTotalPixeles() {
        return pixeles.length;
    }

    /**
     * Representación en cadena de la imagen.
     * 
     * @return cadena que describe la imagen
     */
    @Override
    public String toString() {
        return String.format("ImagenTeaching[%dx%d, %d píxeles]", 
                           renglones, columnas, pixeles.length);
    }
}
