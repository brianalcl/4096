package factory;

import javax.swing.SwingConstants;

import game.RepPieza;

public class RepPiezaImg extends RepPieza {

private static final long serialVersionUID = 1L;
	
	public RepPiezaImg () {
		setHorizontalAlignment(SwingConstants.CENTER);
	}

	public void setImagen(int numero) {
			String ruta = new StringBuilder("/assets/img/")
					.append(numero)
					.append(".png")
					.toString();
			setIcon(new javax.swing.ImageIcon(factory.RepPiezaImg.class.getResource(ruta)));
		
	}
}
