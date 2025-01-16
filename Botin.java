import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Botin {

    public static void main(String[] args) {
        // Definir el número de participantes y los billetes a repartir
        int numParticipantes = 3;
        Integer[] billetes = {50, 20, 100, 200, 500, 10, 50};
        
        // Llamar a la función para repartir los billetes
        Map<Integer, List<Integer>> reparto = repartirBotin(numParticipantes, billetes);
        
        // Mostrar el resultado
        System.out.println("1");
        System.out.println(reparto);
    }
    
    public static Map<Integer, List<Integer>> repartirBotin(int numParticipantes, Integer[] billetes) {
        // Crear un Map para almacenar los billetes repartidos a cada participante
        Map<Integer, List<Integer>> reparto = new HashMap<>();
        
        // Inicializar las listas para cada participante
        for (int i = 0; i < numParticipantes; i++) {
            reparto.put(i, new ArrayList<>());
        }
        
        // Repartir los billetes
        for (int i = 0; i < billetes.length; i++) {
            // Determinar a qué participante le toca el billete
            int participante = i % numParticipantes;
            // Agregar el billete a la lista del participante correspondiente
            reparto.get(participante).add(billetes[i]);
        }
        
        return reparto;
    }
}
