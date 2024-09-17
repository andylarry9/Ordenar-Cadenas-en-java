
package consola;

// Se importan las clases necesarias desde el paquete java.util.
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class OrdenarCadenas {
    
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in); // Se crea un objeto Scanner para leer la entrada del usuario desde la consola.
        

        // Se solicita al usuario que ingrese la cantidad de cadenas y se lee como un entero.
        System.out.print("Indique la cantidad de cadenas a ingresar: ");
        int n = scanner.nextInt(); // Consumir el salto de línea después del número.
        scanner.nextLine(); // Luego, se consume el salto de línea que queda en el búfer del Scanner.

        

        LinkedList<String> cadenas = new LinkedList<>(); // Se crea una lista enlazada para almacenar las cadenas de entrada.
        
        // Se muestra un mensaje al usuario para que ingrese las cadenas.
        System.out.println("Digite las " + n + " cadenas a continuación:");
       // Se utiliza un bucle for para leer las cadenas y agregarlas a la lista enlazada.
        for (int i = 0; i < n; i++) {
            String cadena = scanner.next(); //almacenamos el valor ingresado en la variable cadena.
            cadenas.add(cadena);
        }
       
        
        // Se llama a la función "ordenarCadenas" para ordenar las cadenas y se almacenan en una nueva lista.
        LinkedList<String> cadenasOrdenadas = ordenarCadenas(cadenas);
       
        // Se imprime la secuencia de cadenas ordenadas en la consola.
        System.out.println("Secuencia de cadenas ordenadas:");
        for (String cadena : cadenasOrdenadas) {
            System.out.print(cadena + ", ");
        }
        

    }
    // Se define una función llamada "ordenarCadenas" que toma una lista enlazada de cadenas como argumento.
    public static LinkedList<String> ordenarCadenas(LinkedList<String> cadenas) {
        
        // Se crea una cola de prioridad que se utiliza para ordenar las cadenas.
        PriorityQueue<String> colaPrioridad = new PriorityQueue<>((a, b) -> {
           // El comparador compara las cadenas primero por longitud y, en caso de empate, alfabéticamente.
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                  return a.compareTo(b);
            }
        });
        
         // Se agregan todas las cadenas a la cola de prioridad para que se ordenen automáticamente.
        colaPrioridad.addAll(cadenas);
       
        // Se crea una nueva lista enlazada para almacenar las cadenas ordenadas.
        LinkedList<String> cadenasOrdenadas = new LinkedList<>();
        
       // Se extraen las cadenas ordenadas de la cola de prioridad y se agregan a la lista "cadenasOrdenadas".
        while (!colaPrioridad.isEmpty()) {
            cadenasOrdenadas.add(colaPrioridad.poll());
        }
        
         // Se devuelve la lista de cadenas ordenadas.
        return cadenasOrdenadas;
       
    }
}
