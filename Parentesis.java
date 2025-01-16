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
