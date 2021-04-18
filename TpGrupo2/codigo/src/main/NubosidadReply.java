package main;

public class NubosidadReply extends ClimaReply {

	static protected int ultimo_id = 4000;

	public NubosidadReply(String idOperadorOrigen, String idOperadorDestino, String contenido) {
		super(idOperadorOrigen, idOperadorDestino, contenido);
		ultimo_id++;
		this.esRequest = false;
		this.contenido = contenido;
	}
}
