package main;

import java.io.Serializable;

public class Player implements Serializable {
	/**
	 * Serial por defecto.
	 */
	private static final long serialVersionUID = 1L;
	private int bestScore;
	
	public Player() {
		bestScore = 0;
	}
	
	/**
	 * Setea el puntaje mas alto.
	 * @param puntaje
	 */
	public void setBestScore(int puntaje) {
		bestScore = puntaje;
	}
	
	/**
	 * Retorna el puntaje mas alto.
	 * @return
	 */
	public int getBestScore() {
		return bestScore;
	}
}
