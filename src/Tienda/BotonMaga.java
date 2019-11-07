package Tienda;

import GameObjects.Aliados.Aliado;
import GameObjects.Aliados.Maga;
import Juego.Mapa;

public class BotonMaga extends BotonFactory{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected BotonMaga(Tienda t, Mapa m) {
		super(t, m);
		setText("Maga");
		//panelTienda.add(btn_pirata);
	}

	@Override
	public Aliado crearAliado() {
		// verificar monedas
		Aliado toReturn = new Maga();
		
		return toReturn;
	} 
	
}