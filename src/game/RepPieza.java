package game;

import javax.swing.JLabel;

public abstract class RepPieza extends JLabel{
	/**
	 * serial por defecto
	 */
	private static final long serialVersionUID = 1L;

	public abstract void setImagen(int numero);
}
