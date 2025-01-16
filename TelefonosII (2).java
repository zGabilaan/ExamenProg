import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TelefonosII {

    public static void main(String[] args) {
        // Crear un HashMap donde la clave es el nombre del contacto y el valor es una lista de números de teléfono
        HashMap<String, List<String>> guiaTelefonica = new HashMap<>();
        
        // Crear un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Menú de opciones para agregar y buscar contactos
        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar contacto y teléfono");
            System.out.println("2. Buscar teléfono de un contacto");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer
            
            if (opcion == 1) {
                // Opción para agregar un contacto y teléfono
                System.out.print("Introduce el nombre del contacto: ");
                String contacto = scanner.nextLine();
                
                // Si el contacto ya existe, añadimos un nuevo número de teléfono a su lista
                if (!guiaTelefonica.containsKey(contacto)) {
                    guiaTelefonica.put(contacto, new ArrayList<>());
                }
                
                // Pedir el número de teléfono
                System.out.print("Introduce el número de teléfono: ");
                String telefono = scanner.nextLine();
                
                // Añadir el teléfono al contacto
                guiaTelefonica.get(contacto).add(telefono);
                System.out.println("Número de teléfono añadido.");
                
            } else if (opcion == 2) {
                // Opción para buscar los números de teléfono de un contacto
                System.out.print("Introduce el nombre del contacto para buscar su teléfono: ");
                String contacto = scanner.nextLine();
                
                // Buscar y mostrar los números de teléfono del contacto
                if (guiaTelefonica.containsKey(contacto)) {
                    List<String> telefonos = guiaTelefonica.get(contacto);
                    System.out.println("Los números de teléfono de " + contacto + " son:");
                    for (String telefono : telefonos) {
                        System.out.println(telefono);
                    }
                } else {
                    System.out.println("El contacto " + contacto + " no está en la guía.");
                }
                
            } else if (opcion == 3) {
                // Opción para salir del programa
                System.out.println("Saliendo del programa...");
                break;
            } else {
                System.out.println("Opción inválida. Por favor, elige una opción válida.");
            }
        }
        
        // Cerrar el scanner
        scanner.close();
    }
}
