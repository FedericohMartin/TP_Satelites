package main;

public class Reply extends Mensaje {
	protected String contenido;
	
	public Reply(String idOperadorOrigen, String idOperadorDestino, String contenido) {
		super(idOperadorOrigen, idOperadorDestino);
		this.esRequest = false;
		this.contenido = contenido;
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getIdOperadorOrigen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIdOperadorOrigen(String idOperadorOrigen) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getIdOperadorDestino() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIdOperadorDestino(String idOperadorDestino) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEsRequest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEsRequest(boolean esRequest) {
		// TODO Auto-generated method stub

	}

}
