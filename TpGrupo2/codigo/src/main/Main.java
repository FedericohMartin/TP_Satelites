package main;

public class Main {

	public static RedSatelital getRed() {
		// Satelites C1, C2, C3 = Orbita GEO
		SateliteComunicaciones c1 = new SateliteComunicaciones("C1");
		SateliteComunicaciones c2 = new SateliteComunicaciones("C2");
		SateliteComunicaciones c3 = new SateliteComunicaciones("C3");

		// Satelites
		// M1 = Orbita Baja (LEO)
		SateliteMetereologico m1 = new SateliteMetereologico("M1");
		// M2 = Orbita Media (MEO)
		SateliteMetereologico m2 = new SateliteMetereologico("M2");
		// M3 = Orbita Baja (LEO)
		SateliteMetereologico m3 = new SateliteMetereologico("M3");
		// M4 = Orbita Media (MEO)
		SateliteMetereologico m4 = new SateliteMetereologico("M4");

		// Estaciones terrestres

		Estacion e1 = new Estacion("E1");
		Estacion e2 = new Estacion("E2");
		Estacion e3 = new Estacion("E3");
		Estacion e4 = new Estacion("E4");

		c1.agregarConexion(new Conexion(c1, c2, 4000, true));
		c1.agregarConexion(new Conexion(c1, e1, 36000, true));
		c1.agregarConexion(new Conexion(c1, e2, 36000, true));

		c2.agregarConexion(new Conexion(c2, c1, 4000, true));
		c2.agregarConexion(new Conexion(c2, c3, 3000, true));
		c2.agregarConexion(new Conexion(c2, e2, 36000, true));
		c2.agregarConexion(new Conexion(c2, e3, 36000, true));

		c3.agregarConexion(new Conexion(c3, c2, 3000, true));
		c3.agregarConexion(new Conexion(c3, e4, 36000, true));

		m1.agregarConexion(new Conexion(m1, e1, 2000, true));
		// Esta es la conexion que luego activo en inciso f
		m1.agregarConexion(new Conexion(m1, e4, 2000, false));

		m2.agregarConexion(new Conexion(m2, e2, 10000, true));

		m3.agregarConexion(new Conexion(m3, e2, 1500, true));
		m3.agregarConexion(new Conexion(m3, e3, 1500, true));

		m4.agregarConexion(new Conexion(m4, e3, 20000, true));
		m4.agregarConexion(new Conexion(m4, e4, 20000, true));

		e1.agregarConexion(new Conexion(e1, e2, 300, true));
		e1.agregarConexion(new Conexion(e1, m1, 2000, true));
		e1.agregarConexion(new Conexion(e1, c1, 36000, true));

		e2.agregarConexion(new Conexion(e2, e1, 300, true));
		e2.agregarConexion(new Conexion(e2, c1, 36000, true));
		e2.agregarConexion(new Conexion(e2, m2, 10000, true));
		e2.agregarConexion(new Conexion(e2, m3, 1500, true));

		e3.agregarConexion(new Conexion(e3, m3, 1500, true));
		e3.agregarConexion(new Conexion(e3, c2, 36000, true));
		e3.agregarConexion(new Conexion(e3, m4, 20000, true));

		e4.agregarConexion(new Conexion(e4, m4, 20000, true));
		e4.agregarConexion(new Conexion(e4, c3, 36000, true));
		// Esta es la conexion que luego activo en inciso f
		e4.agregarConexion(new Conexion(e4, m1, 2000, false));

		RedSatelital graph = new RedSatelital();
		graph.addOperador(c1);
		graph.addOperador(c2);
		graph.addOperador(c3);

		graph.addOperador(m1);
		graph.addOperador(m2);
		graph.addOperador(m3);
		graph.addOperador(m4);

		graph.addOperador(e1);
		graph.addOperador(e2);
		graph.addOperador(e3);
		graph.addOperador(e4);

		return graph;
	}

