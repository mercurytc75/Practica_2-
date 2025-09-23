// Archivo: Practica2MenuTeaching.java
import java.util.*;

class ImagenTeaching {
    private final int renglones;    
    private final int columnas;     
    private final int[] pixeles;    

    public ImagenTeaching(int renglones, int columnas, int[] pixeles) {
        if (renglones * columnas != pixeles.length) {
            throw new IllegalArgumentException("Pixeles no coincide con renglones*columnas");
        }
        this.renglones = renglones;
        this.columnas = columnas;
        this.pixeles = pixeles;
    }

    public int[] getPixeles() { return pixeles; }
}

public class Practica2MenuTeaching {

    // (a) Contar dígitos pares
    public static int contarDigitosPares(int n) {
        int count = 0;
        n = Math.abs(n);
        while (n > 0) {
            int dig = n % 10;
            if (dig % 2 == 0) count++;
            n /= 10;
        }
        return count;
    }

    // (b) Palíndromo
    public static boolean esPalindromo(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    // (c) Capicúa
    public static boolean esCapicua(int n) {
        String s = String.valueOf(Math.abs(n));
        return esPalindromo(s);
    }

    // (d) Ocurrencias flotante
    public static int contarOcurrencias(float[] arr, float x) {
        int count = 0;
        for (float v : arr) if (v == x) count++;
        return count;
    }

    // (e) Organizar chaquiras
    public static int[] organizarChaquiras(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int c : arr) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        int[] orden = {1,2,3,4,5};
        boolean done = false;
        while (!done) {
            done = true;
            for (int color : orden) {
                if (freq.getOrDefault(color,0) >= 2) {
                    result.add(color);
                    result.add(color);
                    freq.put(color, freq.get(color)-2);
                    done = false;
                }
            }
        }
        for (int color : orden) {
            while (freq.getOrDefault(color,0) > 0) {
                result.add(color);
                freq.put(color, freq.get(color)-1);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    // (f) Colores únicos de imagen
    public static int[] coloresUnicos(ImagenTeaching img) {
        Set<Integer> set = new HashSet<>();
        for (int p : img.getPixeles()) set.add(p);
        return set.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENU PRACTICA 2 ===");
            System.out.println("1. Contar dígitos pares (a)");
            System.out.println("2. Verificar palíndromo (b)");
            System.out.println("3. Verificar número capicúa (c)");
            System.out.println("4. Contar ocurrencias flotante (d)");
            System.out.println("5. Organizar chaquiras (e)");
            System.out.println("6. Colores únicos de imagen (f)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch(opcion) {
                case 1:
                    System.out.print("Ingresa un número entero: ");
                    int n = sc.nextInt();
                    System.out.println("Dígitos pares: " + contarDigitosPares(n));
                    break;

                case 2:
                    System.out.print("Ingresa una cadena: ");
                    String cadena = sc.nextLine();
                    System.out.println("¿Es palíndromo?: " + esPalindromo(cadena));
                    break;

                case 3:
                    System.out.print("Ingresa un número entero: ");
                    int num = sc.nextInt();
                    System.out.println("¿Es capicúa?: " + esCapicua(num));
                    break;

                case 4:
                    System.out.print("Tamaño del arreglo: ");
                    int t = sc.nextInt();
                    float[] arr = new float[t];
                    for (int i = 0; i < t; i++) {
                        System.out.print("Elemento " + (i+1) + ": ");
                        arr[i] = sc.nextFloat();
                    }
                    System.out.print("Número a buscar: ");
                    float x = sc.nextFloat();
                    System.out.println("Ocurrencias: " + contarOcurrencias(arr, x));
                    break;

                case 5:
                    System.out.print("Tamaño del arreglo de chaquiras: ");
                    int m = sc.nextInt();
                    int[] chaquiras = new int[m];
                    for (int i = 0; i < m; i++) {
                        System.out.print("Color[" + (i+1) + "]: ");
                        chaquiras[i] = sc.nextInt();
                    }
                    int[] res = organizarChaquiras(chaquiras);
                    System.out.println("Chaquiras organizadas: " + Arrays.toString(res));
                    break;

                case 6:
                    System.out.print("Número de pixeles: ");
                    int p = sc.nextInt();
                    int[] pixeles = new int[p];
                    for (int i = 0; i < p; i++) {
                        System.out.print("Pixel[" + (i+1) + "] (int RGB): ");
                        pixeles[i] = sc.nextInt();
                    }
                    ImagenTeaching img = new ImagenTeaching(1, p, pixeles);
                    int[] colores = coloresUnicos(img);
                    System.out.println("Colores únicos: " + Arrays.toString(colores));
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while(opcion != 0);

        sc.close();
    }
}
