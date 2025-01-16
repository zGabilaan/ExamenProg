import java.util.HashMap;
import java.util.Scanner;

public class Capitales {

    public static void main(String[] args) {
        // Crear el HashMap para almacenar el país y su capital
        HashMap<String, String> paisesCapitals = new HashMap<>();
        
        // Llenar el HashMap con algunos países europeos y sus capitales
        paisesCapitals.put("España", "Madrid");
        paisesCapitals.put("Francia", "París");
        paisesCapitals.put("Italia", "Roma");
        paisesCapitals.put("Alemania", "Berlín");
        paisesCapitals.put("Portugal", "Lisboa");
        paisesCapitals.put("Reino Unido", "Londres");
        paisesCapitals.put("Suecia", "Estocolmo");
        paisesCapitals.put("Polonia", "Varsovia");
        paisesCapitals.put("Bélgica", "Bruselas");
        paisesCapitals.put("Países Bajos", "Ámsterdam");
        
        // Crear un Scanner para pedir la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Pedir al usuario el nombre de un país
        System.out.print("Introduce el nombre de un país europeo: ");
        String pais = scanner.nextLine();
        
        // Verificar si el país está en el HashMap y mostrar la capital
        if (paisesCapitals.containsKey(pais)) {
            String capital = paisesCapitals.get(pais);
            System.out.println("La capital de " + pais + " es " + capital + ".");
        } else {
            System.out.println("El país " + pais + " no está en la lista.");
        }
        
        // Cerrar el scanner
        scanner.close();
    }
}
