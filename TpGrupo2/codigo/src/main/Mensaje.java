package main;

public abstract class Mensaje {
	protected static int idGlobal=0;
	protected int id;
	protected String idOperadorOrigen;
	protected String idOperadorDestino;
	protected boolean esRequest;
	protected String contenido;
	
	public Mensaje(String idOrigen, String idDestino) {
		idGlobal++;
		id = idGlobal;
		this.idOperadorOrigen = idOrigen;
		this.idOperadorDestino = idDestino;
	}

	public abstract int getId();

	public abstract String getIdOperadorOrigen();

	public abstract void setIdOperadorOrigen(String idOperadorOrigen);

	public abstract String getIdOperadorDestino();

	public abstract void setIdOperadorDestino(String idOperadorDestino);

	public abstract boolean isEsRequest();

	public abstract void setEsRequest(boolean esRequest);
	


}
