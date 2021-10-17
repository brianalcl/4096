package game;

import java.util.Iterator;
import java.util.Random;


public class Grilla {
	private Juego miJuego;
	private Pieza[][] matriz;
	private int filas;
	private int columnas;
	private Random rndFila;
	private Random rndColumna;
	
	public Grilla(Juego juego) {
		rndFila = new Random();
		rndColumna = new Random();
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
		
		crearPieza();
		crearPieza();
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
	public void moverTodasAbajo() { // experimental TODO
		bajarYApilar();
		crearPieza();
	}

	/**
	 * Mueve todas las piezas hacia arriba, resolviendo las coliciones.
	 */
	public void moverTodasArriba() { // experimental TODO
		subirYApilar();
		crearPieza();
	}
	
	/**
	 * Mueve todas las piezas hacia la izquierda, resolviendo las coliciones.
	 */
	public void moverTodasIzquierda() {
		izquierdaYApilar();
		crearPieza();
	}

	/**
	 * Mueve todas las piezas hacia la derecha, resolviendo las coliciones.
	 */
	public void moverTodasDerecha() {
		derechaYApilar();
		crearPieza();
	}
	
	private void izquierdaYApilar() {
		Pieza fijo;
		Pieza sig;
		
		for (int f = 0; f < matriz.length; f++) {
			fijo = matriz[f][0];
			for (int c = 1; c < matriz.length; c++) {
				sig = matriz[f][c];
				fijo = apilar(fijo, sig, 0, 1);			
			}
		}
	}
	
	private void subirYApilar() {
		Pieza fijo;
		Pieza sig;
		
		for (int c = 0; c < matriz.length; c++) {
			fijo = matriz[0][c];
			for (int f = 1; f < matriz.length; f++) {
				sig = matriz[f][c];
				fijo = apilar(fijo, sig, 1, 0);			
			}
		}
	}
	
	private void derechaYApilar() {
		Pieza fijo;
		Pieza sig;
		
		for (int f = 0; f < matriz.length; f++) {
			fijo = matriz[f][matriz.length-1];
			for (int c = matriz.length-2; c >= 0; c--) {
				sig = matriz[f][c];
				fijo = apilar(fijo, sig, 0, -1);			
			}
		}
	}
	
	private void bajarYApilar() {
		Pieza fijo;
		Pieza sig;
		
		for (int c = 0; c < matriz.length; c++) {
			fijo = matriz[matriz.length-1][c];
			for (int f = matriz.length-2; f >= 0; f--) {
				sig = matriz[f][c];
				fijo = apilar(fijo, sig, -1, 0);			
			}
		}
	}
	
	/**
	 * Si es posible apilar, apila, luego retorna la pieza fijo.
	 * @param fijo 
	 * @param sig
	 * @param fFila incremento en la fila de fijo
	 * @param fColumna incremento en la columna de fijo
	 * @return la pieza fijo
	 */
	private Pieza apilar(Pieza fijo, Pieza sig, int fFila, int fColumna) {
		if(fijo.estaLibre() && !sig.estaLibre()) {
			fijo.llenar(sig.vaciar());
		}
		else {
			if(!sig.estaLibre()) {
				if(fijo.esIgual(sig)) {
					fijo.llenar(sig.vaciar());
					fijo = matriz[fijo.getFila() + fFila][fijo.getColumna() + fColumna];
				}
				else {
					fijo = matriz[fijo.getFila() + fFila][fijo.getColumna() + fColumna];
					if(!fijo.equals(sig)) {
						fijo.llenar(sig.vaciar());
					}
				}
			}
		}
		return fijo;
	}
	
	/**
	 * Crea una pieza en un lugar aleatorio
	 */
	private void crearPieza() {//solo para testeo luego se cambiara a una forma mas optimizada TODO
		int f = 0;
		int c = 0;
		boolean corte = false;
		int cant = 0; //basura agregada para que corte el juego xD TODO
		
//		matriz[0][0].cargar();
//		matriz[1][0].cargar();
//		matriz[2][0].cargar();
//		matriz[3][0].cargar();
//		
//		matriz[0][1].cargar();
//		matriz[2][1].cargar();
//		
//		matriz[1][2].cargar();
//		matriz[3][2].cargar();
//		
//		matriz[0][3].llenar(2);
//		matriz[1][3].llenar(4);
//		matriz[2][3].llenar(8);
//		matriz[3][3].llenar(16);
		
		while(!corte && cant < 1000) {
			cant++;
			f = Math.abs(rndFila.nextInt()) % 4;
			c = Math.abs(rndColumna.nextInt()) % 4;
			if(matriz[f][c].estaLibre()) {
				matriz[f][c].cargar();
				corte = true;
			}
		}
	}
}
