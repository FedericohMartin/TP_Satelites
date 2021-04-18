package main;

import java.util.ArrayList;
import java.util.List;

public class RedSatelital {

	private List<Operador> operadores;

	public void addOperador(Operador node) {
		if (operadores == null) {
			operadores = new ArrayList<>();
		}
		operadores.add(node);
	}

	public List<Operador> getOperadors() {
		return operadores;
	}

	
	public Operador getOperador(String idOperador) {
		for (Operador operador : operadores) {
			if (operador.idOperador.equalsIgnoreCase(idOperador)) {
				return operador;
			}
		}
		
		return null;
		
	}
	
	
	@Override
	public String toString() {
		return "Red Satelital [operadores=" + operadores + "]";
	}

//Busco en el grafo el operador que le paso y borro lo que contiene su consola
	public void inicializarConsola(String nombreOper) {
		for (Operador operador : this.operadores) {
			if (operador.idOperador.equalsIgnoreCase(nombreOper)) {
				operador.consola.borrarConsola();
				System.out.println("Se borro la consola de  " + nombreOper);

			}
		}
	}
	
	
	public void reinicializarConsolas() {
		for (Operador operador : this.operadores) {
				operador.consola.borrarConsola();
				System.out.println("Se borro la consola de  " + operador.getID());
		}
	}

//Busco en el grafo el operador que quiere enviar el mensaje
//
	public void enviarMensaje(Mensaje mensaje) {
		for (Operador operador : operadores) {
			if (operador.idOperador.equalsIgnoreCase(mensaje.idOperadorOrigen)) {
				operador.enviar(mensaje);
			}
		}
	}

	public ClimaReply getClima(ClimaRequest mensaje) {

		// TODO:
		// Recorrer grafo buscando Operador = Mensaje.idOperadorOrigen
		// Una vez encontrado, hacer operador.enviar(mensaje)

		return null;

	}

	public void actualizarMediciones() {
		
		for (Operador operador : operadores) {
			
			if(operador instanceof SateliteMetereologico) {
				
				((SateliteMetereologico) operador).actualizarMedicion();
			}
		}
			
		
	}
}