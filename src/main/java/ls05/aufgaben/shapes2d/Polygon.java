package ls05.aufgaben.shapes2d;

public class Polygon extends NEck {
	private int seitenLaenge;
	private int anzahlEcken;

	@Override
	public double berechneFlaeche() {
		return (getAnzahlEcken() / 2) * getSeitenLaenge() * berechneInnenkreisradius();
	}

	@Override
	public double berechneUmfang() {
		return getSeitenLaenge() * getAnzahlEcken();
	}

	public double berechneInnenkreisradius() {
		double zwischenergebnis2 = berechneCot();
		double zwischenergebnis3 = 2 * zwischenergebnis2;
		return getSeitenLaenge() / zwischenergebnis3;
	}

	public double berechneCot() {
		return Math.tan(Math.PI / getAnzahlEcken());
	}

	public int getAnzahlEcken() {
		return anzahlEcken;
	}

	public void setAnzahlEcken(int anzahlEcken) {
		this.anzahlEcken = anzahlEcken;
	}

	public int getSeitenLaenge() {
		return seitenLaenge;
	}

	public void setSeitenLaenge(int seitenLaenge) {
		this.seitenLaenge = seitenLaenge;
	}

}
