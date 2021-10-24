package game;

import java.util.Random;

import factory.FabricaGUI;

public class Pieza {
	
	private boolean estaLibre;
	private RepPieza miRepresentacion;
	private FabricaGUI miFabricaGUI;
	private int numero;
	private Random rnd;
	private Grilla miGrilla;
	private int fila;
	private int columna;
	
	/**
	 * Crea una nueva pieza con coordanadas y con una grilla.
	 * @param fila la fila a la que pertenece.
	 * @param columna la columna a la que pertenece.
	 * @param grilla la grilla a la que pertenece.
	 */
	public Pieza(int fila, int columna, Grilla grilla, FabricaGUI fabrica) {
		this.estaLibre = true;
		this.numero = 0;
		this.miFabricaGUI = fabrica;
		this.miRepresentacion = this.miFabricaGUI.crearRepPieza();
		this.miRepresentacion.setImagen(numero);
		this.rnd = new Random();
		this.miGrilla = grilla;
		this.fila = fila;
		this.columna = columna;
		this.miGrilla.cambiarPieza(this);
	}
	
	/**
	 * retorna la pieza grafica asociada a esta pieza.
	 * @return la pieza grafica asociada a esta pieza.
	 */
	public RepPieza getRepPieza() {
		return miRepresentacion;
	}
	
	/**
	 * Carga la pieza con un valor el cual generalmente es 2 y raramente 4.
	 */
	public void cargar() {
		int num = rnd.nextInt(8);
		numero = num == 0? 4 : 2;
		estaLibre = false;
		miRepresentacion.setImagen(numero);
		miGrilla.cambiarPieza(this);
	}
	
	/**
	 * Vacia la pieza y retorna el numero asociado.
	 */
	public int vaciar() {
		int rta = numero;
		numero = 0;
		estaLibre = true;
		miRepresentacion.setImagen(numero);
		miGrilla.cambiarPieza(this);
		return rta;
	}
	
	/**
	 * llena la pieza en cuestion, si la pieza esta vacia entonces se llena, de lo contrario se duplica su valor.
	 * @param n el numero a cargar en la pieza.
	 */
	public void llenar(int n) {
		if(numero == 0) 
			numero = n;
		else {
			numero *= 2;
			miGrilla.incrementarPuntaje(numero);
		}
		estaLibre = false;
		miRepresentacion.setImagen(numero);
		miGrilla.cambiarPieza(this);
	}
	
	/**
	 * Controla si la pieza esta libre.
	 * @return true si esta libre, false si no lo esta.
	 */
	public boolean estaLibre() {
		return estaLibre;
	}
	
	/**
	 * Retorna la fila a la que pertenece la pieza.
	 * @return coordenada de la fila.
	 */
	public int getFila() {
		return fila;
	}
	
	/**
	 * Retorna la columna a la que pertenece la pieza.
	 * @return coordenada de la columna.
	 */
	public int getColumna() {
		return columna;
	}
	
	/**
	 * Retorna verdadero si las piezas son iguales (contienen el mismo numero)
	 * y falso en caso contrario.
	 * @param p una pieza.
	 * @return true si tienen el mismo numero false caso contrario.
	 */
	public boolean esIgual(Pieza p) {
		return numero == p.numero;
	}

	/**
	 * Actualiza la fabrica
	 * @param fabrica
	 */
	public void setFabrica(FabricaGUI fabrica) {
		// TODO Auto-generated method stub
		miFabricaGUI = fabrica;
		miRepresentacion = miFabricaGUI.crearRepPieza();
		miRepresentacion.setImagen(numero);
		miGrilla.cambiarPieza(this);
	}

}
