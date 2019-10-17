package ar.edu.utn.java.inicial.programa;

import java.util.ArrayList;

import ar.edu.utn.java.inicial.modelo.CorreoElectronico;
import ar.edu.utn.java.inicial.modelo.EnviadorDeCorreos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		
	 ArrayList<CorreoElectronico> misCorreos = new ArrayList<>();
		
		Path path = Paths.get("src/main/resources/emails.txt");
	    try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){
	 
	       
	      String currentLine = null;
	      while((currentLine = reader.readLine()) != null) {//while there is content on the current line
	    	  CorreoElectronico miCorreo = new CorreoElectronico();
	    	  String[] lista = currentLine.split(",");
	    	  miCorreo.setDireccionDeCorreo(lista[0]);
	    	  miCorreo.setAsunto(lista[1]);
	    	  misCorreos.add(miCorreo);
	        System.out.println(currentLine); // print the current line
	      }
	    }catch(IOException ex){
	      ex.printStackTrace(); //handle an exception here
	    }
	    
	    EnviadorDeCorreos enviador = new EnviadorDeCorreos();
	    for (CorreoElectronico miCorreo : misCorreos) {
	    	enviador.enviarCorreo(miCorreo);
	    	
	    }

	}

}

//	CorreoElectronico correo1 = new CorreoElectronico();
//	correo1.setAsunto("Busqueda laboral");
//correo1.setDireccionDeCorreo("blabla99@hotmail.com");

//EnviadorDeCorreos enviador1 = new EnviadorDeCorreos();
//enviador1.enviarCorreo(correo1);