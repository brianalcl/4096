package game;

import java.util.Iterator;

public class Grilla {
	private Juego miJuego;
	private Pieza[][] matriz;
	private int filas;
	private int columnas;
	
	public Grilla(Juego juego) {
		this.filas = 4;
		this.columnas = 4;
		this.miJuego = juego;
		this.matriz = new Pieza[filas][columnas];
		
		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				matriz[f][c] = new Pieza(f, c, this);
				matriz[f][c].vaciar();
			}
		}
	}
	
	/**
	 * Cambia graficamente la pieza p
	 * @param p una pieza
	 */
	public void cambiarPieza(Pieza p) {
		miJuego.cambiarPieza(p);
	}

	/**
	 * Mueve todas las piezas hacia abajo, resolviendo las coliciones.
	 */
	public void moverTodasAbajo() {
		
	}

	/**
	 * Mueve todas las piezas hacia arriba, resolviendo las coliciones.
	 */
	public void moverTodasArriba() {
		
	}

	/**
	 * Mueve todas las piezas hacia la izquierda, resolviendo las coliciones.
	 */
	public void moverTodasIzquierda() {
		
	}

	/**
	 * Mueve todas las piezas hacia la derecha, resolviendo las coliciones.
	 */
	public void moverTodasDerecha() {
		
	}
}
