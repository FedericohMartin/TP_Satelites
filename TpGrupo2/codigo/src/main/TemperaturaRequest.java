package main;

public class TemperaturaRequest extends ClimaRequest {

	static protected int ultimo_id = 500;

	public TemperaturaRequest(String idOperadorOrigen, String idOperadorDestino) {

		super(idOperadorOrigen, idOperadorDestino);

		ultimo_id++;
		this.esRequest = true;
		this.contenido = "";

	}

}
