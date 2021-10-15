package game;

import javax.swing.JLabel;

public class PiezaGrafica extends JLabel{
	
	/**
	 * Coloca una imagen a la pieza grafica.
	 * @param el numero de la imagen
	 */
	public void setImagen(int numero){
		String ruta = ""+numero;
		setText(ruta);
		//setIcon(new javax.swing.ImageIcon(game.PiezaGrafica.class.getResource(ruta)));
	}
}
