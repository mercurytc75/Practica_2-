import java.util.*;

/**
 * Clase que maneja el menú interactivo para probar los algoritmos.
 * Proporciona una interfaz de usuario amigable para ejecutar y probar
 * las diferentes funciones algorítmicas.
 * 
 * @author Práctica de Algoritmos
 * @version 1.0
 */
public class MenuInteractivo {
    private final Scanner scanner;

    /**
     * Constructor del menú interactivo.
     */
    public MenuInteractivo() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal y maneja la interacción del usuario.
     */
    public void mostrarMenu() {
        int opcion = -1;
        
        do {
            mostrarOpciones();
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
                procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Por favor ingresa un número entero válido.");
            } catch (Exception e) {
                System.out.println("❌ Error inesperado: " + e.getMessage());
            }
            System.out.println();
        } while (opcion != 0);
    }

    /**
     * Muestra las opciones del menú.
     */
    private void mostrarOpciones() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║           🧮 MENÚ PRINCIPAL          ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 1. 🔢 Contar dígitos pares           ║");
        System.out.println("║ 2. 📝 Verificar palíndromo           ║");
        System.out.println("║ 3. 🔄 Verificar capicúa              ║");
        System.out.println("║ 4. 🔍 Contar ocurrencias en arreglo  ║");
        System.out.println("║ 5. 🎨 Reordenar chaquiras           ║");
        System.out.println("║ 6. 🌈 Colores únicos en imagen       ║");
        System.out.println("║ 7. ➕ Funciones adicionales          ║");
        System.out.println("║ 0. 🚪 Salir                         ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("👉 Elige una opción: ");
    }

    /**
     * Procesa la opción seleccionada por el usuario.
     * 
     * @param opcion la opción seleccionada
     */
    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> probarContarDigitosPares();
            case 2 -> probarPalindromo();
            case 3 -> probarCapicua();
            case 4 -> probarContarOcurrencias();
            case 5 -> probarReordenarChaquiras();
            case 6 -> probarColoresUnicos();
            case 7 -> mostrarFuncionesAdicionales();
            case 0 -> System.out.println("👋 ¡Hasta luego! Gracias por usar el programa.");
            default -> System.out.println("❌ Opción no válida. Por favor selecciona una opción del 0 al 7.");
        }
    }

    /**
     * Prueba la función de contar dígitos pares.
     */
    private void probarContarDigitosPares() {
        System.out.println("\n🔢 CONTAR DÍGITOS PARES");
        System.out.print("Ingresa un número entero: ");
        try {
            long numero = Long.parseLong(scanner.nextLine().trim());
            int digitosPares = AlgoritmosNumericos.contarDigitosPares(numero);
            System.out.println("✅ Resultado: El número " + numero + " tiene " + digitosPares + " dígito(s) par(es)");
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Por favor ingresa un número entero válido.");
        }
    }

    /**
     * Prueba la función de verificar palíndromo.
     */
    private void probarPalindromo() {
        System.out.println("\n📝 VERIFICAR PALÍNDROMO");
        System.out.print("Ingresa una cadena: ");
        String cadena = scanner.nextLine();
        boolean esPalindromo = AlgoritmosCadenas.esPalindromo(cadena);
        System.out.println("✅ Resultado: '" + cadena + "' " + (esPalindromo ? "SÍ" : "NO") + " es palíndromo");
    }

    /**
     * Prueba la función de verificar capicúa.
     */
    private void probarCapicua() {
        System.out.println("\n🔄 VERIFICAR CAPICÚA");
        System.out.print("Ingresa un número entero: ");
        try {
            long numero = Long.parseLong(scanner.nextLine().trim());
            boolean esCapicua = AlgoritmosNumericos.esCapicua(numero);
            System.out.println("✅ Resultado: El número " + numero + " " + (esCapicua ? "SÍ" : "NO") + " es capicúa");
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Por favor ingresa un número entero válido.");
        }
    }

    /**
     * Prueba la función de contar ocurrencias.
     */
    private void probarContarOcurrencias() {
        System.out.println("\n🔍 CONTAR OCURRENCIAS EN ARREGLO");
        System.out.print("¿Cuántos elementos tendrá el arreglo?: ");
        try {
            int tamano = Integer.parseInt(scanner.nextLine().trim());
            if (tamano <= 0) {
                System.out.println("❌ Error: El tamaño debe ser mayor a 0.");
                return;
            }
            
            float[] arreglo = new float[tamano];
            for (int i = 0; i < tamano; i++) {
                System.out.print("Elemento " + (i + 1) + ": ");
                arreglo[i] = Float.parseFloat(scanner.nextLine().trim());
            }
            
            System.out.print("¿Qué número deseas buscar?: ");
            float buscar = Float.parseFloat(scanner.nextLine().trim());
            
            int ocurrencias = AlgoritmosArreglos.contarOcurrencias(arreglo, buscar);
            System.out.println("✅ Resultado: El número " + buscar + " aparece " + ocurrencias + " vez(ces) en el arreglo");
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Por favor ingresa un número válido.");
        }
    }

    /**
     * Prueba la función de reordenar chaquiras.
     */
    private void probarReordenarChaquiras() {
        System.out.println("\n🎨 REORDENAR CHAQUIRAS EN PAREJAS");
        System.out.print("¿Cuántos colores?: ");
        try {
            int tamano = Integer.parseInt(scanner.nextLine().trim());
            if (tamano <= 0) {
                System.out.println("❌ Error: El tamaño debe ser mayor a 0.");
                return;
            }
            
            int[] colores = new int[tamano];
            for (int i = 0; i < tamano; i++) {
                System.out.print("Color " + (i + 1) + " (1-5): ");
                int color = Integer.parseInt(scanner.nextLine().trim());
                if (color < 1 || color > 5) {
                    System.out.println("⚠️ Advertencia: Los colores deben estar entre 1 y 5. Usando 1 por defecto.");
                    color = 1;
                }
                colores[i] = color;
            }
            
            int[] parejas = AlgoritmosArreglos.reordenarChaquirasEnParejas(colores);
            System.out.println("✅ Colores originales: " + Arrays.toString(colores));
            System.out.println("✅ Parejas reordenadas: " + Arrays.toString(parejas));
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Por favor ingresa números enteros válidos.");
        }
    }

    /**
     * Prueba la función de colores únicos en imagen.
     */
    private void probarColoresUnicos() {
        System.out.println("\n🌈 COLORES ÚNICOS EN IMAGEN");
        try {
            System.out.print("Renglones: ");
            int renglones = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Columnas: ");
            int columnas = Integer.parseInt(scanner.nextLine().trim());
            
            if (renglones <= 0 || columnas <= 0) {
                System.out.println("❌ Error: Las dimensiones deben ser mayores a 0.");
                return;
            }
            
            int[] pixeles = new int[renglones * columnas];
            for (int i = 0; i < renglones * columnas; i++) {
                System.out.print("Pixel " + (i + 1) + " (color como entero): ");
                pixeles[i] = Integer.parseInt(scanner.nextLine().trim());
            }
            
            ImagenTeaching imagen = new ImagenTeaching(renglones, columnas, pixeles);
            int[] coloresUnicos = AlgoritmosArreglos.coloresUnicos(imagen);
            
            System.out.println("✅ Imagen creada: " + imagen);
            System.out.println("✅ Colores únicos: " + Arrays.toString(coloresUnicos));
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Por favor ingresa números enteros válidos.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    /**
     * Muestra las funciones adicionales disponibles.
     */
    private void mostrarFuncionesAdicionales() {
        System.out.println("\n➕ FUNCIONES ADICIONALES");
        System.out.println("Estas son algunas funciones adicionales disponibles:");
        System.out.println("• AlgoritmosNumericos.sumarDigitos(n)");
        System.out.println("• AlgoritmosNumericos.contarDigitos(n)");
        System.out.println("• AlgoritmosNumericos.esPrimo(n)");
        System.out.println("• AlgoritmosCadenas.invertirCadena(s)");
        System.out.println("• AlgoritmosCadenas.contarVocales(s)");
        System.out.println("• AlgoritmosCadenas.contarConsonantes(s)");
        System.out.println("• AlgoritmosArreglos.encontrarMaximo(arr)");
        System.out.println("• AlgoritmosArreglos.encontrarMinimo(arr)");
        System.out.println("• AlgoritmosArreglos.calcularPromedio(arr)");
    }

    /**
     * Cierra el scanner al terminar.
     */
    public void cerrar() {
        scanner.close();
    }
}
