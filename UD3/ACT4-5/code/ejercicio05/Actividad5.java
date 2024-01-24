package ejercicio05;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Actividad5 {
	
	public void main(String[] args) {
		try {
			URL url = new URL("www.vitoria-gasteiz.org");//Creamos la url 
			URLConnection con = url.openConnection();//Creamos la conexión
			visualizarConexion(con);//Llamamos a la función para ver los métodos
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	private void visualizarConexion(URLConnection urlConection) {
		System.out.println("Conexión con " + urlConection.getURL().getHost());
		System.out.println("==========================");
		System.out.println("\t"+"Método toString(): " + urlConection.toString());
		System.out.println("\t"+"Método getDate(): " + urlConection.getDate());
		System.out.println("\t"+"Método getContentType(): " + urlConection.getContentType());
		System.out.println();
		
		System.out.println("\t"+"Campos Cabecera con getHeaderField:");
		System.out.println("==========================");
		System.out.println("\t"+"Línea 1: " + urlConection.getHeaderField(0));
		System.out.println("\t"+"Línea 2: " + urlConection.getHeaderField(1));
		System.out.println("\t"+"Línea 3: " + urlConection.getHeaderField(2));
		System.out.println("\t"+"Línea 4: " + urlConection.getHeaderField(3));
		System.out.println("\t"+"Línea 5: " + urlConection.getHeaderField(4));
		
		System.out.println();
		
		System.out.println("Campos Cabecera con getHeaderFields:");
		System.out.println("==========================");
		System.out.println("\t"+"Keep-Alive: " + urlConection.getHeaderField("Keep-Alive"));
		System.out.println("\t"+"null: " + urlConection.getHeaderField(null));
		System.out.println("\t"+"Server: " + urlConection.getHeaderField("Server"));
		System.out.println("\t"+"Connection: " + urlConection.getHeaderField("Connection"));
		System.out.println("\t"+"Content-Length: " + urlConection.getHeaderField("Content-Length"));
		System.out.println("\t"+"Date: " + urlConection.getHeaderField("Date"));
		System.out.println("\t"+"Content-Type: " + urlConection.getHeaderField("Content-Type"));
		System.out.println("\t"+"Location: " + urlConection.getHeaderField("Location"));
	}
}
