import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Frequency {

    public static void main(String[] args) {
        // Crear un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Crear un HashMap para almacenar las frecuencias
        Map<String, Integer> frecuencias = new HashMap<>();
        
        // Pedir al usuario que ingrese las palabras
        System.out.println("Introduce las palabras (una línea en blanco para terminar):");
        
        while (true) {
            // Leer una línea de texto
            String linea = scanner.nextLine();
            
            // Si la línea está vacía, terminamos el bucle
            if (linea.trim().isEmpty()) {
                break;
            }
            
            // Dividir la línea en palabras
            String[] palabras = linea.split(" ");
            
            // Contar las frecuencias de las palabras
            for (String palabra : palabras) {
                // Si la palabra ya existe en el mapa, incrementamos su frecuencia
                frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
            }
        }
        
        // Mostrar los resultados
        System.out.println("Frecuencia de palabras:");
        for (Map.Entry<String, Integer> entry : frecuencias.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        
        // Cerrar el scanner
        scanner.close();
    }
}
