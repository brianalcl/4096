package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelFinDeJuego extends JPanel{
	/**
	 * Seria por defecto
	 */
	private static final long serialVersionUID = 1L;

	private static final String FUENTE = "SansSerif";
	
	private JButton btnRestart;
	private JButton btnExit;

	private JLabel lblGameOver;

	public PanelFinDeJuego(Ventana v) {
		setBackground(new Color(205, 193, 180));
		setBorder(new LineBorder(new Color(100, 0, 0), 5));
		setBounds(0, 0, 235, 210);
		setLayout(null);
		
		btnRestart = new JButton("RESTART");
		btnExit = new JButton("EXIT");
		lblGameOver = new JLabel("GAME OVER");
		
		btnRestart.addActionListener((actionEvent) -> { v.restaurar(); });
		btnExit.addActionListener((actionEvent) -> {	v.cerrarJuego(); System.exit(0); });
		
		btnRestart.setFont(new Font(FUENTE, Font.BOLD, 20));
		btnRestart.setBounds(5, 105, 225, 50);
		btnRestart.setBackground(new Color(243, 178, 122));
		add(btnRestart);
		
		btnExit.setFont(new Font(FUENTE, Font.BOLD, 20));
		btnExit.setBounds(5, 155, 225, 50);
		btnExit.setBackground(new Color(243, 178, 122));
		add(btnExit);
		
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font(FUENTE, Font.BOLD, 35));
		lblGameOver.setForeground(new Color(100, 0, 0));
		lblGameOver.setBounds(5, 20, 225, 50);
		add(lblGameOver);
	}
}
