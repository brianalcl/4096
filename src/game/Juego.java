package game;

import gui.Ventana;

public class Juego {
	public static final int MOVER_ABAJO = 2;
	public static final int MOVER_IZQUIERDA = 4;
	public static final int MOVER_DERECHA = 6;
	public static final int MOVER_ARRIBA = 8;
	
	private int puntaje;
	private boolean termino;
	private Ventana miVentana;
	private Grilla grillaPrincipal;
	
	public Juego() {
		this.termino = false;
		this.puntaje = 0;
		this.miVentana = new Ventana(this);
		this.grillaPrincipal = new Grilla(this);
		
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
}
