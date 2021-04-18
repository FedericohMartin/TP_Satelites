package main;

import java.util.ArrayList;
import java.util.List;

public class SateliteMetereologico extends Satelite {

	private float temperatura;
	private float humedad;
	private float nubosidad;
	private float presion;

	public SateliteMetereologico(String idOperador) {
		this.idOperador = idOperador;
		this.consola = new Consola();
		this.actualizarMedicion();

	}

	@Override
	public void recibir(Mensaje mensaje) {

		String contenidoAux = "";
		//System.out.println("Estoy en RECIBIR de:" + this.idOperador + " id:" + mensaje.id);

		// Si el mensaje es para mi
		if (mensaje.idOperadorDestino.equalsIgnoreCase(this.idOperador)) {
			this.consola.agregarMensaje(mensaje);
			// Si fue un request, respondo
			if (mensaje.esRequest) {
				for (Conexion conexion : conexiones) {
					if (conexion.getDestino().idOperador.equalsIgnoreCase(mensaje.idOperadorOrigen)) {

						if (mensaje instanceof PingRequest) {

							double latenciaAux = (conexion.getDistancia() / 300000) * 2;
							//System.out.println("La latencia da:" + latenciaAux);

							contenidoAux = "Latencia: " + latenciaAux;

							PingReply respuesta = new PingReply(this.idOperador, mensaje.idOperadorOrigen,
									contenidoAux);

							this.enviar(respuesta);

						} else if (mensaje instanceof ClimaRequest) {
							// aca se que es un request de Clima, pero no se cual especificamente, por eso
							// agrego estos IFs

							if (mensaje instanceof ClimaTodoRequest) {
								// Es un request de Todas las variables
								contenidoAux = "Temperatura: " + this.temperatura + " - Humedad: " + this.humedad
										+ " - Nubosidad: " + this.nubosidad + " - Presion" + this.presion;

							} else if (mensaje instanceof TemperaturaRequest) {
								// Es un request solo de temperatura
								contenidoAux = "Temperatura: " + this.temperatura;
							} else if (mensaje instanceof HumedadRequest) {
								// Es un request solo de humedad
								contenidoAux = "Humedad: " + this.humedad;
							} else if (mensaje instanceof NubosidadRequest) {
								// Es un request solo de nubosidad
								contenidoAux = "Nubosidad: " + this.nubosidad;
							} else if (mensaje instanceof PresionRequest) {
								// Es un request solo de presion
								contenidoAux = "Presion: " + this.presion;
							}

							// a todos les respondo con ClimaReply
							ClimaReply respuesta = new ClimaReply(this.idOperador, mensaje.idOperadorOrigen,
									contenidoAux);

							this.enviar(respuesta);

						}

					}
				}

			} else {
				// SI es una respuesta, solo lo agrego a mi consola.
				// ya lo hice mas arriba.
			}

		} else {
			// Si el mensaje es para otro, llamar a ENVIAR, este sería el reenviar
			//System.out.println("aca entra al enviar porque no es para mi el msj");
			//this.enviar(mensaje);
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
		return "Satelite Metereologico [ID=" + this.idOperador + "]\n - Conexiones: [ " + this.conexiones + "]\n";
	}

	@Override
	public void imprimirConsola() {
		System.out.println("Consola de: " + this.idOperador);
		this.consola.imprimirConsola();

	}

	public void obtenerMedicion() {

	}

	@Override
	public void enviar(Mensaje mensaje) {

		//System.out.println("Estoy en el enviar con el mensaje: " + mensaje.id + mensaje.idOperadorOrigen + mensaje.idOperadorDestino);

		this.consola.agregarMensaje(mensaje);
		
		for (Conexion conexion : conexiones) {

			//System.out.println("SAT MET - Enviando Mensaje Desde:" + this.getID() + " hasta: " + conexion.getDestino().getID());
			
			conexion.getDestino().recibir(mensaje);
		}
	}

	public void actualizarMedicion() {
		this.temperatura = (float) (Math.random() * 25);
		this.humedad = (float) (Math.random() * 100);
		this.nubosidad = (float) (Math.random() * 100);
		this.presion = (float) (Math.random() * 1500);
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public float getHumedad() {
		return humedad;
	}

	public void setHumedad(float humedad) {
		this.humedad = humedad;
	}

	public float getNubosidad() {
		return nubosidad;
	}

	public void setNubosidad(float nubosidad) {
		this.nubosidad = nubosidad;
	}

	public float getPresion() {
		return presion;
	}

	public void setPresion(float presion) {
		this.presion = presion;
	}

}
