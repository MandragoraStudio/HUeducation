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
			uGafa = new Ubicacion("gafa", 384, 437, 110);
			uBigote = new Ubicacion("bigote", 410, 397, 120);
			uPeluca = new Ubicacion("peluca", 387, 312,100);
			uCollar = new Ubicacion("collar", 405, 295, 100);
			uObjeto = new Ubicacion("objeto", 300, 112, 100);
		}
		if (c == 2) {
			uGafa = new Ubicacion("gafa", 388, 400, 80);
			uBigote = new Ubicacion("bigote", 410, 397, 120);
			uPeluca = new Ubicacion("peluca", 398, 288, 110);
			uCollar = new Ubicacion("collar", 405, 295, 100);
			uObjeto = new Ubicacion("objeto", 399, 118, 110);
		}
	}
}
