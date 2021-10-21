package game;

import java.util.Random;


public class Grilla {
	private Juego miJuego;
	private Pieza[][] matriz;
	private int filas;
	private int columnas;
	private int cantLlenas;
	private Random rndFila;
	private Random rndColumna;
	private boolean realizoMovimiento;
	
	
	public Grilla(Juego juego) {
		this.rndFila = new Random();
		this.rndColumna = new Random();
		this.filas = 4;
		this.columnas = 4;
		this.cantLlenas = 0;
		this.miJuego = juego;
		this.matriz = new Pieza[filas][columnas];
		this.realizoMovimiento = false;
		
		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				matriz[f][c] = new Pieza(f, c, this);
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
	 * Mueve en una direccion todas las piezas siempre que sea posible.
	 * @param movimiento
	 */
	public void mover(int movimiento) {
		
		switch (movimiento) {
		case Juego.MOVER_ABAJO: bajarYApilar(); break;
		case Juego.MOVER_ARRIBA: subirYApilar(); break;
		case Juego.MOVER_DERECHA: derechaYApilar(); break;
		case Juego.MOVER_IZQUIERDA: izquierdaYApilar(); break;
		}
		
		if(realizoMovimiento && cantLlenas < (matriz.length * matriz.length)) {
			crearPieza();
			realizoMovimiento = false;
		}
		if(!verificar())
			miJuego.termino();
	}
	
	/**
	 * Incrementa el puntaje.
	 * @param rta
	 */
	public void incrementarPuntaje(int rta) {
		miJuego.incrementarPuntaje(rta);
	}
	
	/**
	 * Restaura la grilla
	 */
	public void restaurar() {
		for(int f = 0; f < matriz.length; f++) {
			for(int c = 0; c < matriz.length; c++) {
				matriz[f][c].vaciar();
			}
		}
		cantLlenas = 0;
		realizoMovimiento = false;
		crearPieza();
		crearPieza();
	}

	/**
	 * Mueve para la izquierda todas la piezas y las apila.
	 */
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
	
	/**
	 * Mueve para arriba todas la piezas y las apila.
	 */
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
	
	/**
	 * Mueve para la derecha todas la piezas y las apila.
	 */
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
	
	/**
	 * Mueve para abajo todas la piezas y las apila.
	 */
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
			realizoMovimiento = true;
		}
		else {
			if(!sig.estaLibre()) {
				if(fijo.esIgual(sig)) {
					fijo.llenar(sig.vaciar());
					fijo = matriz[fijo.getFila() + fFila][fijo.getColumna() + fColumna];
					cantLlenas--;
					realizoMovimiento = true;
				}
				else {
					fijo = matriz[fijo.getFila() + fFila][fijo.getColumna() + fColumna];
					if(!fijo.equals(sig)) {
						fijo.llenar(sig.vaciar());
						realizoMovimiento = true;
					}
				}
			}
		}
		return fijo;
	}
	
	/**
	 * Crea una pieza en un lugar aleatorio.
	 */
	private void crearPieza() {
		int f = 0;
		int c = 0;
		boolean corte = false;
		
		while(!corte) { //En esta matriz, la probabilidad de que tarde en encontrar una posicion libre es baja.
			f = Math.abs(rndFila.nextInt()) % 4;
			c = Math.abs(rndColumna.nextInt()) % 4;
			if(matriz[f][c].estaLibre()) {
				matriz[f][c].cargar();
				corte = true;
			}
		}
		
		cantLlenas++;
	}
	
	/**
	 * Retorna verdadero si se puede mover las piezas, falso en caso contrario.
	 * @return true si es posible mover las piezas y falso si no es posible.
	 */
	private boolean verificar() {
		boolean rta = false;
		
		if(cantLlenas == 16) {
			for(int f = 0; f < matriz.length && !rta; f++) {
				for(int c = 0; c < matriz.length - 1 && !rta; c++) {
					rta = matriz[f][c].esIgual(matriz[f][c + 1]);
				}
			}

			for(int c = 0; c < matriz.length && !rta; c++) {
				for(int f = 0; f < matriz.length - 1 && !rta; f++) {
					rta = matriz[f][c].esIgual(matriz[f + 1][c]);
				}
			}
		}
		else {
			rta = true;
		}
		
		return rta;
	}
}
