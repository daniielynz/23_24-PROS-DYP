package ejercicio06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		/* EJECUTAR ANTES QUE EL SERVIDOR */
		int puerto = 6010;
		ServerSocket servidor = new ServerSocket(puerto);
		System.out.println("Esperando al cliente...");
		Socket cliente = servidor.accept();
		InputStream inputStream = cliente.getInputStream();// Canal de entrada desde el cliente
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		int mensaje = dataInputStream.read();// Leer el mensaje de el cliente
		OutputStream salida = cliente.getOutputStream();// Canal de salida hacia el cliente
		DataOutputStream dataOutputStream = new DataOutputStream(salida);
		dataOutputStream.writeUTF(String.valueOf((int) Math.pow(mensaje, 2)));// Enviar mensaje
		inputStream.close();
		dataInputStream.close();
		salida.close();
		dataOutputStream.close();
		cliente.close();
		servidor.close();
	}
}