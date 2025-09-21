# 🧮 Práctica de Algoritmos - Versión 2.0

## 📋 Descripción

Este proyecto contiene una colección de algoritmos fundamentales organizados de manera modular y con una interfaz interactiva para facilitar el aprendizaje y la práctica de programación algorítmica.

## 🏗️ Estructura del Proyecto

El código ha sido dividido en clases especializadas para mejor organización y mantenibilidad:

### 📁 Archivos del Proyecto

| Archivo | Propósito | Descripción |
|---------|-----------|-------------|
| `AlgorithmsPracticeTeaching.java` | Clase Principal | Punto de entrada del programa |
| `ImagenTeaching.java` | Modelo de Datos | Representación de imágenes con píxeles |
| `AlgoritmosNumericos.java` | Algoritmos Numéricos | Operaciones con números enteros |
| `AlgoritmosCadenas.java` | Algoritmos de Cadenas | Manipulación de texto y cadenas |
| `AlgoritmosArreglos.java` | Algoritmos de Arreglos | Operaciones con colecciones |
| `MenuInteractivo.java` | Interfaz de Usuario | Menú interactivo para probar algoritmos |

## 🚀 Características

### ✅ Mejoras Implementadas

- **Modularidad**: Código dividido en clases especializadas
- **Documentación**: JavaDoc completo en todas las clases
- **Validación**: Manejo robusto de errores y validaciones
- **Interfaz Mejorada**: Menú interactivo con emojis y mejor UX
- **Funcionalidades Adicionales**: Algoritmos extra para mayor utilidad

### 🔧 Algoritmos Disponibles

#### 🔢 Algoritmos Numéricos
- Contar dígitos pares
- Verificar números capicúa
- Sumar dígitos
- Contar total de dígitos
- Verificar números primos

#### 📝 Algoritmos de Cadenas
- Verificar palíndromos
- Palíndromos ignorando espacios y mayúsculas
- Invertir cadenas
- Contar vocales y consonantes
- Eliminar espacios

#### 📊 Algoritmos de Arreglos
- Contar ocurrencias de elementos
- Reordenar chaquiras en parejas
- Encontrar colores únicos en imágenes
- Buscar elementos
- Encontrar máximo y mínimo
- Calcular promedios

## 🎯 Cómo Ejecutar

### Requisitos
- Java 8 o superior
- Terminal o línea de comandos

### Pasos
1. **Compilar todos los archivos:**
   ```bash
   javac *.java
   ```

2. **Ejecutar el programa:**
   ```bash
   java AlgorithmsPracticeTeaching
   ```

3. **Seguir las instrucciones del menú interactivo**

## 📖 Uso del Programa

### Menú Principal
El programa presenta un menú interactivo con las siguientes opciones:

```
╔══════════════════════════════════════╗
║           🧮 MENÚ PRINCIPAL          ║
╠══════════════════════════════════════╣
║ 1. 🔢 Contar dígitos pares           ║
║ 2. 📝 Verificar palíndromo           ║
║ 3. 🔄 Verificar capicúa              ║
║ 4. 🔍 Contar ocurrencias en arreglo  ║
║ 5. 🎨 Reordenar chaquiras           ║
║ 6. 🌈 Colores únicos en imagen       ║
║ 7. ➕ Funciones adicionales          ║
║ 0. 🚪 Salir                         ║
╚══════════════════════════════════════╝
```

### Ejemplos de Uso

#### Contar Dígitos Pares
```
Ingresa un número entero: 1234567890
✅ Resultado: El número 1234567890 tiene 5 dígito(s) par(es)
```

#### Verificar Palíndromo
```
Ingresa una cadena: anita lava la tina
✅ Resultado: 'anita lava la tina' SÍ es palíndromo
```

#### Reordenar Chaquiras
```
¿Cuántos colores?: 6
Color 1 (1-5): 1
Color 2 (1-5): 2
Color 3 (1-5): 1
Color 4 (1-5): 3
Color 5 (1-5): 2
Color 6 (1-5): 1
✅ Colores originales: [1, 2, 1, 3, 2, 1]
✅ Parejas reordenadas: [1, 1, 2, 2, 1, 1]
```

## 🧪 Complejidad Algorítmica

| Algoritmo | Complejidad Temporal | Complejidad Espacial |
|-----------|---------------------|---------------------|
| Contar dígitos pares | O(d) | O(1) |
| Verificar palíndromo | O(n) | O(1) |
| Verificar capicúa | O(d) | O(1) |
| Contar ocurrencias | O(n) | O(1) |
| Reordenar chaquiras | O(n + K) | O(K) |
| Colores únicos | O(n) | O(k) |

Donde:
- `d` = número de dígitos
- `n` = tamaño del arreglo/cadena
- `K` = número de colores (5)
- `k` = número de colores únicos

## 🔧 Desarrollo

### Estructura de Clases

```java
// Ejemplo de uso de las clases
AlgoritmosNumericos.contarDigitosPares(123456);
AlgoritmosCadenas.esPalindromo("anita lava la tina");
AlgoritmosArreglos.contarOcurrencias(arreglo, elemento);
```

### Principios de Diseño Aplicados

1. **Separación de Responsabilidades**: Cada clase tiene una función específica
2. **Inmutabilidad**: Las clases de datos son inmutables cuando es posible
3. **Validación de Entrada**: Validación robusta de parámetros
4. **Manejo de Errores**: Try-catch apropiado y mensajes informativos
5. **Documentación**: JavaDoc completo para todas las funciones públicas

## 📝 Notas de Versión

### Versión 2.0
- ✅ Refactorización completa del código
- ✅ Separación en clases modulares
- ✅ Mejora de la interfaz de usuario
- ✅ Documentación JavaDoc completa
- ✅ Validaciones y manejo de errores mejorado
- ✅ Algoritmos adicionales agregados

### Versión 1.0
- Implementación inicial con todos los algoritmos en una sola clase

## 🤝 Contribuciones

Este proyecto es para fines educativos. Las mejoras y sugerencias son bienvenidas.

## 📄 Licencia

Proyecto educativo - Uso libre para fines académicos.
