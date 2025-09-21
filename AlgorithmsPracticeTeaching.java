/**
 * Clase principal del programa de práctica de algoritmos.
 * 
 * Este programa demuestra la implementación de varios algoritmos fundamentales
 * organizados en clases especializadas para diferentes tipos de operaciones:
 * - AlgoritmosNumericos: operaciones con números
 * - AlgoritmosCadenas: manipulación de cadenas de texto
 * - AlgoritmosArreglos: operaciones con arreglos y colecciones
 * - ImagenTeaching: representación de imágenes con píxeles
 * - MenuInteractivo: interfaz de usuario para probar los algoritmos
 * 
 * @author Práctica de Algoritmos
 * @version 2.0
 * @since 1.0
 */
public class AlgorithmsPracticeTeaching {

    /**
     * Método principal que inicia el programa.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                              ║");
        System.out.println("║        🧮 PRÁCTICA DE ALGORITMOS - VERSIÓN 2.0             ║");
        System.out.println("║                                                              ║");
        System.out.println("║  Bienvenido al programa de práctica de algoritmos           ║");
        System.out.println("║  Aquí podrás probar diferentes algoritmos de forma          ║");
        System.out.println("║  interactiva y aprender sobre su complejidad.               ║");
        System.out.println("║                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();

        MenuInteractivo menu = new MenuInteractivo();
        
        try {
            menu.mostrarMenu();
        } catch (Exception e) {
            System.err.println("❌ Error crítico: " + e.getMessage());
            System.err.println("Detalles: " + e.getClass().getSimpleName());
        } finally {
            menu.cerrar();
        }
        
        System.out.println("👋 Programa terminado exitosamente.");
    }

    /**
     * Método para mostrar información sobre las clases del programa.
     */
    public static void mostrarInformacion() {
        System.out.println("\n📚 INFORMACIÓN DEL PROGRAMA:");
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.println("│ Clase                    │ Propósito    │");
        System.out.println("├─────────────────────────────────────────┤");
        System.out.println("│ AlgoritmosNumericos      │ Números      │");
        System.out.println("│ AlgoritmosCadenas        │ Cadenas      │");
        System.out.println("│ AlgoritmosArreglos       │ Arreglos     │");
        System.out.println("│ ImagenTeaching           │ Imágenes     │");
        System.out.println("│ MenuInteractivo          │ Interfaz     │");
        System.out.println("│ AlgorithmsPracticeTeaching│ Principal    │");
        System.out.println("└─────────────────────────────────────────┘");
    }

    /**
     * Método para mostrar ejemplos de uso de los algoritmos.
     */
    public static void mostrarEjemplos() {
        System.out.println("\n💡 EJEMPLOS DE USO:");
        
        // Ejemplo de números
        long numero = 1234567890;
        System.out.println("• Contar dígitos pares en " + numero + ": " + 
                          AlgoritmosNumericos.contarDigitosPares(numero));
        
        // Ejemplo de cadenas
        String palindromo = "anita lava la tina";
        System.out.println("• ¿'" + palindromo + "' es palíndromo?: " + 
                          AlgoritmosCadenas.esPalindromoIgnorandoEspacios(palindromo));
        
        // Ejemplo de arreglos
        float[] numeros = {1.5f, 2.0f, 1.5f, 3.0f, 1.5f};
        System.out.println("• Ocurrencias de 1.5 en [1.5, 2.0, 1.5, 3.0, 1.5]: " + 
                          AlgoritmosArreglos.contarOcurrencias(numeros, 1.5f));
    }
}