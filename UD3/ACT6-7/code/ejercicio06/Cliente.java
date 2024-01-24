package ejercicio06;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		/* PRIMERO HAY QUE EJECUTAR EL SERVIDOR */
		String host = "localhost";
		int puerto = 6010;
		System.out.println("PROGRAMA CLIENTE INICIANDO");
		System.out.println("Introduce un número");
		int num = leerInt();
		try {
			Socket cliente = new Socket(host, puerto);
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());//Canal de salida hacia el servidor
			flujoSalida.write(num);//Envío de los datos
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());//Canal de entrada
			System.out.println("Recibiendo mensaje del servidor:");
			System.out.println("\t El cuadrado del número " + num + " es " + flujoEntrada.readUTF());
			flujoEntrada.close();
			flujoSalida.close();
			cliente.close();
		} catch (IOException e  ) {
			System.out.println(e.getMessage());
		}
	}
	public static int leerInt() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int x = 0;
		try {
			x = Integer.valueOf(in.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return x;

	}
}
