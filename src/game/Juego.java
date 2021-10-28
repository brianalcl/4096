package game;

import java.io.IOException;

import data.Datos;
import factory.FabricaGUI;
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
	
	public Juego(Ventana v, FabricaGUI fabrica) {
		this.miVentana = v;
		this.miJugador = new Player();
		this.datos = new Datos(this);
		
		try {
			this.datos.cargarInformacion();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		this.grillaPrincipal = new Grilla(this, fabrica);
		
		this.termino = false;
		this.puntaje = 0;
		this.bestScore = miJugador.getBestScore();
		miVentana.actualizarPuntaje(puntaje);
		miVentana.actualizarBestScore(bestScore);
		
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
		miVentana.cambiarPieza(p.getRepPieza(), p.getFila(), p.getColumna());
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
		guardarRecord();
		miVentana.termino();
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
	public void guardarRecord() {
		if(miJugador.getBestScore() < puntaje)
			miJugador.setBestScore(puntaje);
		try {
			datos.guardarInformacion();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Setea el record mas alto.
	 * @param bestScore el record mas alto.
	 */
	public void addBestScore(int bestScore) {
		this.bestScore = bestScore;
		miVentana.actualizarBestScore(this.bestScore);
	}
	
	/**
	 * Restaura el juego.
	 */
	public void restaurar() {
		try {
			datos.cargarInformacion();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		this.termino = false;
		this.puntaje = 0;
		this.bestScore = miJugador.getBestScore();
		miVentana.actualizarPuntaje(puntaje);
		miVentana.actualizarBestScore(bestScore);
		grillaPrincipal.restaurar();
	}

	/**
	 * Actualiza la fabrica
	 * @param fabrica
	 */
	public void setFabrica(FabricaGUI fabrica) {
		grillaPrincipal.setFabrica(fabrica);
	}
}
