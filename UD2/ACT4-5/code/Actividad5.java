package ejercicios;

public class Actividad5 {
    public static void main(String[] args) {
        //Instanciamos ambos hilos
        Primero p = new Primero();
        Segundo s = new Segundo();
        // Lanzamos ambos hilos
        p.start();
        s.start();

        System.out.println("Fin programa");
    }
}

class Primero extends Thread {
    public void run() {
        //Bucle de 15 repeticiones
        for (int i = 1; i <= 15; i++) {
        System.out.println("Primero " + i);
        try {
        // Detiene el hilo durante 100 milisegundos
        Thread.sleep(100);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        }
    }
}

class Segundo extends Thread {
    public void run() {
        // Bucle de 15 repeticiones
        for (int i = 1; i <= 15; i++) {
        System.out.println("Segundo " + i);
        try {
        // Detiene el hilo durante 200 milisegundos
        Thread.sleep(200); 
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        }
    }
}