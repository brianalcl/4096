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
	
	private JButton btnFinDeJuegoRestart;
	private JButton btnFinDeJuegoExit;

	private JLabel lblNewLabel;

	public PanelFinDeJuego(Ventana v) {
		setBackground(new Color(205, 193, 180));
		setBorder(new LineBorder(new Color(100, 0, 0), 5));
		setBounds(0, 0, 235, 210);
		setLayout(null);
		
		btnFinDeJuegoRestart = new JButton("RESTART");
		btnFinDeJuegoExit = new JButton("EXIT");
		btnFinDeJuegoRestart.addActionListener((actionEvent) -> { v.restaurar(); });

		btnFinDeJuegoRestart.setFont(new Font(FUENTE, Font.BOLD, 20));
		btnFinDeJuegoRestart.setBounds(5, 105, 225, 50);
		btnFinDeJuegoRestart.setBackground(new Color(243, 178, 122));
		add(btnFinDeJuegoRestart);
		
		btnFinDeJuegoExit.addActionListener((actionEvent) -> {	v.cerrarJuego(); System.exit(0); });
		
		btnFinDeJuegoExit.setFont(new Font(FUENTE, Font.BOLD, 20));
		btnFinDeJuegoExit.setBounds(5, 155, 225, 50);
		btnFinDeJuegoExit.setBackground(new Color(243, 178, 122));
		add(btnFinDeJuegoExit);
		
		lblNewLabel = new JLabel("GAMEOVER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font(FUENTE, Font.BOLD, 35));
		lblNewLabel.setForeground(new Color(100, 0, 0));
		lblNewLabel.setBounds(5, 5, 225, 50);
		add(lblNewLabel);
	}
}
