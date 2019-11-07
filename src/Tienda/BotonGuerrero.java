package Tienda;

import GameObjects.Aliados.Aliado;
import GameObjects.Aliados.Guerrero;
import Juego.Mapa;

public class BotonGuerrero extends BotonFactory{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected BotonGuerrero(Tienda t, Mapa m) {
		super(t, m);
		setText("Guerrero");
		//panelTienda.add(btn_pirata);
	}

	@Override
	public Aliado crearAliado() {
		// verificar monedas
		Aliado toReturn = new Guerrero();
		
		return toReturn;
	} 
	
}