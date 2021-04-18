package main;

import java.util.List;

public abstract class Operador {

	protected String idOperador;
	protected List<Conexion> conexiones;
	protected Consola consola;

	public abstract String getID();

	public abstract List<Conexion> getConexiones();

	public abstract void agregarConexion(Conexion conexion);

	public abstract void actualizarConexion(Operador operadorDestino, boolean estado);

	public abstract void imprimirConsola();

	public abstract void enviar(Mensaje mensaje);

	public abstract void recibir(Mensaje mensaje);

}