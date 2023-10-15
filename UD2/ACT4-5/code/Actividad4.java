package ejercicios;

public class Actividad4 implements Runnable {
    // Guardamos el nombre del hilo en una variable
    private String hilo;

    public Actividad4(String hilo) {
        this.hilo = hilo;
    }

    public static void main(String[] args) {
	    //Instanciamos ambos hilos
        Thread hilo1 = new Thread(new Actividad4("Primero"));
        Thread hilo2 = new Thread(new Actividad4("Segundo"));

        // Ejecutamos los dos hilos
        hilo1.start();
        hilo2.start();

        try {
            // Bloqueamos el hilo principal hasta que el hilo1 termine su ejecucion
            hilo1.join();
            // Ahora lo mismo con el hilo2
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin programa");
    }

    @Override
    public void run() {
	    //Bucle para 15 repeticiones
        for (int i = 1; i <= 15; i++) {
            System.out.println(hilo+" "+i);
        }
    }
}
