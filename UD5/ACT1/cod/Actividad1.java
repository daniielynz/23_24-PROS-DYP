package ACT1;

import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;

public class Actividad1 {
    public static void main(String[] args) {
        // Obtener el proveedor SUN
        Provider sunProvider = Security.getProvider("SUN");

        if (sunProvider != null) {
            Enumeration<Object> keys = sunProvider.keys();

            System.out.println("** Proveedor " + sunProvider.getName() + ", versión " + sunProvider.getVersion() + " **");
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                if (key.startsWith("MessageDigest.")) {
                	String resultado = key.substring(key.indexOf(".")).trim();
                    System.out.println("\tNombre del algoritmo: \"" +resultado+ "\"");
                }
            }
        } 
    }
}

