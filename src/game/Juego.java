package game;

import data.Datos;
import gui.Ventana;
import main.Player;

public class Juego {
	public static final int MOVER_ABAJO = 2;
	public static final int MOVER_IZQUIERDA = 4;
	public static final int MOVER_DERECHA = 6;
	public static final int MOVER_ARRIBA = 8;
	
	private int puntaje;
	private boolean termino;
	private Ventana miVentana;
	private Grilla grillaPrincipal;
	private Datos datos;
	private Player miJugador;
	private int bestScore;
	
	public Juego() {
		this.miJugador = new Player();
		this.termino = false;
		this.puntaje = 0;
		this.miVentana = new Ventana(this);
		this.grillaPrincipal = new Grilla(this);
		
		this.datos = new Datos(this);
		this.datos.cargarInformacion();
	}
	
	/**
	 * Permite mover las piezas del juego.
	 * @param operacion un entero que reprecenta los movimientos.
	 */
	public synchronized void operar(int operacion) {
		if(!termino)
			grillaPrincipal.mover(operacion);
	}
	
	/**
	 * Cambia graficamente la pieza p.
	 * @param p la pieza.
	 */
	public void cambiarPieza(Pieza p) {
		miVentana.cambiarPieza(p.getPiezaGrafica(), p.getFila(), p.getColumna());
	}
	
	/**
	 * Suma al puntaje el valor pasado por parametro.
	 * @param p un entero.
	 */
	public void addPuntaje(int p) {
		puntaje += p;
	}
	
	/**
	 * Indica que termino el juego
	 */
	public void termino() {
		termino = true;
		System.out.println("Fin del juego");
	}
	
	/**
	 * Incrementa el puntaje.
	 * @param rta
	 */
	public void incrementarPuntaje(int rta) {
		puntaje += rta;
		miVentana.actualizarPuntaje(puntaje);
	}
	
	/**
	 * Retorna el jugador.
	 * @return el jugador.
	 */
	public Player getJugador() {
		return miJugador;
	}
	
	/**
	 * Setea el jugador.
	 * @param jugador
	 */
	public void setJugador(Player jugador) {
		this.miJugador = jugador;
	}
	
	/**
	 * Guarda el mayor record
	 */
	public void salirDelJuego() {
		if(miJugador.getBestScore() < puntaje)
			miJugador.setBestScore(puntaje);
		datos.guardarInformacion();
	}
	
	/**
	 * Setea el record mas alto.
	 * @param bestScore el record mas alto.
	 */
	public void addBestScore(int bestScore) {
		this.bestScore = bestScore;
		miVentana.actualizarBestScore(this.bestScore);
	}
}
