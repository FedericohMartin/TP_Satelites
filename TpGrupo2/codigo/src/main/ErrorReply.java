package main;

public class ErrorReply extends Reply {
	private String contenido;

	public ErrorReply(String idOperadorOrigen, String idOperadorDestino, String contenido) {
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
