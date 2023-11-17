import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ejercicio1 {
    public static void main(String[] args) {
        String dominio = "www.spotify.com";

        try {
            InetAddress[] direcciones = InetAddress.getAllByName(dominio);

            System.out.println("Direcciones asociadas a Spotify:");
            for (InetAddress direccion : direcciones) {
                System.out.println(dominio + "/" + direccion.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("No se pudo resolver el dominio: " + dominio);
            e.printStackTrace();
        }
    }
}
