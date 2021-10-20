package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PiezaGrafica extends JLabel{
	private static final String FUENTE = "SansSerif";
	
	public PiezaGrafica() {
		setFont(new Font(FUENTE, Font.BOLD, 25));
		setHorizontalAlignment(SwingConstants.CENTER);
		setBorder(new LineBorder(new Color(100, 50, 0), 2));
		
	}
	
	/**
	 * Coloca una imagen a la pieza grafica.
	 * @param el numero de la imagen
	 */
	public void setImagen(int numero){
		String ruta = numero == 0? "" : ""+numero;
		setText(ruta);
		
		switch(numero) {
		case 0:
			setForeground(Color.BLACK);
			setBackground(new Color(205, 193, 180));
			break;
		case 2:
			setForeground(Color.BLACK);
			setBackground(new Color(238, 228, 218));
			break;
		case 4:
			setForeground(Color.BLACK);
			setBackground(new Color(238, 205, 201));
			break;
		case 8:
			setForeground(Color.WHITE);
			setBackground(new Color(243, 178, 122));
			break;
		case 16:
			setForeground(Color.WHITE);
			setBackground(new Color(246, 150, 100));
			break;
		case 32:
			setForeground(Color.WHITE);
			setBackground(new Color(247, 124, 95));
			break;
		case 64:
			setForeground(Color.WHITE);
			setBackground(new Color(247, 95, 59));
			break;
		case 128:
			setForeground(Color.WHITE);
			setBackground(new Color(237, 208, 115));
			break;
		case 256:
			setForeground(Color.WHITE);
			setBackground(new Color(237, 204, 98));
			break;
		case 512:
			setForeground(Color.WHITE);
			setBackground(new Color(237, 201, 80));
			break;
		case 1024:
			setForeground(Color.WHITE);
			setBackground(new Color(237, 197, 63));
			break;
		case 2048:
			setForeground(Color.WHITE);
			setBackground(new Color(237, 190, 50));
			break;
		default:
			setForeground(Color.WHITE);
			setBackground(Color.BLACK);
			break;
		}
	}
}
