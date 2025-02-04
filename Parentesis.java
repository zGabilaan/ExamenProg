import java.util.Stack;

public class Parentesis {

    public static void main(String[] args) {
        // Ejemplo de secuencia
        String secuencia = "{[()]}";  // Cambiar por cualquier secuencia a verificar
        
        if (esBalanceada(secuencia)) {
            System.out.println("La secuencia está balanceada.");
        } else {
            System.out.println("La secuencia NO está balanceada.");
        }
    }

    // Método para verificar si la secuencia está balanceada
    public static boolean esBalanceada(String secuencia) {
        // Pila para almacenar los caracteres de apertura
        Stack<Character> pila = new Stack<>();
        
        // Recorremos cada caracter de la secuencia
        for (int i = 0; i < secuencia.length(); i++) {
            char c = secuencia.charAt(i);
            
            // Si encontramos un símbolo de apertura, lo apilamos
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            }
            // Si encontramos un símbolo de cierre, verificamos
            else if (c == ')' || c == ']' || c == '}') {
                // Si la pila está vacía o el símbolo no coincide con el de apertura, no está balanceada
                if (pila.isEmpty()) {
                    return false;
                }
                
                char ultimo = pila.pop();
                if (!esPareja(ultimo, c)) {
                    return false;
                }
            }
        }
        
        // Al final, la pila debe estar vacía si todo está balanceado
        return pila.isEmpty();
    }

    // Método para comprobar si un par de caracteres es un par correspondiente
    public static boolean esPareja(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }
}
ahora sube el txt

Vale, esto que te paso ahora a mi me va perfecto, el archivo txt ponlo en la raiz del proyecto.
Si no te va algo preguntame. Acuerdate de la ruta del archivo.

import java.util.*;

class Vehiculo {
    String matricula;
    String nombre;
    List<Integer> precios;

    public Vehiculo(String matricula, String nombre, List<Integer> precios) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.precios = precios;
    }

    public int getMaxPrecio() {
        return precios.stream().max(Integer::compare).orElse(0);
    }
}


Clase Maximas:
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maximas {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String archivo = "reparaciones_vehiculos.txt";

        try (Stream<String> stream = Files.lines(Paths.get(archivo))) {
            vehiculos = stream.map(linea -> {
                String[] partes = linea.split(",", 3);
                String matricula = partes[0];
                String nombre = partes[1];
                List<Integer> precios = Arrays.stream(partes[2].split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                return new Vehiculo(matricula, nombre, precios);
            }).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        Map<String, Integer> maximos = vehiculos.stream()
                .collect(Collectors.toMap(v -> v.nombre, Vehiculo::getMaxPrecio, Integer::max));

        maximos.forEach((nombre, maxPrecio) -> {
            System.out.println(nombre + ": " + maxPrecio);
        });
    }
}



