package application;

public class Actividad2 {
	public static void main(int n) {
		// Recibimos n como la cantidad de hilos que vamos a crear
		for (int i = 1; i <= n; i++) {
			Thread hilo = new HiloPersonalizado(i);
			hilo.start();
		}
	
		System.out.println("Final Programa");
	}
}

class HiloPersonalizado extends Thread {
	private final int numeroHilo;

	public HiloPersonalizado(int numeroHilo) {
		this.numeroHilo = numeroHilo;
	}

	public void run() {
		// Sacamos 20 veces por pantalla el mensaje por cada Hilo
		for (int i = 1; i <= 20; i++) {
		System.out.println("Hilo " + numeroHilo);
		}
	}
}
