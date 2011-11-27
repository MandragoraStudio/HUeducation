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
	Ubicacion uPeluca;
	Ubicacion uCollar;
	Ubicacion uObjeto;
	
	public PCuadro (int c) {
		if (c == 1) {
			uGafa = new Ubicacion("gafa", 384, 437, 80);
			uBigote = new Ubicacion("bigote", 410, 390, 80);
			uPeluca = new Ubicacion("peluca", 387, 312, 80);
			uCollar = new Ubicacion("collar", 405, 295, 80);
			uObjeto = new Ubicacion("objeto", 300, 112, 80);
		}
		if (c == 2) {
			uGafa = new Ubicacion("gafa", 388, 400, 50);
			uPeluca = new Ubicacion("peluca", 398, 288, 80);
			uObjeto = new Ubicacion("objeto", 399, 118, 80);
		}
	}
}
