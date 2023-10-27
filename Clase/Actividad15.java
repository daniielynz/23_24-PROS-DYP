import java.text.SimpleDateFormat;
import java.util.Date;

public class Actividad15 {
    public static void main(String[] args) {
        // Crear e iniciar tres hilos
        Thread hilo1 = new Thread(new MensajesHilo("Hilo 1")); // Crear el primer hilo con nombre "Hilo 1"
        Thread hilo2 = new Thread(new MensajesHilo("Hilo 2")); // Crear el segundo hilo con nombre "Hilo 2"
        Thread hilo3 = new Thread(new MensajesHilo("Hilo 3")); // Crear el tercer hilo con nombre "Hilo 3"

        hilo1.start(); // Iniciar el primer hilo
        hilo2.start(); // Iniciar el segundo hilo
        hilo3.start(); // Iniciar el tercer hilo
    }
}

class MensajesHilo implements Runnable {
    private String nombre;

    public MensajesHilo(String nombre) {
        this.nombre = nombre; // Asignar el nombre del hilo
    }

    @Override
    public void run() {
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss"); // Formatear la hora actual en el formato "HH:mm:ss"

        for (int i = 0; i < 5; i++) { // Repetir 5 veces para mostrar 5 mensajes
            Date horaActual = new Date(); // Obtener la hora actual
            String horaFormateada = formatoHora.format(horaActual); // Formatear la hora actual

            System.out.println(nombre + " - " + horaFormateada); // Mostrar el mensaje con el nombre del hilo y la hora formateada

            try {
                Thread.sleep(1000); // Esperar 1 segundo entre mensajes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
