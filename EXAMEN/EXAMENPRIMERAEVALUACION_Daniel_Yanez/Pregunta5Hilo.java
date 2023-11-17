package examen;

public class Pregunta5Hilo extends Thread{
	
	private String mensaje;
	
	public Pregunta5Hilo(String string) {
		// recibe parametro de tipo String
		this.mensaje = string;
	}

	public void run() {
		//  bucle de 3 repeticiones
		for (int i = 1; i <= 3; i++) {
			System.out.println(mensaje+" "+i);
		}
	}
}
