package ejercicio10;

import java.io.Serializable;

public class Tenista implements Serializable {
	
	private int altura;
	private String apellido;

	public Tenista(int altura, String apellido) {
		this.altura = altura;
		this.apellido = apellido;
	}
	
	
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}