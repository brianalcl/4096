package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Juego;

import javax.swing.JPanel;

import factory.FabricaGUI;
import factory.FabricaGUIClasica;
import factory.FabricaGUIGris;
import factory.FabricaGUIImg;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame{
	/**
	 * Serial por defecto.
	 */
	private static final long serialVersionUID = 1L;
	private static final String FUENTE = "SansSerif";
	
	private Juego miJuego;
	private JLabel[][] matrizPrincipal;
	private JPanel panelDeJuego;
	private JPanel panelEstadisticas;
	private JLabel lblScoreDat;
	private JLabel lblBest;
	private JLabel lblBestDat;
	private JLabel lblScore;
	private JPanel pF;
	private FabricaGUI fabrica;
	private JComboBox comboBox;
	
	public Ventana() {
		this.matrizPrincipal = new JLabel[4][4];
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarJuego();
			}
		});
		
		
		crearFrame();
		crearPanelStats();
		crearPanelDeJuego();
		crearCambioEstetico();
		agregarControles();
		
		this.miJuego = new Juego(this, fabrica);
		setFocusable(true);
		repaint();
	}
		
	private void crearCambioEstetico() {
		FabricaGUI[] fabricas = new FabricaGUI[3];
		fabricas[0] = new FabricaGUIImg();
		fabricas[1] = new FabricaGUIClasica();
		fabricas[2] = new FabricaGUIGris();
		
		comboBox = new JComboBox(fabricas);
		comboBox.setFocusable(false);
		comboBox.setBounds(250, 0, 150, 50);
		panelEstadisticas.add(comboBox);
		fabrica = (FabricaGUI) comboBox.getSelectedItem();
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarFabrica();
				
			}
		});
	}
	
	private void actualizarFabrica() {
		fabrica = (FabricaGUI) comboBox.getSelectedItem();
		actualizarVista();
	}

	private void actualizarVista() {
		miJuego.setFabrica(fabrica);
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
		matrizPrincipal[fila][columna].setIcon(p.getIcon());
		repaint();
	}

	/**
	 * Actualiza el puntaje.
	 * @param p el puntaje.
	 */
	public void actualizarPuntaje(int p) {
		lblScoreDat.setText(""+p);
	}
	
	/**
	 * Da por terminado el juego.
	 */
	public void cerrarJuego() {
		miJuego.guardarRecord();
	}
	
	/**
	 * Actualiza el puntaje maximo.
	 * @param best.
	 */
	public void actualizarBestScore(int best) {
		lblBestDat.setText(""+best);
	}
	
	/**
	 * Restaura el juego
	 */
	public void restaurar() {
		getContentPane().remove(pF);
		repaint();
		miJuego.restaurar();
	}

	/**
	 * Muestra que termino el juego.
	 */
	public void termino() {
		pF = new PanelFinDeJuego(this);
		
		int posX = (int) Math.abs(pF.getBounds().getWidth() - getBounds().getWidth()) / 2 - 7;
		int posY = (int) Math.abs(pF.getBounds().getHeight() - getBounds().getHeight()) / 2 + 19;
		
		pF.setLocation(posX, posY);
		getContentPane().add(pF);
		
		setFocusable(true);
		getContentPane().setComponentZOrder(pF, 0);
		
		repaint();
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
	 * Setea algunos parametros de la ventana.
	 */
	private void crearFrame() {
		setBounds(0, 0, 415, 538);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
	}
	
	/**
	 * Crea el panel del juego.
	 */
	private void crearPanelDeJuego() {
		panelDeJuego = new JPanel();
		panelDeJuego.setBounds(0, 100, 400, 400);
		panelDeJuego.setLayout(new GridLayout(4, 4, 0, 0));
		getContentPane().add(panelDeJuego);
		
		for (int f = 0; f < matrizPrincipal.length; f++) {
			for(int c = 0; c < matrizPrincipal[0].length; c++) {
				matrizPrincipal[f][c] = new JLabel();
				matrizPrincipal[f][c].setOpaque(true);
				panelDeJuego.add(matrizPrincipal[f][c]);
			}
		}
		
	}
	
	/**
	 * Crea el panel con las estadisticas del juego.
	 */
	private void crearPanelStats() {
		panelEstadisticas = new JPanel();
		panelEstadisticas.setBounds(0, 0, 400, 100);
		panelEstadisticas.setBackground(new Color(185, 173, 160));
		panelEstadisticas.setLayout(null);
		getContentPane().add(panelEstadisticas);
		
		lblScore = new JLabel("SCORE:");
		lblScore.setFont(new Font(FUENTE, Font.BOLD, 20));
		lblScore.setBounds(10, 46, 80, 26);
		panelEstadisticas.add(lblScore);
		
		lblScoreDat = new JLabel("");
		lblScoreDat.setFont(new Font(FUENTE, Font.BOLD, 20));
		lblScoreDat.setBounds(91, 46, 168, 26);
		panelEstadisticas.add(lblScoreDat);
		
		lblBest = new JLabel("BEST:");
		lblBest.setFont(new Font(FUENTE, Font.BOLD, 20));
		lblBest.setBounds(10, 10, 64, 26);
		panelEstadisticas.add(lblBest);
		
		lblBestDat = new JLabel("");
		lblBestDat.setFont(new Font(FUENTE, Font.BOLD, 20));
		lblBestDat.setBounds(74, 10, 185, 26);
		panelEstadisticas.add(lblBestDat);
	}
}
