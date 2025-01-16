import java.util.*;

public class ExpresionesAritmeticas {

    public static void main(String[] args) {
        // Prueba con una expresión de ejemplo
        String expresion = "3 4 + 5 * 6 2 / +"; // Expresión en notación postfija
        
        try {
            double resultadoPila = evaluarPostfijaPila(expresion);
            double resultadoCola = evaluarPostfijaCola(expresion);
            
            System.out.println("Resultado usando pila: " + resultadoPila);
            System.out.println("Resultado usando cola: " + resultadoCola);
            
            if (resultadoPila == resultadoCola) {
                System.out.println("Ambos métodos producen el mismo resultado.");
            } else {
                System.out.println("Los resultados son diferentes.");
            }
        } catch (Exception e) {
            System.out.println("Error en la expresión: " + e.getMessage());
        }
    }

    // Método para evaluar la expresión postfija usando una pila
    public static double evaluarPostfijaPila(String expresion) throws ArithmeticException {
        Stack<Double> pila = new Stack<>();
        String[] tokens = expresion.split(" ");
        
        for (String token : tokens) {
            if (esNumero(token)) {
                pila.push(Double.parseDouble(token));
            } else if (esOperador(token)) {
                double b = pila.pop();
                double a = pila.pop();
                double resultado = aplicarOperador(a, b, token);
                pila.push(resultado);
            } else {
                throw new IllegalArgumentException("Token no reconocido: " + token);
            }
        }
        
        if (pila.size() != 1) {
            throw new IllegalStateException("Expresión inválida.");
        }
        
        return pila.pop();
    }

    // Método para evaluar la expresión postfija usando una cola
    public static double evaluarPostfijaCola(String expresion) throws ArithmeticException {
        Queue<Double> cola = new LinkedList<>();
        String[] tokens = expresion.split(" ");
        
        for (String token : tokens) {
            if (esNumero(token)) {
                cola.offer(Double.parseDouble(token));
            } else if (esOperador(token)) {
                double a = cola.poll();
                double b = cola.poll();
                double resultado = aplicarOperador(a, b, token);
                cola.offer(resultado);
            } else {
                throw new IllegalArgumentException("Token no reconocido: " + token);
            }
        }
        
        if (cola.size() != 1) {
            throw new IllegalStateException("Expresión inválida.");
        }
        
        return cola.poll();
    }

    // Método para aplicar el operador a los dos operandos
    public static double aplicarOperador(double a, double b, String operador) throws ArithmeticException {
        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("No se puede dividir entre cero.");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Operador no reconocido: " + operador);
        }
    }

    // Método para comprobar si una cadena es un número
    public static boolean esNumero(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Método para comprobar si una cadena es un operador
    public static boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
