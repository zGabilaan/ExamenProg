import java.util.HashMap;
import java.util.Scanner;

public class MejorTerminacion {

    public static void main(String[] args) {
        // Crear un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese la cantidad de boletos
        System.out.print("Introduce el número de boletos: ");
        int numBoletos = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada

        // Crear un array o lista para almacenar los boletos
        String[] boletos = new String[numBoletos];

        // Leer los boletos introducidos por el usuario
        for (int i = 0; i < numBoletos; i++) {
            System.out.print("Introduce el boleto #" + (i + 1) + ": ");
            boletos[i] = scanner.nextLine();
        }

        // Crear un HashMap para contar las terminaciones
        HashMap<Integer, Integer> terminaciones = new HashMap<>();

        // Recorrer los boletos y extraer el último dígito
        for (String boleto : boletos) {
            // Obtener el último carácter y convertirlo a un número
            int ultimaTerminacion = Character.getNumericValue(boleto.charAt(boleto.length() - 1));

            // Incrementar el contador en el HashMap
            terminaciones.put(ultimaTerminacion, terminaciones.getOrDefault(ultimaTerminacion, 0) + 1);
        }

        // Mostrar el resultado
        System.out.println("Las terminaciones más comunes son:");
        System.out.println(terminaciones);

        // Cerrar el scanner
        scanner.close();
    }
}
