import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Perro extends Enemigo {
	
	protected int cantDisparos;
	
	public Perro() {
		punto = null;
		ancho = 62;
		largo = 38;
		vida = 40;
		danio = 10;
		rango = 100;
		//velocidad = RAPIDA
		puntos = 35;
		monedas = 30;	
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("enemigos/perro.gif"));
		dibujo = new JLabel(imagen);
		//dibujo.setBounds(punto.getX(), punto.getY(), ancho, largo);	
		v = new VisitorEnemigo(this);
		cantDisparos = 0;
		agresivo = false;
		estrategia = new EstrategiaEnemigoInteractuarMover(this);
	}	
	
	public void mover() {
		Rectangle pos = dibujo.getBounds();
		int newX = (int) ((pos.getX()>0)? pos.getX()-3 : pos.getX());
		int newY = (int) pos.getY();
		int ancho = (int) pos.getWidth();
		int alto = (int) pos.getHeight();
		punto.setX(newX);
		//punto.setY(newY); // al pedo, no cambia nada
		dibujo.setBounds(newX, newY, ancho, alto);
	}
	
	public void interactuar() {
		GameObject objIntersectado = mapa.intersectaRangoDeEnemigo(this);
		if(objIntersectado!=null) 
			objIntersectado.accept(v);
		
		estrategia.interactuar(objIntersectado);
/*		
		Rectangle pos = dibujo.getBounds();
		int newX = (int) ((pos.getX()>0)? pos.getX()-3 : pos.getX());
		int newY = (int) pos.getY();
		int ancho = (int) pos.getWidth();
		int alto = (int) pos.getHeight();
		
		GameObject objIntersectado = mapa.intersectaRangoDeEnemigo(this);
		if(objIntersectado!=null) 
			objIntersectado.accept(v);
		else
			agresivo = false;
		System.out.println(agresivo);
		if(!agresivo) {
			punto.setX(newX);
			punto.setY(newY);
			dibujo.setBounds(newX, newY, ancho, alto); // se mueve
		}
		else { 
			//objIntersectado.accept(v);

			if(cantDisparos%30 == 0)
				disparar();
			cantDisparos++;
		}
*/
	}
	

	@Override
	public void atacar(GameObject obj) {
		

		ImageIcon imagen = new ImageIcon(this.getClass().getResource("enemigos/perro_ataque.gif"));		
		dibujo.setIcon(imagen);
		if(vida>0) {  // si estoy vivo, ataco

			if(cantDisparos%30 == 0)
				//obj.setVida(obj.getVida()-danio);
				disparar();
			cantDisparos++;
			
			if(obj.getVida()<=0) {
				estrategia = new EstrategiaEnemigoInteractuarMover(null);
			}
			
	/*		try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		} else
			morir();
	}
	

	public void disparar() {
		
		Disparo disparo = new DisparoEnemigo(danio, new Punto(punto.getX()-dibujo.getWidth(),punto.getY()+20));
		mapa.getListaAgregar().add(disparo);
		disparo.setMapa(mapa);
		
		
	}
}
