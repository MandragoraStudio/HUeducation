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
			uGafa = new Ubicacion("gafa", 334, 382, 50);
			uBigote = new Ubicacion("bigote", 338, 348, 50);
			uPeluca = new Ubicacion("peluca", 353, 349, 50);
			uCollar = new Ubicacion("collar", 360, 300, 50);
			uObjeto = new Ubicacion("objeto", 260, 70, 50);
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
