package application;

class Hilo extends Thread {
    Recurso a;
    Recurso b;

    // Constructor de la clase Hilo
public Hilo(Recurso a, Recurso b, String nombre) {
    super(nombre);
    this.a = a;
    this.b = b; 
}

// Método que se ejecuta cuando el hilo inicia
public void run() {
    // Imprimir un mensaje indicando que el hilo ha comenzado
    System.out.println("Hilo " + this.getName() + " comienza"); 

    // Bloquear el recurso "a" para este hilo
    synchronized (a) { 
        try {
            // Hacer que el hilo duerma durante 100 milisegundos
            Thread.sleep(100); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    // Bloquear el recurso "b" dentro del bloque de recurso "a"
    synchronized (b) { 
        
    }
    // Mensaje indicando que el hilo ha terminado
    System.out.println("Hilo " + this.getName() + " ha terminado"); 
    }
}

}

class Recurso {
}
