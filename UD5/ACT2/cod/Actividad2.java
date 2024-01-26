package ACT2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Actividad2 {

	public static void main(String[] args) {
		// Abrimos los archivos en el try, para que se cierren solos
		try (
				// Clave publica
				FileInputStream fisPublica = new FileInputStream(new File("UD5/ACT2/Clave.publica"));

				// Fichero con la firma
				FileInputStream fisFirma = new FileInputStream(new File("UD5/ACT2/FICHERO.FIRMA"));
				) {

			// Leemos la clave publica y la ponemos en un buffer
			byte[] bufferPublica = new byte[fisPublica.available()];
			fisPublica.read(bufferPublica);

			// Ponemos la clave en formato x509
			X509EncodedKeySpec clavePublicaSpec = new X509EncodedKeySpec(bufferPublica);
			KeyFactory keyDSA = KeyFactory.getInstance("DSA");
			PublicKey clavePublicaKey = keyDSA.generatePublic(clavePublicaSpec);

			// Leemos la firma
			byte[] bufferFirma = new byte[fisFirma.available()];
			fisFirma.read(bufferFirma);

			// Verificamos la clave publcia con SHA1withDSA
			Signature signature = Signature.getInstance("SHA1withDSA");
			signature.initVerify(clavePublicaKey);

			// Leemos los datos
			// Fichero con la información
			BufferedInputStream bisDat = new BufferedInputStream(new FileInputStream(new File("UD5/ACT2/FICHERO.DAT")));
			byte[] bufferDatos = bisDat.readAllBytes();
			System.out.println(new String(bufferDatos));
			signature.update(bufferDatos);

			// Verificamos si los datos que tenemos y los que nos llegan son los mismos
			if (signature.verify(bufferFirma)) {
				System.out.println("LOS DATOS SE CORRESPONDEN CON SU FIRMA");
			} else {
				System.out.println("LOS DATOS NO SE CORRESPONDEN CON SU FIRMA");
			}

		} catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException
				| SignatureException e) {
			e.printStackTrace();
		}
	}
}