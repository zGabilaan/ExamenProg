import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repartiendo {
    
    public static void main(String[] args) {
        // Crear un scanner para leer las entradas del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el portal de aterrizaje
        System.out.print("Introduce el portal de aterrizaje: ");
        int portalInicio = scanner.nextInt();
        
        // Solicitar los portales a visitar
        System.out.print("Introduce los portales a visitar (separados por espacio): ");
        scanner.nextLine();  // Limpiar el buffer de la línea anterior
        String entradaPortales = scanner.nextLine();
        
        // Convertir la cadena de portales en una lista de enteros
        String[] portalesStr = entradaPortales.split(" ");
        List<Integer> portales = new ArrayList<>();
        for (String portal : portalesStr) {
            portales.add(Integer.parseInt(portal));
        }
        
        // Obtener el orden en que se visitan los portales
        List<Integer> ordenVisita = repartirRegalos(portalInicio, portales);
        
        // Mostrar el orden de visita de los portales
        System.out.print("Orden de visita: ");
        for (int portal : ordenVisita) {
            System.out.print(portal + " ");
        }
    }
    
    // Método que devuelve el orden de los portales a visitar
    public static List<Integer> repartirRegalos(int portalInicio, List<Integer> portales) {
        List<Integer> ordenVisita = new ArrayList<>();
        int portalActual = portalInicio;
        
        while (!portales.isEmpty()) {
            int siguientePortal = encontrarSiguientePortal(portalActual, portales);
            ordenVisita.add(siguientePortal);
            portales.remove(Integer.valueOf(siguientePortal)); // Eliminar el portal visitado
            portalActual = siguientePortal; // Actualizar la posición de Papá Noel
        }
        
        return ordenVisita;
    }
    
    // Método que encuentra el siguiente portal a visitar, siguiendo las reglas
    public static int encontrarSiguientePortal(int portalActual, List<Integer> portales) {
        int siguientePortal = portales.get(0); // Suponemos que el primer portal es el más cercano
        int minDistancia = Math.abs(portalActual - siguientePortal);
        
        for (int portal : portales) {
            int distancia = Math.abs(portalActual - portal);
            
            if (distancia < minDistancia || (distancia == minDistancia && portal > siguientePortal)) {
                siguientePortal = portal;
                minDistancia = distancia;
            }
        }
        
        return siguientePortal;
    }
}
