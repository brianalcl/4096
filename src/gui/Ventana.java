package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Juego;
import game.Pieza;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

public class Ventana extends JFrame{
	private Juego miJuego;
	private JLabel[][] matrizPrincipal;
	private JPanel panel;
	
	public Ventana(Juego juego) {
		this.miJuego = juego;
		this.matrizPrincipal = new JLabel[4][4];
		crearFrame();
		crearPanelDeJuego();
	}
	
	private void crearFrame() {
		setSize(415, 438);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	
	private void crearPanelDeJuego() {
		panel = new JPanel();
		panel.setBounds(0, 0, 400, 400);
		panel.setLayout(new GridLayout(4, 4, 0, 0));
		panel.setBorder(new LineBorder(new Color(100, 0, 0), 5, true));
		getContentPane().add(panel);
		
		
		for (int f = 0; f < matrizPrincipal.length; f++) {
			for(int c = 0; c < matrizPrincipal[0].length; c++) {
				matrizPrincipal[f][c] = new JLabel();
				matrizPrincipal[f][c].setOpaque(true);
				matrizPrincipal[f][c].setBorder(new LineBorder(new Color(0, 100, 0), 2, true));
				matrizPrincipal[f][c].setBackground(new java.awt.Color(175, 150, 125));
				panel.add(matrizPrincipal[f][c]);
			}
		}
		
	}
	
	public void cambiarPieza(JLabel p, int fila, int columna) {
		matrizPrincipal[fila][columna].setText(p.getText());
		matrizPrincipal[fila][columna].setBackground(p.getBackground());
	}
}
