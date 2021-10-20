package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import game.Juego;
import main.Player;

public class Datos {
	private Juego miJuego;
	private Properties configuration;
	
	public Datos(Juego juego) {
		this.miJuego = juego;
		cargarConfiguracion();
	}
	
	/**
	 * Carga el archivo de configuracion.
	 */
	public void cargarConfiguracion() {
		try (InputStream input = new FileInputStream("./src/resources/configuration.properties")) {

            configuration = new Properties();
            configuration.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
	
	/**
	 * Permite guardar la informacion del record mas alto del juego.
	 */
	public void guardarInformacion() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(configuration.getProperty("file"));
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(miJuego.getJugador());
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Permite cargar la informacion del record mas alto en el juego.
	 */
	public void cargarInformacion() {
		try {
			FileInputStream fileInputStream = new FileInputStream(configuration.getProperty("file"));
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
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
