package game;

import gui.Ventana;

public class Juego {
	public static final int MOVER_ABAJO = 2;
	public static final int MOVER_IZQUIERDA = 4;
	public static final int MOVER_DERECHA = 6;
	public static final int MOVER_ARRIBA = 8;
	
	private int puntaje;
	private Ventana miVentana;
	private Grilla grillaPrincipal;
	
	public Juego() {
		this.puntaje = 0;
		miVentana = new Ventana(this);
		grillaPrincipal = new Grilla(this);
		
	}
	
	/**
	 * Permite mover las piezas del juego.
	 * @param operacion un entero que reprecenta los movimientos.
	 */
	public synchronized void operar(int operacion) {
		switch(operacion) {
		case MOVER_ABAJO:
			grillaPrincipal.moverTodasAbajo();
			break;
		case MOVER_ARRIBA:
			grillaPrincipal.moverTodasArriba();
			break;
		case MOVER_DERECHA:
			grillaPrincipal.moverTodasDerecha();
			break;
		case MOVER_IZQUIERDA:
			grillaPrincipal.moverTodasIzquierda();
			break;
		}
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
}
