package application;

public class Actividad1 extends Thread {
	public static void main(String[] args) {
		Actividad1 hilo = new Actividad1();
		hilo.start();
		System.out.print("Fin programa");
	}
	
	public void run() {
		// Blucle para mostrar 20 veces el hilo 1 
		for (int i = 1; i <= 20; i++) {
		System.out.println("Primero " + i);
		}
		// Blucle para mostrar 20 veces el hilo 2
		for (int i = 1; i <= 20; i++) {
		System.out.println("Segundo " + i);
		}
	}
}
