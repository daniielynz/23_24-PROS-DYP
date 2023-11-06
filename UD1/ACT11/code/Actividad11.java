package application;

public class Actividad11 {
	public static void main(String[] args){
		Runtime r=Runtime.getRuntime();
		String comando="java"; //Descomentar la línea para Linux 
		//String comando="CMD C/ DIR"; //Descomentar la línea para Windows
		try {
	            String claseAEjecutar = "application/Ejemplo2";
	            
	            // Crea un proceso para ejecutar el comando
	            ProcessBuilder builder = new ProcessBuilder(comando, claseAEjecutar);
	            
	            // Redirige la salida estándar y la salida de error al proceso actual
	            builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
	            builder.redirectError(ProcessBuilder.Redirect.INHERIT);
	            
	            // Ejecuta el proceso
	            Process proceso = builder.start();
	            
	            // Espera a que el proceso termine
	            int codigoSalida = proceso.waitFor();
			}
		catch (Exception e) {
			System.out.println("error en:"+comando);
			e.printStackTrace();
		}
	}
}