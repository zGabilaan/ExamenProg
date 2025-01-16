import java.util.HashMap;
import java.util.Scanner;

public class Telefonos {

    public static void main(String[] args) {
        // Crear un HashMap para almacenar los contactos y sus números de teléfono
        HashMap<String, String> guiaTelefonica = new HashMap<>();
        
        // Agregar algunos contactos y números de teléfono al HashMap
        guiaTelefonica.put("Juan", "123456789");
        guiaTelefonica.put("Maria", "987654321");
        guiaTelefonica.put("Carlos", "555123456");
        guiaTelefonica.put("Ana", "666789012");
        guiaTelefonica.put("Pedro", "777123456");
        
        // Crear un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Pedir al usuario el nombre del contacto que desea buscar
        System.out.print("Introduce el nombre del contacto: ");
        String contacto = scanner.nextLine();
        
        // Buscar el número de teléfono asociado al contacto
        if (guiaTelefonica.containsKey(contacto)) {
            String telefono = guiaTelefonica.get(contacto);
            System.out.println("El número de teléfono de " + contacto + " es: " + telefono);
        } else {
            System.out.println("El contacto " + contacto + " no está en la guía.");
        }
        
        // Cerrar el scanner
        scanner.close();
    }
}
