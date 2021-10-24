package factory;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import game.RepPieza;

public class RepPiezaGris extends RepPieza {

private static final long serialVersionUID = 1L;
	
	private static final String FUENTE = "SansSerif";
	
	public RepPiezaGris () {
		setFont(new Font(FUENTE, Font.BOLD, 25));
		setHorizontalAlignment(SwingConstants.CENTER);
		setBorder(new LineBorder(new Color(240, 240, 240), 2));
	}

	public void setImagen(int numero){
		
		String ruta = numero == 0? "" : ""+numero;
		setText(ruta);
		
		switch(numero) {
		case 0:
			setForeground(Color.BLACK);
			setBackground(new Color(220, 220, 220));
			break;
		case 2:
			setForeground(Color.BLACK);
			setBackground(new Color(200, 200, 200));
			break;
		case 4:
			setForeground(Color.BLACK);
			setBackground(new Color(180, 180, 180));
			break;
		case 8:
			setForeground(Color.WHITE);
			setBackground(new Color(160, 160, 160));
			break;
		case 16:
			setForeground(Color.WHITE);
			setBackground(new Color(140, 140, 140));
			break;
		case 32:
			setForeground(Color.WHITE);
			setBackground(new Color(120, 120, 120));
			break;
		case 64:
			setForeground(Color.WHITE);
			setBackground(new Color(100, 100, 100));
			break;
		case 128:
			setForeground(Color.WHITE);
			setBackground(new Color(80, 80, 80));
			break;
		case 256:
			setForeground(Color.WHITE);
			setBackground(new Color(60, 60, 60));
			break;
		case 512:
			setForeground(Color.WHITE);
			setBackground(new Color(40, 40, 40));
			break;
		case 1024:
			setForeground(Color.WHITE);
			setBackground(new Color(20, 20, 20));
			break;
		case 2048:
			setForeground(Color.WHITE);
			setBackground(new Color(0, 0, 0));
			break;
		default:
			setForeground(Color.WHITE);
			setBackground(Color.BLACK);
			break;
		}
	}
}
