import java.io.*;
import java.util.*;

public class CountCountries {

    public static void main(String[] args) throws IOException {
        // Ruta del archivo CSV
        BufferedReader reader = new BufferedReader(new FileReader("alumnos.csv"));
        String line;
        
        // Crear un HashMap para contar la cantidad de alumnos por país
        Map<String, Integer> paises = new HashMap<>();
        
        // Leer cada línea del archivo
        while ((line = reader.readLine()) != null) {
            // Dividir la línea en columnas
            String[] columnas = line.split(",");
            
            // Asegurarnos de que la línea contiene suficientes columnas
            if (columnas.length >= 7) {
                // Obtener el país de la columna 7 (índice 6)
                String pais = columnas[6].trim();
                
                // Actualizar el conteo de alumnos por país
                paises.put(pais, paises.getOrDefault(pais, 0) + 1);
            }
        }
        reader.close();
        
        // Pedir al usuario el nombre de un país
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre de un país para obtener la cantidad de alumnos: ");
        String paisBuscado = scanner.nextLine().trim();
        scanner.close();
        
        // Mostrar la cantidad de alumnos del país buscado
        int cantidad = paises.getOrDefault(paisBuscado, 0);
        System.out.println("Cantidad de alumnos de " + paisBuscado + ": " + cantidad);
    }
}
