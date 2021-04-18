package main;

public class PresionReply extends ClimaReply{
	static protected int ultimo_id = 400;

	public PresionReply(String idOperadorOrigen, String idOperadorDestino, String contenido) {
		super(idOperadorOrigen, idOperadorDestino, contenido);
		ultimo_id++;
		this.esRequest = false;
		this.contenido = contenido;
	}
}
