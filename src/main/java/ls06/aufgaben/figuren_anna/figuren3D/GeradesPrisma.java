package ls06.aufgaben.figuren_anna.figuren3D;

import ls06.aufgaben.figuren_anna.figuren2D.*;

public class GeradesPrisma extends Figur3D {
	private double hoehe;
	private Figur2D grundflaeche;

	public GeradesPrisma(Figur2D grundflaeche, double hoehe) {
		setGrundflaeche(grundflaeche);
		setHoehe(hoehe);
	}

	@Override
	public double oberflaeche() {
		double mantelFlaeche = getGrundflaeche().Umfang() * hoehe;
		double obenUnten = getGrundflaeche().Flaeche() * 2;
		return mantelFlaeche + obenUnten;
	}

	@Override
	public double volumen() {
		return getGrundflaeche().Flaeche() * getHoehe();
	}

	public void setGrundflaeche(Figur2D grundflaeche) {
		this.grundflaeche = grundflaeche;
	}

	public Figur2D getGrundflaeche() {
		return grundflaeche;
	}

	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}

	public double getHoehe() {
		return hoehe;
	}
}
