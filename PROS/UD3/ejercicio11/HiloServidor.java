package ejercicio11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloServidor extends Thread {
	
	private Socket cliente;

	public HiloServidor(Socket cliente) {
		this.cliente = cliente;
	}

	public void run() {
		try {
			while (cliente.isClosed() == false) {
				System.out.println("Comunico con: " + cliente.toString());
				DataInputStream dis = new DataInputStream(cliente.getInputStream());
				String texto = dis.readUTF();

				if (texto.equals("*")) {
					System.out.println("Fin de la conexión con: " + cliente.toString());
					dis.close();
					cliente.close();
				} else {
					DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
					dos.writeUTF(texto.toUpperCase());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}