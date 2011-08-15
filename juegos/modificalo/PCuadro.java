package juegos.modificalo;

public class PCuadro {
	public int x1;
	public int x2;
	public int y1;
	public int y2;
	public int xF;
	public int yF;
	Ubicacion uGafa;
	Ubicacion uBigote;
	Ubicacion uPelo;
	
	public PCuadro (int c) {
		if (c == 1) {
			uGafa = new Ubicacion("gafa", 350, 450, 50);
			uBigote = new Ubicacion("bigote", 350, 450, 50);
			uPelo = new Ubicacion("pelo", 350, 450, 50);
		}
		if (c == 2) {
			uGafa = new Ubicacion("gafa", 350, 450, 50);
			uBigote = new Ubicacion("bigote", 350, 450, 50);
			uPelo = new Ubicacion("pelo", 350, 450, 50);
		}
	}
}
