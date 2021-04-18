package main;

public class PingReply extends Reply {
	private String contenido;

	// PingReply : respuesta de operación ping, tiene la latencia de la conexión
	// como contenido.

	// Cálculo de la latencia : Se utilizará la distancia entre operadores en km
	// dividido por la velocidad de la luz
	// (300.000 km/seg) como medida de latencia. Representa el tiempo en segundos en
	// condiciones ideales
	// que tarda en viajar un mensaje ida y vuelta entre 2 operadores.

	public PingReply(String idOperadorOrigen, String idOperadorDestino, String contenido) {

		super(idOperadorOrigen, idOperadorDestino, contenido);
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getIdOperadorOrigen() {
		return this.idOperadorOrigen;
	}

	@Override
	public void setIdOperadorOrigen(String idOperadorOrigen) {
		this.idOperadorOrigen = idOperadorOrigen;

	}

	@Override
	public String getIdOperadorDestino() {
		return this.idOperadorDestino;
	}

	@Override
	public void setIdOperadorDestino(String idOperadorDestino) {
		this.idOperadorDestino = idOperadorDestino;

	}

	@Override
	public boolean isEsRequest() {
		return this.esRequest;
	}

	@Override
	public void setEsRequest(boolean esRequest) {
		this.esRequest = esRequest;

	}

}
