package main;

public class Conexion {

	private Operador origen;
	private Operador destino;
	private double distancia;
	private boolean activa;

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public Conexion(Operador origin, Operador destination, double distance, boolean activa) {
		this.origen = origin;
		this.destino = destination;
		this.distancia = distance;
		this.activa = activa;
	}

	public Operador getOrigen() {
		return origen;
	}

	public void setOrigen(Operador origen) {
		this.origen = origen;
	}

	public Operador getDestino() {
		return destino;
	}

	public void setDestino(Operador destino) {
		this.destino = destino;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "\n Conexion [origen=" + origen.getID() + ", destino=" + destino.getID() + ", distancia="
				+ this.distancia + "]";
	}

}
