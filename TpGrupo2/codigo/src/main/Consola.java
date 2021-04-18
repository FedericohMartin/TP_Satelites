package main;

import java.util.ArrayList;
import java.util.List;

public class Consola {

	private List<Mensaje> mensajes; // mensajes 

	public Consola() {
		this.mensajes = new ArrayList<Mensaje>();
	}

	public void borrarConsola() {
		this.mensajes.clear();
	}

	public void agregarMensaje(Mensaje msj) {
		this.mensajes.add(msj);

	}

	public void imprimirConsola() {

		for (Mensaje mensaje : mensajes) {
			
			if(mensaje instanceof Reply) {
				
				System.out.println("Tipo: " + mensaje.getClass() + " - ID Origen: " + mensaje.idOperadorOrigen + " - ID Destino: " + mensaje.idOperadorDestino + " Contenido: " + ((Reply) mensaje).contenido);
			
			} else {
				
				System.out.println("Tipo: " + mensaje.getClass() + " - ID Origen: " + mensaje.idOperadorOrigen + " - ID Destino: " + mensaje.idOperadorDestino);
			}

		}
	}
}
