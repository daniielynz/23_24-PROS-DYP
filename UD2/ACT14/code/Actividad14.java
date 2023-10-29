package application;

public class Actividad14 {
public static void main(String args[]) {
    // Crear dos instancias de la clase Recurso
    Recurso a = new Recurso();
    Recurso b = new Recurso(); 

    // Crear dos hilos que usarán los recursos "a" y "b"
    Hilo h1 = new Hilo(a, b, "uno"); 
    // Cambiamos el orden de los recursos en el segundo hilo para evitar el Deadlock
    Hilo h2 = new Hilo(a, b, "dos");

    // Iniciar el hilo "h1"
    h1.start(); 
    // Iniciar el hilo "h2"
    h2.start(); 
}

}
