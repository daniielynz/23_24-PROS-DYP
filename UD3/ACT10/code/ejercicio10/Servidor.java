package ejercicio10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

	public static void main(String[] args) {
        try {
            int puerto = 34570;
            byte bufferRecibo[] = new byte[1024];
            DatagramPacket recibo = new DatagramPacket(bufferRecibo, bufferRecibo.length);
            DatagramSocket socket = new DatagramSocket(puerto);

            System.out.println("Esperando datagrama.......");
            socket.receive(recibo);
            
            // Convertir los bytes recibidos a un objeto Tenista
            ByteArrayInputStream bais = new ByteArrayInputStream(bufferRecibo);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Tenista tenista = (Tenista) ois.readObject();
            ois.close();

            System.out.println("Recibo el objeto: " + tenista.getApellido()+" "+tenista.getAltura());
            System.out.println("IP de origen: " + recibo.getAddress());
            System.out.println("Puerto de origen: " + recibo.getPort());

            // Modificar el objeto antes de enviarlo
            tenista.setApellido("Karlovic");
            tenista.setAltura(208);
            System.out.println("Envío el objeto: " + tenista.getApellido()+" "+tenista.getAltura());

            // Convertir el objeto modificado a bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tenista);
            oos.flush();
            byte bufferEnvio[] = baos.toByteArray();
            oos.close();
            baos.close();

            // Enviar el objeto modificado de vuelta al cliente
            DatagramPacket envio = new DatagramPacket(bufferEnvio, bufferEnvio.length, recibo.getAddress(), recibo.getPort());
            socket.send(envio);

            System.out.println("Fin del servidor");
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}