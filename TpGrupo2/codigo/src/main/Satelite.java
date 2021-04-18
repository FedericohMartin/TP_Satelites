package main;

import java.util.List;

public abstract class Satelite extends Operador {

	protected String Orbita;
	protected String Tipo;

	@Override
	public abstract void recibir(Mensaje mensaje);

	@Override
	public abstract void enviar(Mensaje mensaje);

	@Override
	public abstract void agregarConexion(Conexion conexion);

	@Override
	public abstract void actualizarConexion(Operador operadorDestino, boolean estado);

	@Override
	public abstract String getID();

	@Override
	public abstract List<Conexion> getConexiones();

}