	public static void main(String[] args) {
		System.out.println("---Inicio---");

		// Creo grafo no dirigido
		RedSatelital redSatelital = getRed();
		System.out.println(redSatelital);

		System.out.println("*************** Ejercicio 2 ***************");
		
		redSatelital.reinicializarConsolas();
		
		System.out.println("*************** Ejercicio 3 ***************");
		PingRequest preq3 = new PingRequest("E1", "C1");
		redSatelital.enviarMensaje(preq3);
		redSatelital.getOperador("E1").imprimirConsola();
		redSatelital.getOperador("C1").imprimirConsola();

		System.out.println("*************** Ejercicio 4 ***************");

		PingRequest preq4 = new PingRequest("E2", "E1");
		redSatelital.enviarMensaje(preq4);

		redSatelital.getOperador("E2").imprimirConsola();
		redSatelital.getOperador("E1").imprimirConsola();

		System.out.println("*************** Ejercicio 5 ***************");

		PingRequest preq5 = new PingRequest("E3", "M4");
		redSatelital.enviarMensaje(preq5);

		redSatelital.getOperador("E3").imprimirConsola();
		redSatelital.getOperador("M4").imprimirConsola();

		System.out.println("*************** Ejercicio 6 ***************");

		PingRequest preq6 = new PingRequest("E3", "M2");
		redSatelital.enviarMensaje(preq6);

		redSatelital.getOperador("E3").imprimirConsola();
		redSatelital.getOperador("M2").imprimirConsola();

		System.out.println("*************** Ejercicio 7 ***************");

		PingRequest preq7 = new PingRequest("E4", "C2");
		redSatelital.enviarMensaje(preq7);

		redSatelital.getOperador("E4").imprimirConsola();
		redSatelital.getOperador("C2").imprimirConsola();

		System.out.println("*************** Puntos Grupo 2 ***************");
		System.out.println("*************** Punto a ***************");
		redSatelital.inicializarConsola("M1");
		redSatelital.inicializarConsola("M2");
		redSatelital.inicializarConsola("M3");
		redSatelital.inicializarConsola("M4");

		System.out.println("*************** Punto b ***************");
		
		Operador satelite = redSatelital.getOperador("M1");
		System.out.println("presion antes de simular: " + ((SateliteMetereologico) satelite).getPresion());
		redSatelital.actualizarMediciones();
		System.out.println("presion despues de simular: " + ((SateliteMetereologico) satelite).getPresion());

		System.out.println("*************** Punto c ***************");

		redSatelital.inicializarConsola("E2");
		redSatelital.inicializarConsola("M3");

		ClimaTodoRequest cr1 = new ClimaTodoRequest("E2", "M3");
		redSatelital.enviarMensaje(cr1);
		redSatelital.getOperador("E2").imprimirConsola();
		redSatelital.getOperador("M3").imprimirConsola();

		System.out.println("*************** Punto d ***************");

		redSatelital.inicializarConsola("E3");
		redSatelital.inicializarConsola("M3");

		TemperaturaRequest cr2 = new TemperaturaRequest("E3", "M3");
		redSatelital.enviarMensaje(cr2);
		redSatelital.getOperador("E3").imprimirConsola();
		redSatelital.getOperador("M3").imprimirConsola();

		System.out.println("*************** Punto e ***************");

		redSatelital.inicializarConsola("E4");
		redSatelital.inicializarConsola("M1");

		// TODO: Terminar
		// PresionRequest cr3 = new PresionRequest("E4", "M1");
		// redSatelital.enviarMensaje(cr3);
		redSatelital.getOperador("E4").imprimirConsola();
		redSatelital.getOperador("M1").imprimirConsola();

		System.out.println("*************** Punto f ***************");
		redSatelital.inicializarConsola("E4");
		redSatelital.inicializarConsola("M1");
		// desactivo conexion
		redSatelital.getOperador("E1").actualizarConexion(redSatelital.getOperador("M1"), false);
		// activo conexion
		redSatelital.getOperador("E4").actualizarConexion(redSatelital.getOperador("M1"), true);

		PresionRequest pr1 = new PresionRequest("E4", "M1");
		redSatelital.enviarMensaje(pr1);

		redSatelital.getOperador("E4").imprimirConsola();
		redSatelital.getOperador("M1").imprimirConsola();
	}
}