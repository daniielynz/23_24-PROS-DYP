package ejercicios;

public class Actividad3 {
    public static void main(String[] args) {
        Thread hilo = Thread.currentThread();

        // Mostramos el hilo que acabamos de crear con sus valores iniciales
        System.out.println("El nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());

        // Cambiar nombre
        hilo.setName("SUPER-HILO-DM2");
        
        // Le sumamos uno a su prioridad
        hilo.setPriority(Thread.NORM_PRIORITY + 1);

        // Mostrar valores modificados
        System.out.println("Ahora el nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());


        System.out.println("Final programa");
    }
}