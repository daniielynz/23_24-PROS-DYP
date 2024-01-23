package ejercicio02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad2 {

	public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Se necesita proporcionar una URL como argumento.");
            return; // Exit the program if no arguments are provided.
        }

        String direccion = args[0];
        InetAddress address[];
        try {
            address = InetAddress.getAllByName(direccion);
            System.out.println("Direcciones asociadas a " + direccion + " son:");

            for (int i = 0; i < address.length; i++) {
                System.out.println(address[i]);
            }

        } catch (UnknownHostException e) {
            System.out.println("No se pudo obtener la dirección para la URL proporcionada.");
        }
        

    }
}
