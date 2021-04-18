package main;

import java.util.ArrayList;
import java.util.List;

public class Estacion extends Operador {

	public Estacion(String idOperador) {
		this.idOperador = idOperador;
		this.consola = new Consola();
	}

	@Override
	public String getID() {
		return this.idOperador;
	}

	@Override
	public List<Conexion> getConexiones() {
		return this.conexiones;
	}

	@Override
	public void agregarConexion(Conexion conexion) {
		if (this.conexiones == null) {
			this.conexiones = new ArrayList<>();
		}
		this.conexiones.add(conexion);

	}

	@Override
	public void actualizarConexion(Operador operadorDestino, boolean estado) {
		// Buscar la conexion existente y actualizar su estado
		for (Conexion conexion : conexiones) {
			if (conexion.getDestino().idOperador.equalsIgnoreCase(operadorDestino.idOperador)) {

				conexion.setActiva(estado);
			}
		}

		// Buscar la conexion reciproca y actualizar su estado
		for (Conexion conexion : operadorDestino.conexiones) {
			if (conexion.getDestino().idOperador.equalsIgnoreCase(this.idOperador)) {
				conexion.setActiva(estado);

			}
		}

	}

	@Override
	public void recibir(Mensaje mensaje) {

		// System.out.println("Estoy en RECIBIR de:" + this.idOperador + " id:" +
		// mensaje.id);

		// Si el mensaje es para mi
		if (mensaje.idOperadorDestino.equalsIgnoreCase(this.idOperador)) {
			this.consola.agregarMensaje(mensaje);
			// Si fue un request, respondo
			if (mensaje.esRequest) {
				for (Conexion conexion : conexiones) {
					if (conexion.getDestino().idOperador.equalsIgnoreCase(mensaje.idOperadorOrigen)) {

						double latenciaAux = (conexion.getDistancia() / 300000) * 2;
						// System.out.println("La latencia da:" + latenciaAux);

						String contenidoAux = "Latencia: " + latenciaAux;

						PingReply respuesta = new PingReply(this.idOperador, mensaje.idOperadorOrigen, contenidoAux);

						this.enviar(respuesta);

					}
				}

			}

		}

	}

	@Override
	public void enviar(Mensaje mensaje) {

		boolean encontrado = false;
		// System.out.println("Estoy en el enviar con el mensaje: " + mensaje.id +
		// mensaje.idOperadorOrigen + mensaje.idOperadorDestino);

		for (Conexion conexion : conexiones) {
			if (mensaje.idOperadorDestino.equalsIgnoreCase(conexion.getDestino().idOperador)) {
				encontrado = true;
			}

			if (conexion.isActiva()) {
				 System.out.println("ESTACION - Enviando Mensaje Desde:" + this.getID() + " hasta: " + conexion.getDestino().getID());
				this.consola.agregarMensaje(mensaje);

				conexion.getDestino().recibir(mensaje);
			} else {
				String msjAux = "El Satelite: " + mensaje.idOperadorDestino
						+ "Está fuera del área de cobertura en el momento";
				ErrorReply error = new ErrorReply(this.idOperador, mensaje.idOperadorDestino, msjAux);
				this.consola.agregarMensaje(error);
			}

		}
		if (!encontrado) {
			String msjAux = "No hay conexión con el satelite de comunicación: " + mensaje.idOperadorDestino;
			;
			ErrorReply error = new ErrorReply(this.idOperador, mensaje.idOperadorDestino, msjAux);
			this.consola.agregarMensaje(error);

		}
	}

	public void reenviar(Mensaje mensaje) {
// No está claro en el enunciado si se puede reenviar o no
	}

	@Override
	public String toString() {
		return "Estacion [ID=" + this.idOperador + "]\n - Conexiones: [ " + this.conexiones + "]\n";
	}

	@Override
	public void imprimirConsola() {
		System.out.println("Consola de: " + this.idOperador);
		this.consola.imprimirConsola();

	}

}
