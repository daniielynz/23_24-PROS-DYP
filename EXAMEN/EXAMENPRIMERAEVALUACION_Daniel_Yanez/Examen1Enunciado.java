package examen;

public class Examen1Enunciado {
	
	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();	
		
		String comando = "/usr/bin/flatpak run --branch=stable --arch=x86_64 --command=/app/bin/chrome --file-forwarding com.google.Chrome @@u %U @@";
				
		Process p;
		
		try {
			
			p = r.exec( comando );
		
		}
		catch (Exception e) {
			System.out.println("Error en: " + comando);
			e.printStackTrace();
		}
	}
}

