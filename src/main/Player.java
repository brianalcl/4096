package main;

import java.io.Serializable;

public class Player implements Serializable {
	private int bestScore;
	public Player() {
		bestScore = 0;
	}
	public void setBestScore(int puntaje) {
		bestScore = puntaje;
	}
	public int getBestScore() {
		return bestScore;
	}
}
