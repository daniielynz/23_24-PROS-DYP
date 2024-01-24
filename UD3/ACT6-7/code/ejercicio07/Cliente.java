package ejercicio07;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Cliente {

	public static void main (String[] args) {
		String host = "localhost";
		int puerto = 6013;
		Socket cliente[] = new Socket[4];
		for(int i = 0; i < cliente.length; i++){
			try {
				System.out.println("PROGRAMA CLIENTE INICIANDO");
				Socket cliRecipiente = cliente[i];
				cliRecipiente = new Socket (host, puerto);
				System.out.println("Recibiendo mensaje del servidor:");
				InputStream is = cliRecipiente.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				System.out.println("\t" + dis.readUTF());
				is.close();
				dis.close();
				cliRecipiente.close();
			} 
			catch (IOException e) {
				System.out.println(e.getMessage());
			} 
		}
	}
} 