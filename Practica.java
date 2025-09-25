

import java.util.*;

class Imagen {
    private int renglones;
    private int columnas;
    private int[] pixeles;

    public Imagen(int renglones, int columnas, int[] pixeles) {
        this.renglones = renglones;
        this.columnas = columnas;
        this.pixeles = pixeles;
    }

    public int[] getPixeles() {
        return pixeles;
    }
}

public class Practica {

    // Métodos de la práctica (igual que antes)
    public static int contarDigitosPares(int numero) {
        int count = 0;
        numero = Math.abs(numero);
        while (numero > 0) {
            int digito = numero % 10;
            if (digito % 2 == 0) count++;
            numero /= 10;
        }
        return count;
    }

    public static boolean esPalindromo(String cadena) {
        cadena = cadena.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = cadena.length() - 1;
        while (i < j) {
            if (cadena.charAt(i) != cadena.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean esCapicua(int numero) {
        String numStr = String.valueOf(Math.abs(numero));
        return esPalindromo(numStr);
    }

    public static int contarOcurrencias(float[] arreglo, float x) {
        int count = 0;
        for (float valor : arreglo) {
            if (valor == x) count++;
        }
        return count;
    }

    public static int[] organizarChaquiras(int[] arreglo) {
        Map<Integer, Integer> conteo = new HashMap<>();
        for (int color : arreglo) {
            conteo.put(color, conteo.getOrDefault(color, 0) + 1);
        }

        List<Integer> resultado = new ArrayList<>();
        int[] orden = {1, 2, 3, 4, 5};

        boolean quedan = true;
        while (quedan) {
            quedan = false;
            for (int color : orden) {
                if (conteo.getOrDefault(color, 0) >= 2) {
                    resultado.add(color);
                    resultado.add(color);
                    conteo.put(color, conteo.get(color) - 2);
                    quedan = true;
                }
            }
        }
        return resultado.stream().mapToInt(i -> i).toArray();
    }

    public static int[] coloresUnicos(Imagen img) {
        Set<Integer> colores = new HashSet<>();
        for (int pixel : img.getPixeles()) {
            colores.add(pixel);
        }
        return colores.stream().mapToInt(i -> i).toArray();
    }

    // ------------------------- MAIN CON MENÚ Y TRY-CATCH -------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            try {
                System.out.println("\n===== MENÚ INTERACTIVO =====");
                System.out.println("1. Contar dígitos pares en un número");
                System.out.println("2. Verificar si una cadena es palíndromo");
                System.out.println("3. Verificar si un número es capicúa");
                System.out.println("4. Contar ocurrencias de un flotante en un arreglo");
                System.out.println("5. Organizar chaquiras");
                System.out.println("6. Obtener colores únicos de una imagen");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");

                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa un número entero: ");
                        int num = sc.nextInt();
                        System.out.println("Cantidad de dígitos pares: " + contarDigitosPares(num));
                        break;

                    case 2:
                        System.out.print("Ingresa una cadena: ");
                        String cadena = sc.nextLine();
                        System.out.println("¿Es palíndromo? " + esPalindromo(cadena));
                        break;

                    case 3:
                        System.out.print("Ingresa un número entero: ");
                        int capicua = sc.nextInt();
                        System.out.println("¿Es capicúa? " + esCapicua(capicua));
                        break;

                    case 4:
                        System.out.print("Tamaño del arreglo: ");
                        int n = sc.nextInt();
                        float[] arr = new float[n];
                        for (int i = 0; i < n; i++) {
                            System.out.print("Valor " + (i + 1) + ": ");
                            arr[i] = sc.nextFloat();
                        }
                        System.out.print("Número a buscar: ");
                        float x = sc.nextFloat();
                        System.out.println("Ocurrencias de " + x + ": " + contarOcurrencias(arr, x));
                        break;

                    case 5:
                        System.out.print("Tamaño del arreglo de chaquiras: ");
                        int m = sc.nextInt();
                        int[] chaquiras = new int[m];
                        for (int i = 0; i < m; i++) {
                            System.out.print("Color " + (i + 1) + " (1=Verde,2=Rojo,3=Amarillo,4=Azul,5=Blanco): ");
                            chaquiras[i] = sc.nextInt();
                        }
                        System.out.println("Chaquiras organizadas: " + Arrays.toString(organizarChaquiras(chaquiras)));
                        break;

                    case 6:
                        System.out.print("Número de pixeles de la imagen: ");
                        int p = sc.nextInt();
                        int[] pixeles = new int[p];
                        for (int i = 0; i < p; i++) {
                            System.out.print("Color del pixel " + (i + 1) + " (en entero RGB): ");
                            pixeles[i] = sc.nextInt();
                        }
                        Imagen img = new Imagen(1, p, pixeles);
                        System.out.println("Colores únicos: " + Arrays.toString(coloresUnicos(img)));
                        break;

                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("⚠️ Opción no válida. Intenta de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Ingresa un valor válido (números enteros o decimales según corresponda).");
                sc.nextLine(); // limpiar el buffer para que no quede en bucle
            } catch (Exception e) {
                System.out.println("❌ Ocurrió un error inesperado: " + e.getMessage());
            }

        } while (opcion != 0);

        sc.close();
    }
}
