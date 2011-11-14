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
			uGafa = new Ubicacion("gafa", 350, 450, 50);
			uBigote = new Ubicacion("bigote", 350, 450, 50);
			uPeluca = new Ubicacion("peluca", 350, 500, 50);
			uCollar = new Ubicacion("collar", 350, 300, 50);
			uObjeto = new Ubicacion("objeto", 350, 200, 50);
		}
	}
}
