package game;

import javax.swing.JLabel;

public class PiezaGrafica extends JLabel{
	public void setImagen(int numero){
		String ruta = ""+numero;
		setIcon(new javax.swing.ImageIcon(game.PiezaGrafica.class.getResource(ruta)));
	}
}
