class Actividad10 {
    public static void main(String[] args) {
        // Obtiene una referencia al hilo principal (main)
        Thread mainThread = Thread.currentThread();
        // Establece la prioridad del hilo principal en 5
        mainThread.setPriority(5);
        // Muestra el nombre y la prioridad del hilo principal en la consola
        System.out.println(mainThread.getName() + " tiene la prioridad " + mainThread.getPriority());

        // Crea dos objetos de la clase Hilo
        Hilo hilo1 = new Hilo("Hilo-prioridad 3");
        Hilo hilo2 = new Hilo("Hilo-prioridad 7");

        // Asigna prioridades a los dos hilos
        hilo1.setPriority(3);
        hilo2.setPriority(7);

        // Muestra el nombre y la prioridad
        System.out.println(hilo1.getName() + " tiene la prioridad " + hilo1.getPriority());
        System.out.println(hilo2.getName() + " tiene la prioridad " + hilo2.getPriority());

        // Inicia los hilos
        hilo1.start();
        hilo2.start();

        // Muestra un mensaje final en la consola
        System.out.println("Final programa");
    }
}

class Hilo extends Thread {
    private String mensaje;

    public Hilo(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        // Muestra un mensaje "Ejecutando"
        System.out.println("Ejecutando " + mensaje);
    }
}
