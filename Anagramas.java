import java.io.*;
import java.util.*;

public class Anagramas {

    public static void main(String[] args) throws IOException {
        // Ruta del archivo donde están las palabras
        BufferedReader reader = new BufferedReader(new FileReader("path-to-file"));
        String line;
        
        // Crear un HashMap para almacenar las palabras agrupadas por anagramas
        Map<String, List<String>> anagramas = new HashMap<>();
        
        // Leer línea por línea
        while ((line = reader.readLine()) != null) {
            line = line.trim();  // Limpiar posibles espacios extraños
            
            if (!line.isEmpty()) {
                // Ordenar las letras de la palabra
                String palabraOrdenada = alphabetize(line);
                
                // Agregar la palabra al grupo correspondiente en el HashMap
                anagramas.putIfAbsent(palabraOrdenada, new ArrayList<>());
                anagramas.get(palabraOrdenada).add(line);
            }
        }
        reader.close();
        
        // Pedir al usuario el tamaño mínimo de grupo de anagramas
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el tamaño mínimo del grupo de anagramas: ");
        int minGroupSize = scanner.nextInt();
        scanner.close();
        
        // Mostrar los grupos que tengan al menos 'minGroupSize' palabras
        for (Map.Entry<String, List<String>> entry : anagramas.entrySet()) {
            List<String> grupo = entry.getValue();
            if (grupo.size() >= minGroupSize) {
                System.out.println(grupo);
            }
        }
    }
    
    // Método para ordenar las letras de una palabra
    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
