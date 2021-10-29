package factory;

import game.RepPieza;

public class FabricaGUIImg implements FabricaGUI{
	public RepPieza crearRepPieza() {
		return new RepPiezaImg();
	}
	public String toString() {
		return "Vista imagen";
	}
}
