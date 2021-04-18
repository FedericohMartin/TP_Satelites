package main;

public class ClimaRequest extends Mensaje {
	static protected int ultimo_id = 300;
	// encontenido pueden ir estas opciones
	private double temperatura;
	private double humedad;
	private double nubosidad;
	private double presion;

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getHumedad() {
		return humedad;
	}

	public void setHumedad(double humedad) {
		this.humedad = humedad;
	}

	public double getNubosidad() {
		return nubosidad;
	}

	public void setNubosidad(double nubosidad) {
		this.nubosidad = nubosidad;
	}

	public double getPresion() {
		return presion;
	}

	public void setPresion(double presion) {
		this.presion = presion;
	}

	public ClimaRequest(String idOperadorOrigen, String idOperadorDestino) {
		super(idOperadorDestino, idOperadorDestino);

		this.esRequest = true;
		this.idOperadorOrigen = idOperadorOrigen;
		this.idOperadorDestino = idOperadorDestino;
		this.contenido = "";

		this.temperatura = 0;
		this.humedad = 0;
		this.nubosidad = 0;
		this.presion = 0;

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
