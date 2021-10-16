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
		bajar();
		apilarBajando();
		bajar();
		crearPieza();
	}

	/**
	 * Mueve todas las piezas hacia arriba, resolviendo las coliciones.
	 */
	public void moverTodasArriba() { // experimental TODO
		subir();
		apilarSubiendo();
		subir();
		crearPieza();
	}
	
	private void apilarSubiendo() {
		Pieza anterior;
		Pieza siguiente;
		
		int f=0;
		int c=0;
		for (c = 0; c < matriz.length; c++) {
			anterior = matriz[0][c];
			for (f = 1; f < matriz.length; f++) {
				siguiente = matriz[f][c];
				if(anterior.getNumero() == siguiente.getNumero()) {
					anterior.incrementar();
					siguiente.vaciar();
					anterior = siguiente;
				}
				else {
					anterior = siguiente;
				}
			}
		}
	}
	
	private void subir() {
		Pieza anterior;
		Pieza siguiente;
		
		int f=0;
		int c=0;
		
		for (c = 0; c < matriz.length; c++) {
			anterior = matriz[0][c];
			for (f = 1; f < matriz.length; f++) {
				siguiente = matriz[f][c];
				if(anterior.estaLibre()) {
					if(!siguiente.estaLibre()) {
						anterior.llenar(siguiente.getNumero());
						siguiente.vaciar();
						anterior = siguiente;
					}
				}
				else {
					anterior = siguiente;
				}
			}
		}
	}
	
	private void apilarBajando() {
		Pieza anterior;
		Pieza siguiente;
		
		int f=0;
		int c=0;
		for (c = 0; c < matriz.length; c++) {
			anterior = matriz[matriz.length-1][c];
			for (f = matriz.length - 2; f >= 0; f--) {
				siguiente = matriz[f][c];
				if(anterior.getNumero() == siguiente.getNumero()) {
					anterior.incrementar();
					siguiente.vaciar();
					anterior = siguiente;
				}
				else {
					anterior = siguiente;
				}
			}
		}
	}
	
	private void bajar() {
		Pieza anterior;
		Pieza siguiente;
		
		int f=0;
		int c=0;
		
		for (c = 0; c < matriz.length; c++) {
			anterior = matriz[matriz.length-1][c];
			for (f = matriz.length - 2; f >= 0; f--) {
				siguiente = matriz[f][c];
				if(anterior.estaLibre()) {
					if(!siguiente.estaLibre()) {
						anterior.llenar(siguiente.getNumero());
						siguiente.vaciar();
						anterior = siguiente;
					}
				}
				else {
					anterior = siguiente;
				}
			}
		}
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
	
	/**
	 * Crea una pieza en un lugar aleatorio
	 */
	private void crearPieza() {//solo para testeo luego se cambiara a una forma mas optimizada TODO
		int f = 0;
		int c = 0;
		boolean corte = false;
		int cant = 0; //basura agregada para que corte el juego xD TODO
		
		
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
