package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Juego;
import game.Pieza;
import main.Player;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ventana extends JFrame{
	private Juego miJuego;
	private JLabel[][] matrizPrincipal;
	private JPanel panel;
	private JPanel panelEstadisticas;
	private JLabel lblScoreDat;
	private JLabel lblBest;
	private JLabel lblBestDat;
	private JLabel lblScore;
	
	public Ventana(Juego juego) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarJuego();
			}
		});
		this.miJuego = juego;
		this.matrizPrincipal = new JLabel[4][4];
		crearFrame();
		crearPanelDeJuego();
		agregarControles();
	}
	
	/**
	 * Setea algunos parametros de la ventana.
	 */
	private void crearFrame() {
		setSize(415, 538);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	
	/**
	 * Crea el panel del juego.
	 */
	private void crearPanelDeJuego() {
		panel = new JPanel();
		panel.setBounds(0, 100, 400, 400);
		panel.setLayout(new GridLayout(4, 4, 0, 0));
		panel.setBorder(new LineBorder(new Color(100, 0, 0), 10));
		getContentPane().add(panel);
		
		panelEstadisticas = new JPanel();
		panelEstadisticas.setBounds(0, 0, 400, 100);
		panelEstadisticas.setBackground(new Color(185, 173, 160));
		getContentPane().add(panelEstadisticas);
		panelEstadisticas.setLayout(null);
		
		lblScore = new JLabel("SCORE:");
		lblScore.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblScore.setBounds(10, 64, 80, 26);
		panelEstadisticas.add(lblScore);
		
		lblScoreDat = new JLabel("");
		lblScoreDat.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblScoreDat.setBounds(100, 64, 142, 26);
		panelEstadisticas.add(lblScoreDat);
		
		lblBest = new JLabel("BEST:");
		lblBest.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblBest.setBounds(10, 10, 80, 26);
		panelEstadisticas.add(lblBest);
		
		lblBestDat = new JLabel("");
		lblBestDat.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblBestDat.setBounds(100, 10, 142, 26);
		panelEstadisticas.add(lblBestDat);
		
		
		for (int f = 0; f < matrizPrincipal.length; f++) {
			for(int c = 0; c < matrizPrincipal[0].length; c++) {
				matrizPrincipal[f][c] = new JLabel();
				matrizPrincipal[f][c].setOpaque(true);
				panel.add(matrizPrincipal[f][c]);
			}
		}
		
	}
	
	/**
	 * Agrega el sistema de oyentes en la ventana.
	 */
	private void agregarControles() {

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					miJuego.operar(Juego.MOVER_IZQUIERDA);
					break;
				case KeyEvent.VK_RIGHT:
					miJuego.operar(Juego.MOVER_DERECHA);
					break;
				case KeyEvent.VK_UP:
					miJuego.operar(Juego.MOVER_ARRIBA);
					break;
				case KeyEvent.VK_DOWN:
					miJuego.operar(Juego.MOVER_ABAJO);
					break;
				}

			}

		});
	}
	
	/**
	 * Cambia la parte visual de un label.
	 * @param p un label con informacion ya cargada.
	 * @param fila la fila del label a cambiar.
	 * @param columna la columna del label a cambiar.
	 */
	public void cambiarPieza(JLabel p, int fila, int columna) {
		matrizPrincipal[fila][columna].setText(p.getText());
		matrizPrincipal[fila][columna].setFont(p.getFont());
		matrizPrincipal[fila][columna].setForeground(p.getForeground());
		matrizPrincipal[fila][columna].setBackground(p.getBackground());
		matrizPrincipal[fila][columna].setHorizontalAlignment(p.getHorizontalAlignment());
		matrizPrincipal[fila][columna].setBorder(p.getBorder());
	}

	public void incrementarPuntaje(int rta) {
		lblScoreDat.setText(""+rta);
	}
	
	private void cerrarJuego() {
		miJuego.salirDelJuego();
	}

	public void actualizarBestScore(int bestScore) {
		lblBestDat.setText(""+bestScore);
	}
}
