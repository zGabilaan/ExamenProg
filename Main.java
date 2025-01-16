import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        // Ejemplo de personas
        List<Person> people = Arrays.asList(
            new Person("John", "Doe", 1980),
            new Person("Jane", "Smith", 1965),
            new Person("Alice", "Anderson", 1990),
            new Person("Bob", "Allen", 1968),
            new Person("Anna", "Adams", 1975)
        );
        
        // Problema 1: Contar cuántas personas nacieron antes de 1970
        long countBefore1970 = people.stream()
            .filter(p -> p.getBirthYear() < 1970)
            .count();
        System.out.println("Personas nacidas antes de 1970: " + countBefore1970);

        // Problema 2: Contar cuántas personas tienen un primer apellido que empiece por "A"
        long countLastNameStartsWithA = people.stream()
            .filter(p -> p.getLastName().startsWith("A"))
            .count();
        System.out.println("Personas con apellido que empieza con 'A': " + countLastNameStartsWithA);

        // Problema 3: Imprimir los nombres únicos en orden alfabético
        people.stream()
            .map(Person::getFirstName)
            .distinct() // Elimina duplicados
            .sorted()   // Ordena alfabéticamente
            .forEach(System.out::println);

        // Problema 4: Leer números del usuario y filtrar los que estén entre 1 y 5
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        
        System.out.println("Introduce números (un número negativo para terminar):");
        while (true) {
            int num = scanner.nextInt();
            if (num < 0) {
                break;
            }
            numbers.add(num);
        }
        
        numbers.stream()
            .filter(num -> num >= 1 && num <= 5)
            .forEach(System.out::println);
    }
}

// Clase Person
class Person {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getBirthYear() {
        return this.birthYear;
    }
}
