package main;

public class PingRequest extends Request {
	/*
	 * Atributos de msj static protected int id = 0; protected String
	 * idOperadorOrigen; protected String idOperadorDestino; protected String
	 * contenido;
	 */
	//
//PingRequest : solicitud de operación ping, no tiene contenido.

	public PingRequest(String idOperadorOrigen, String idOperadorDestino) {

		super(idOperadorOrigen, idOperadorDestino);
		this.esRequest = true;

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
