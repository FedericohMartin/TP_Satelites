package main;

import java.util.ArrayList;
import java.util.List;

public class SateliteComunicaciones extends Satelite {

	public SateliteComunicaciones(String idOperador) {
		this.idOperador = idOperador;
		this.consola = new Consola();
	}

	@Override
	public void recibir(Mensaje mensaje) {
		// TODO Completar esto con condiciones TP pagina 4 / 5
		// System.out.println("Estoy en el recibir de:" + this.idOperador);
		// Agrego mensaje a consola
		if (mensaje.idOperadorDestino.equalsIgnoreCase(this.idOperador)) {
			this.consola.agregarMensaje(mensaje);
			if (mensaje.esRequest) {
				for (Conexion conexion : conexiones) {
					if (conexion.getDestino().idOperador.equalsIgnoreCase(mensaje.idOperadorOrigen)) {

						// Cálculo de la latencia : Se utilizará la distancia entre operadores en km
						// dividido por la velocidad de la luz
						// (300.000 km/seg) como medida de latencia. Representa el tiempo en segundos en
						// condiciones ideales
						// que tarda en viajar un mensaje ida y vuelta entre 2 operadores.
						if (mensaje instanceof PingRequest) {
							double latenciaAux = (conexion.getDistancia() / 300000) * 2;
							// System.out.println("La latencia da:" + latenciaAux);

							String contenidoAux = "Latencia: " + latenciaAux;

							PingReply respuesta = new PingReply(this.idOperador, mensaje.idOperadorOrigen,
									contenidoAux);

							this.enviar(respuesta);
						}
					}
				}
			}
		}
		else {
			// Si el mensaje es para otro, llamar a ENVIAR, seria el reenviar
			//System.out.println("aca entra al enviar porque no es para mi el msj");
			//this.enviar(mensaje);
		}
	}

	@Override
	public void enviar(Mensaje mensaje) {

		// System.out.println("Estoy en el enviar con el mensaje: " + mensaje.id +
		// mensaje.idOperadorOrigen + mensaje.idOperadorDestino);

		this.consola.agregarMensaje(mensaje);

		for (Conexion conexion : conexiones) {

			// System.out.println("ESTACION - Enviando Mensaje Desde:" + this.getID() + "
			// hasta: " + conexion.getDestino().getID());

			conexion.getDestino().recibir(mensaje);
		}
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
	public String getID() {
		return this.idOperador;
	}

	@Override
	public List<Conexion> getConexiones() {
		return this.conexiones;
	}

	@Override
	public String toString() {
		return "Satelite de Comunicaciones [ID=" + this.idOperador + "]\n - Conexiones: [ " + this.conexiones + "]\n";
	}

	@Override
	public void imprimirConsola() {
		System.out.println("Consola de: " + this.idOperador);
		this.consola.imprimirConsola();

	}

}
