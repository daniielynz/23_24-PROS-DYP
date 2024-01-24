package ejercicio03;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad3 {
	public static void main(String[] args) {
		String direccion =  args[0];

		try {
			InetAddress address[];
			address = InetAddress.getAllByName(direccion);
			System.out.println("Direcciones asociadas a " + direccion + " son:");

			for (int i = 0; i < address.length; i++) {
				System.out.println(address[i]);
			}

		} catch (UnknownHostException e) {			
			try {
				InetAddress local;
				InetAddress localAddresses[];
				local = InetAddress.getLocalHost();
				localAddresses = InetAddress.getAllByName(local.getHostName());
				System.out.println("Dirección IP: " + localAddresses[0].getHostAddress());
				System.out.println("Nombre: " + localAddresses[0].getHostName());
				for (int i = 0; i < localAddresses.length; i++) {
					System.out.println(localAddresses[i]);
				}
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
