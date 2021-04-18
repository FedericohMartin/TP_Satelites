package main;

public class TemperaturaReply extends ClimaReply {

	static protected int ultimo_id = 400;

	public TemperaturaReply(String idOperadorOrigen, String idOperadorDestino, String contenido) {

		super(idOperadorOrigen, idOperadorDestino, contenido);

		ultimo_id++;
		this.esRequest = false;
		this.contenido = contenido;
	}
}
