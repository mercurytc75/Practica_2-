// Archivo: AlgorithmsPracticeTeaching.java
import java.util.*;

class ImagenTeaching {
    private final int renglones;    // filas
    private final int columnas;     // columnas
    private final int[] pixeles;    // colores RGB normalizados (#000000..#FFFFFF en int)

    public ImagenTeaching(int renglones, int columnas, int[] pixeles) {
        if (renglones * columnas != pixeles.length) {
            throw new IllegalArgumentException("pixeles no coincide con renglones*columnas");
        }
        this.renglones = renglones;
        this.columnas = columnas;
        this.pixeles = pixeles;
    }

    public int getRenglones() { return renglones; }
    public int getColumnas()  { return columnas;  }
    public int[] getPixeles() { return pixeles;   }
}

public class AlgorithmsPracticeTeaching {

    /* (a) Contar dígitos pares de un entero.
     * T: O(d) donde d = # de dígitos | S: O(1)
     */
    public static int contarDigitosParesTeaching(long n) {
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

    /* (b) Palíndromo para cadena (ignora espacios y mayúsculas opcionalmente).
     * T: O(n) | S: O(1)
     */
    public static boolean esPalindromoTeaching(String s) {
        if (s == null) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            // Si quieres ignorar espacios, descomenta:
            // while (i < j && Character.isWhitespace(ci)) { i++; ci = s.charAt(i); }
            // while (i < j && Character.isWhitespace(cj)) { j--; cj = s.charAt(j); }
            if (ci != cj) return false;
            i++; j--;
        }
        return true;
    }

    /* (c) Número capicúa.
     * T: O(d) | S: O(1)
     */
    public static boolean esCapicuaTeaching(long n) {
        if (n < 0) return false; // por convención
        long original = n, rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev == original;
    }

    /* (d) Contar ocurrencias de un flotante X en un arreglo.
     * Nota: para floats dobles exactos; si quieres tolerancia, usa un epsilon.
     * T: O(n) | S: O(1)
     */
    public static int contarOcurrenciasTeaching(float[] arr, float x) {
        int c = 0;
        for (float v : arr) if (Float.compare(v, x) == 0) c++;
        return c;
    }

    /* (e) Chaquiras: reordenar en parejas por orden 1,2,3,4,5 repetido,
     * omitiendo colores inexistentes. Devuelve NUEVO arreglo.
     * T: O(n + K) con K=5 | S: O(K)
     */
    public static int[] reordenarChaquirasEnParejasTeaching(int[] colores) {
        int[] count = new int[6]; // 1..5
        for (int c : colores) {
            if (c >= 1 && c <= 5) count[c]++;
        }
        List<Integer> out = new ArrayList<>(colores.length);
        boolean queda = true;
        while (queda) {
            queda = false;
            for (int color = 1; color <= 5; color++) {
                if (count[color] >= 2) {
                    out.add(color);
                    out.add(color);
                    count[color] -= 2;
                    queda = true;
                }
            }
        }
        // Convertir a int[]
        int[] res = new int[out.size()];
        for (int i = 0; i < out.size(); i++) res[i] = out.get(i);
        return res;
    }

    /* Variante (e) in-place.
     * T: O(n) | S: O(1) extra
     */
    public static void reordenarChaquirasEnParejasInPlaceTeaching(int[] colores) {
        int[] count = new int[6];
        for (int c : colores) if (c >= 1 && c <= 5) count[c]++;  // FIX: aquí estaba el bug

        int i = 0;
        boolean queda = true;
        while (queda && i + 1 < colores.length) {
            queda = false;
            for (int color = 1; color <= 5 && i + 1 < colores.length; color++) {
                if (count[color] >= 2) {
                    colores[i++] = color;
                    colores[i++] = color;
                    count[color] -= 2;
                    queda = true;
                }
            }
        }
        // Rellenar con ceros si sobran posiciones
        while (i < colores.length) {
            colores[i++] = 0;
        }
    }

    /* (f) Colores únicos en la imagen.
     * Mantiene el orden de primera aparición.
     * T: O(n) | S: O(k) donde k = # colores únicos
     */
    public static int[] coloresUnicosTeaching(ImagenTeaching img) {
        int[] px = img.getPixeles();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int p : px) set.add(p);
        int[] out = new int[set.size()];
        int i = 0;
        for (int v : set) out[i++] = v;
        return out;
    }

    // -------------------------------------------------------------
    // Menú interactivo para pruebas
    static void Menu(){
        Scanner scanner = new Scanner(System.in);
        int opcion=-1;
        
          do {
            System.out.println("=== MENÚ ===");
            System.out.println("1. Contar dígitos pares");
            System.out.println("2. Verificar palíndromo");
            System.out.println("3. Verificar capicúa");
            System.out.println("4. Contar ocurrencias en arreglo de floats");
            System.out.println("5. Reordenar chaquiras en parejas");
            System.out.println("6. Colores únicos en imagen");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce un número entero: ");
                    long n = scanner.nextLong();
                    scanner.nextLine(); // limpiar buffer
                    System.out.println("Dígitos pares: " + contarDigitosParesTeaching(n));
                }
                case 2 -> {
                    System.out.print("Introduce una cadena: ");
                    String s2 = scanner.nextLine();
                    if (s2.isEmpty()) s2 = scanner.nextLine();
                    System.out.println("¿Es palíndromo? " + esPalindromoTeaching(s2));
                }
                case 3 -> {
                    System.out.print("Introduce un número entero: ");
                    long num = scanner.nextLong();
                    System.out.println("¿Es capicúa? " + esCapicuaTeaching(num));
                }
                case 4 -> {
                    System.out.print("¿Cuántos elementos tendrá el arreglo?: ");
                    int tam = scanner.nextInt();
                    float[] arr = new float[tam];
                    for (int i = 0; i < tam; i++) {
                        System.out.print("Elemento " + (i+1) + ": ");
                        arr[i] = scanner.nextFloat();
                    }
                    System.out.print("¿Qué número deseas buscar?: ");
                    float x = scanner.nextFloat();
                    System.out.println("Ocurrencias: " + contarOcurrenciasTeaching(arr, x));
                }
                case 5 -> {
                    System.out.print("¿Cuántos colores?: ");
                    int t = scanner.nextInt();
                    int[] colores = new int[t];
                    for (int i = 0; i < t; i++) {
                        System.out.print("Color " + (i+1) + ": ");
                        colores[i] = scanner.nextInt();
                    }
                    int[] parejas = reordenarChaquirasEnParejasTeaching(colores);
                    System.out.println("Parejas: " + Arrays.toString(parejas));
                }
                case 6 -> {
                    System.out.print("Renglones: ");
                    int r = scanner.nextInt();
                    System.out.print("Columnas: ");
                    int c = scanner.nextInt();
                    int[] pixeles = new int[r * c];
                    for (int i = 0; i < r * c; i++) {
                        System.out.print("Pixel " + (i+1) + " (int): ");
                        pixeles[i] = scanner.nextInt();
                    }
                    ImagenTeaching img = new ImagenTeaching(r, c, pixeles);
                    System.out.println("Colores únicos: " + Arrays.toString(coloresUnicosTeaching(img)));
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida.");
            } 
            } catch (Exception e) {
                System.out.println("ingresa un valor entero. ");
                scanner.nextLine();
            }
            System.out.println();
        } while (opcion != 0);
        scanner.close();  
                
    }

    /*-------------------------------------------------------------*/
    public static void main(String[] args) {
        Menu();
    }
}
