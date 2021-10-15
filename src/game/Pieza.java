package game;

import java.util.Random;

public class Pieza {
	
	private boolean estaLibre;
	private PiezaGrafica miRepresentacion;
	private int numero;
	private Random rnd;
	private Grilla miGrilla;
	private int fila;
	private int columna;
	
	/**
	 * Crea una nueva pieza con coordanadas y con una grilla.
	 * @param fila la fila a la que pertenece
	 * @param columna la columna a la que pertenece
	 * @param grilla la grilla a la que pertenece
	 */
	public Pieza(int fila, int columna, Grilla grilla) {
		this.estaLibre = true;
		this.numero = 0;
		this.miRepresentacion = new PiezaGrafica();
		this.rnd = new Random();
		this.miGrilla = grilla;
		this.fila = fila;
		this.columna = columna;
	}
	
	/**
	 * retorna la pieza grafica asociada a esta pieza
	 * @return la pieza grafica asociada a esta pieza
	 */
	public PiezaGrafica getPiezaGrafica() {
		return miRepresentacion;
	}
	
	/**
	 * Carga la pieza con un valor el cual generalmente es 2 y raramente 4.
	 */
	public void cargar() {
		int num = rnd.nextInt(10);
		numero = num == 9? 4 : 2;
		estaLibre = false;
		miRepresentacion.setImagen(numero);
		miGrilla.cambiarPieza(this);
	}
	
	/**
	 * Incrementa al doble el numero de la pieza.
	 */
	public void incrementar() {
		numero = numero*2;
		miRepresentacion.setImagen(numero);
		miGrilla.cambiarPieza(this);
	}
	
	/**
	 * Vacia la pieza.
	 */
	public void vaciar() {
		numero = 0;
		estaLibre = true;
		miRepresentacion.setImagen(numero);
		miGrilla.cambiarPieza(this);
	}
	
	/**
	 * Controla si la pieza esta libre
	 * @return true si esta libre, false si no lo esta.
	 */
	public boolean estaLibre() {
		return estaLibre;
	}
	
	
}
