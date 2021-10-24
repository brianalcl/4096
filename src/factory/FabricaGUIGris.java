package factory;

import game.RepPieza;

public class FabricaGUIGris implements FabricaGUI{
	public RepPieza crearRepPieza() {
		return new RepPiezaGris();
	}
	public String toString() {
		return "Vista gris";
	}
}
