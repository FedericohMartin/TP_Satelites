package main;

public class ClimaReply extends Reply {

	private float temperatura;
	private float humedad;
	private float nubosidad;
	private float presion;

	public ClimaReply(String idOperadorOrigen, String idOperadorDestino, String contenido) {
		super(idOperadorOrigen, idOperadorDestino, contenido);
		this.esRequest = false;

		this.temperatura = 0;
		this.humedad = 0;
		this.nubosidad = 0;
		this.presion = 0;

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

	@Override
	public String toString() {
		return "Temperatura=" + this.getTemperatura() + "Humedad=" + getHumedad() + "Presion=" + getPresion()
				+ "Nubosidad=" + getNubosidad();
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
