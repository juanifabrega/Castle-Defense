package Juego;

import GameObjects.GameObject;
import GameObjects.Aliados.Aliado;
import GameObjects.Aliados.Pirata;
import Tienda.Tienda;

public class Juego {
	
	protected GUI gui;
	protected Movimiento movimiento;
	protected Mapa mapa;
	protected Tienda tienda;
	
	public Juego(){
		
		tienda = Tienda.Instancia(this);
		gui = new GUI(tienda);
		gui.setVisible(true);
		mapa = new Mapa(gui, this);
		gui.setMapa(mapa);
		mapa.crearNivelUno();
		movimiento = new Movimiento(this);
		movimiento.run();	
	}	

	public Mapa getMapa() {
		return mapa;
	}
	
	public GUI getGUI() {
		return gui;
	}
	
	public void interactuar() {	
		boolean puedoSeguirMoviendome;

//		System.out.println("Tamaño lista principal: "+mapa.getListaPrincipal().size());
//		System.out.println("Tamaño lista eliminar: "+mapa.getListaEliminar().size());
//		System.out.println("Tamaño lista agregar: "+mapa.getListaAgregar().size());
	
		
		
		for(GameObject obj : mapa.getListaPrincipal()) {
			if(obj.getVida()>0) {				/*
				obj.interactuar();
				*/
				puedoSeguirMoviendome = obj.interactuar();
				if( !puedoSeguirMoviendome ) 
					finDelJuego();
			}			
			else
				obj.morir();
		}
		
		for(GameObject obj : mapa.getListaEliminar()) {
			tienda.sumarMonedas(obj.getMonedas());
			mapa.getListaPrincipal().remove(obj);
			obj.getDibujo().setVisible(false);
			obj = null;
		}
		mapa.resetLista(mapa.getListaEliminar());
		
		
		for(GameObject obj : mapa.getListaAgregar()) {
			mapa.getListaPrincipal().add(obj);
			gui.agregarDibujo(obj);
			obj.setMapa(mapa);
		}		
		mapa.resetLista(mapa.getListaAgregar());
		
	}
	
	private void finDelJuego() {
		movimiento.setDeboMover(false);
		gui.gameOver();
		
	}
	
}

