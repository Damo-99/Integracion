package ar.edu.utn.java.inicial.modelo;

public class EnviadorDeCorreos {

	public void enviarCorreo (CorreoElectronico correo) {
		String mensajeDelEnviador = String.format("Enviando correo %s con asunto: %s", correo.getDireccionDeCorreo(), correo.getAsunto());
		System.out.println(mensajeDelEnviador);
	}
}
