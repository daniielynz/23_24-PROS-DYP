package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2 {
    public static void main(String[] args) {
        // Comando para listar archivos en el directorio actual (Linux/Mac)
        String comando = "ls -al";
        
        ProcessBuilder processBuilder = new ProcessBuilder(comando.split(" "));
        processBuilder.redirectErrorStream(true);
        
        try {
            Process proceso = processBuilder.start();
            
            // Lee la salida del proceso
            InputStream is = proceso.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            
            // Espera a que el proceso termine y obtiene el código de salida
            int exitCode = proceso.waitFor();
            System.out.println("Valor de Salida: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

