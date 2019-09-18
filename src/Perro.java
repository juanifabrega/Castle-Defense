import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Perro extends Enemigo {
	
	private final int ancho = 62;
	private final int largo = 38;
	
	public Perro(Punto p) {
		vida = 30;
		ubicacion=p;
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("enemigos/perro.gif"));
		dibujo = new JLabel(imagen);
		//dibujo.setBounds(p.getX(), p.getY(), ancho, largo);
		rango = 1;
		danio = 10;
		//velocidad = RAPIDA
		puntos = 35;
		monedas = 30;		
	}
	
	public int getAncho() {
		return ancho;
	}

	public int getLargo() {
		return largo;
	}
	
}
