package GameObjects.Enemigos;

import java.util.Random;

import GameObjects.GameObject;
import GameObjects.Premios.MagiasTemporales.DobleDanio;
import GameObjects.Premios.MagiasTemporales.DobleOro;
import Juego.Punto;
import Visitor.VisitorEnemigo;

public class Mono extends Enemigo {
		
	public Mono() {
		// Vida, Daño, Rango, VelMov, VelAtaq, Puntos, Monedas
		super(40, 5, 100, 3, 20, 35, 30); 
		visitor = new VisitorEnemigo(this);
				
		ruta_dibujo_quieto = null;
		ruta_dibujo_moviendose = "img/enemigos/mono.gif";
		ruta_dibujo_ataque = "img/enemigos/mono_ataque.gif";

		cambiarDibujo(ruta_dibujo_moviendose);
	}	
	
	public void morir() {        //REDEFINO EL METODO MORIR DENUEVO
		super.morir();
		mapa.mostrarOleada3();	
	}
	

}
