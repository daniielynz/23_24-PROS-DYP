package pruebas;

import org.apache.commons.net.ftp.FTPClient;

public class ClienteFTP2 {

    public static void main(String[] args) {
        String server = "172.20.132.133"; // Reemplaza con la dirección IP del servidor FTP
        int port = 21; // Puerto predeterminado para FTP
        String user = "dinux";
        String pass = "dm2";
        String apellido = "dani"; // Reemplaza con tu apellido

        FTPClient ftpClient = new FTPClient();

        try {
            // Conexión al servidor FTP
            System.out.println("Nos conectamos a " + server);
            ftpClient.connect(server, port);
            if (ftpClient.login(user, pass)) {
                System.out.println("Login correcto");

                // Imprimir el directorio actual
                System.out.println("Directorio actual: " + ftpClient.printWorkingDirectory());

                // Crear estructura de directorios
                if (crearDirectorios(ftpClient, "aplicacionweb" + apellido)) {
                    System.out.println("Directorios creados...");
                } else {
                    System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
                }

                // Logout
                if (ftpClient.logout()) {
                    System.out.println("Logout del servidor FTP....");
                } else {
                    System.out.println("Error al hacer logout");
                }

                // Desconexión
                ftpClient.disconnect();
                System.out.println("Desconectado...");
            } else {
                System.out.println("Login incorrecto...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean crearDirectorios(FTPClient ftpClient, String directorio) {
        try {
            ftpClient.makeDirectory(directorio);
            ftpClient.changeWorkingDirectory(directorio);
            
            // Crear subdirectorios
            ftpClient.makeDirectory("html");
            ftpClient.makeDirectory("imagenes");
            ftpClient.makeDirectory("css");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
