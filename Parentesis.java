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

A ver, examen raro te me a hehco dos clases una de coche y otra de maximas con el main.
Da un error al leer el archivo por las rutas, intenta arreglarlo mientras lo hago yo con el chat.
Si ves algo raro cocina. Y si no sabes preguntame.

Clase vehiculo:
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

class Vehiculo {
    String matricula;
    String marca;
    String modelo;
    List<Integer> precios;

    public Vehiculo(String matricula, String marca, String modelo, List<Integer> precios) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precios = precios;
    }

    public int getMaxPrecio() {
        return precios.stream().max(Integer::compare).orElse(0);
    }
}


Clase maximas:

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
                String[] partes = linea.split(",");
                String matricula = partes[0];
                String marca = partes[1];
                String modelo = partes[2];
                List<Integer> precios = Arrays.stream(partes, 3, partes.length)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                return new Vehiculo(matricula, marca, modelo, precios);
            }).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        Map<String, Integer> maximos = vehiculos.stream()
                .collect(Collectors.toMap(v -> v.marca + " " + v.modelo, Vehiculo::getMaxPrecio, Integer::max));

        System.out.println("Precio maximo de reparaciones:");
        maximos.forEach((modelo, maxPrecio) -> System.out.println(modelo + ": " + maxPrecio));
    }
}

