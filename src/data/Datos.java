package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import game.Juego;
import main.Player;

public class Datos {
	private Juego miJuego;
	
	public Datos(Juego juego) {
		this.miJuego = juego;
	}
	
	public void salirDelJuego() {
		try {
			FileOutputStream fileOutputStream
			= new FileOutputStream("./score.dat");
			ObjectOutputStream objectOutputStream 
			= new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(miJuego.getJugador());
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void entrarAlJuego() {
		try {
			FileInputStream fileInputStream
			= new FileInputStream("./score.dat");
			ObjectInputStream objectInputStream
			= new ObjectInputStream(fileInputStream);
			miJuego.setJugador((Player) objectInputStream.readObject());
			miJuego.addBestScore(miJuego.getJugador().getBestScore());
			objectInputStream.close();
		}
		catch (FileNotFoundException e) {
			// si no esta es porque el jugador fue creado vacio
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
