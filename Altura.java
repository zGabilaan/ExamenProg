import java.util.ArrayList;
import java.util.Scanner;

public class Altura {
    
    public static void main(String[] args) {
        // Llamamos a los métodos que organizan el programa
        
        int numAlumnos = numeroAlumnos();  // Número de alumnos
        ArrayList<Double> alturas = new ArrayList<>();
        
        leerAlturas(alturas, numAlumnos);  // Pedimos y almacenamos las alturas
        
        double media = calcularMedia(alturas);  // Calculamos la altura media
        
        mostrarResultados(alturas, media);  // Mostramos los resultados
        
        int alumnosAltos = calcularAlumnosAlturaSuperior(alturas, media);  // Alumnos más altos que la media
        int alumnosBajos = calcularAlumnosAlturaInferior(alturas, media);  // Alumnos más bajos que la media
        
        System.out.println("\nAlumnos más altos que la media: " + alumnosAltos);
        System.out.println("Alumnos más bajos que la media: " + alumnosBajos);
    }

    // Método que pide por teclado el número de alumnos
    public static int numeroAlumnos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de alumnos: ");
        int numAlumnos = scanner.nextInt();
        return numAlumnos;
    }

    // Método que pide las alturas de los alumnos
    public static void leerAlturas(ArrayList<Double> alturas, int numAlumnos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce las alturas de los " + numAlumnos + " alumnos:");
        
        for (int i = 0; i < numAlumnos; i++) {
            System.out.print("Altura del alumno " + (i + 1) + ": ");
            double altura = scanner.nextDouble();
            alturas.add(altura);
        }
    }

    // Método que calcula la media de las alturas
    public static double calcularMedia(ArrayList<Double> alturas) {
        double suma = 0;
        for (Double altura : alturas) {
            suma += altura;
        }
        return suma / alturas.size();
    }

    // Método que calcula los alumnos con altura superior a la media
    public static int calcularAlumnosAlturaSuperior(ArrayList<Double> alturas, double media) {
        int contador = 0;
        for (Double altura : alturas) {
            if (altura > media) {
                contador++;
            }
        }
        return contador;
    }

    // Método que calcula los alumnos con altura inferior a la media
    public static int calcularAlumnosAlturaInferior(ArrayList<Double> alturas, double media) {
        int contador = 0;
        for (Double altura : alturas) {
            if (altura < media) {
                contador++;
            }
        }
        return contador;
    }

    // Método que muestra los resultados
    public static void mostrarResultados(ArrayList<Double> alturas, double media) {
        System.out.println("\nAlturas de los alumnos:");
        for (Double altura : alturas) {
            System.out.println(altura);
        }
        System.out.println("\nLa altura media de los alumnos es: " + media);
    }
}
