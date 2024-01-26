package ACT2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.nio.charset.StandardCharsets;

public class Actividad2 {
    public static void main(String[] args) {
        try {
            // Leer la clave pública desde el archivo Clave.publica
            byte[] publicKeyBytes = Files.readAllBytes(Paths.get("Clave.publica"));
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) certFactory.generateCertificate(
                    new java.io.ByteArrayInputStream(publicKeyBytes));
            PublicKey publicKey = cert.getPublicKey();

            // Leer la firma desde el archivo FICHERO.FIRMA
            byte[] signatureBytes = Files.readAllBytes(Paths.get("FICHERO.FIRMA"));

            // Inicializar el objeto Signature con la clave pública y el algoritmo SHA1withDSA
            Signature signature = Signature.getInstance("SHA1withDSA");
            signature.initVerify(publicKey);

            // Leer los datos desde el archivo FICHERO.DAT
            byte[] data = Files.readAllBytes(Paths.get("FICHERO.DAT"));

            // Actualizar los datos de la firma
            signature.update(data);

            // Verificar la firma
            boolean verified = signature.verify(signatureBytes);

            // Comprobar la verificación de los datos
            if (verified) {
                System.out.println("LOS DATOS SE CORRESPONDEN CON SU FIRMA");
            } else {
                System.out.println("LOS DATOS NO SE CORRESPONDEN CON SU FIRMA");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
