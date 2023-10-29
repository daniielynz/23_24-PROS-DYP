import java.text.SimpleDateFormat;
import java.util.Date;

public class Actividad15 {
    public static void main(String[] args) {
        // Crear e iniciar tres hilos
        Thread hilo1 = new Thread(new MensajesHilo("Hilo 1")); // Crear el primer hilo con nombre "Hilo 1"
        Thread hilo2 = new Thread(new MensajesHilo("Hilo 2")); // Crear el segundo hilo con nombre "Hilo 2"
        Thread hilo3 = new Thread(new MensajesHilo("Hilo 3")); // Crear el tercer hilo con nombre "Hilo 3"

        // iniciamos los hilos
        hilo1.start(); // Iniciar el primer hilo
        hilo2.start(); // Iniciar el segundo hilo
        hilo3.start(); // Iniciar el tercer hilo
    }
}

class MensajesHilo implements Runnable {
    private String nombre;

    public MensajesHilo(String nombre) {
        this.nombre = nombre; 
    }

    @Override
    public void run() {
        // Sacamos la fecha actual
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        for (int i = 0; i < 5; i++) {
            // Sacamos la hora actual
            Date horaActual = new Date();
            // le damos formato a la hora actual
            String horaFormateada = formatoHora.format(horaActual);

            System.out.println(nombre + " - " + horaFormateada);

            try {
                // pausa de 1 minuto entre mensajes
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
