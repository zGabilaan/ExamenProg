import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Coches {
    public static void main(String[] args) {
        // Crear un scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Crear una lista para almacenar las marcas de coches
        ArrayList<String> marcas = new ArrayList<>();
        
        System.out.println("Introduce las marcas de coches (deja una línea en blanco para finalizar):");
        
        while (true) {
            // Leer la entrada del usuario
            String marca = scanner.nextLine();
            
            // Si la entrada es una línea en blanco, terminar el bucle
            if (marca.isEmpty()) {
                break;
            }
            
            // Añadir la marca a la lista
            marcas.add(marca);
        }
        
        // Ordenar la lista alfabéticamente
        Collections.sort(marcas);
        
        // Imprimir las marcas ordenadas
        System.out.println("\nMarcas de coches ordenadas:");
        for (String marca : marcas) {
            System.out.println(marca);
        }
        
        // Cerrar el scanner
        scanner.close();
    }
}
