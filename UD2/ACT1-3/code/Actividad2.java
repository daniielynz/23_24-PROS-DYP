public class Actividad2 {
    public static void main(String[] args) {
        // Verificar si se proporciona un argumento
        if (args.length != 1) {
            System.out.println("Dime un numero de Hilos");
            return;
        }
        // Obtener el número de hilos a crear desde el argumento
        int n = Integer.parseInt(args[0]);

        // Crear y ejecutar la cantidad de hilos introducida
        for (int i = 1; i <= n; i++) {
            Thread hilo = new Hilo(i); 
            // Iniciar el hilo
            hilo.start();  
        }
		// Imprimir un mensaje al final del programa
        System.out.println("Final Programa");  
    }
}

class Hilo extends Thread {
	// Número de identificación del hilo
    private int numeroHilo;  

    public Hilo(int numeroHilo) {
        this.numeroHilo = numeroHilo;
    }

    public void run() {
        // Imprimir el número de hilo 20 veces
        for (int i = 1; i <= 20; i++) {
            System.out.println("Hilo " + numeroHilo);
        }
    }
}