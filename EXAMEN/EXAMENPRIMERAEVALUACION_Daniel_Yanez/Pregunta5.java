package examen;

public class Pregunta5 {

	public static void main(String[] args) {
		// Creamos los objetos de tipo "Pregunta5Hilo"
		Pregunta5Hilo t1 = new Pregunta5Hilo("El 1: ==>");
		Pregunta5Hilo t2 = new Pregunta5Hilo("El 2: ==>");
		Pregunta5Hilo t3 = new Pregunta5Hilo("El 3: ==>");
		Pregunta5Hilo t4 = new Pregunta5Hilo("El 4: ==>");
		
		// asignamos las prioridades
		t1.setPriority(5);
		t2.setPriority(9);
		t3.setPriority(7);
		t4.setPriority(3);
		
		// los lanzamos
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
