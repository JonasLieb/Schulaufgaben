package ls05.aufgaben.shapes2d;

public class Rectangle extends NEck {
	private int breite;
	private int hoehe;

	@Override
	public double berechneFlaeche() {
		return getBreite() * getHoehe();
	}

	@Override
	public double berechneUmfang() {
		return 2 * getBreite() + 2 * getHoehe();
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public int getHoehe() {
		return hoehe;
	}

	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}

}
