package examen;

public class Pregunta4Hilos extends Thread {
	@Override
	public void run() {
		Pregunta4Hilo.anadir();
	}
} 