package factory;

import game.RepPieza;

public class FabricaGUIClasica implements FabricaGUI{
	public RepPieza crearRepPieza() {
		return new RepPiezaClasica();
	}
	public String toString() {
		return "Vista clasica";
	}
}
