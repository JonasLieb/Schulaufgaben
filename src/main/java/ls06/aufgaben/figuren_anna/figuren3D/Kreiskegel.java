package ls06.aufgaben.figuren_anna.figuren3D;

import ls06.aufgaben.figuren_anna.figuren2D.*;

public class Kreiskegel extends Pyramide {
	public Kreiskegel(Kreis grundflaeche, double hoehe) {
		super(grundflaeche, hoehe);
	}

	@Override
	public double oberflaeche() {
		Kreis gflAsKreis = (Kreis) super.getGrundFlaeche();
		double seitenLaengeMantel = Math.sqrt(Math.pow(getHoehe(), 2) + Math.pow(gflAsKreis.GetRadius(), 2));
		return gflAsKreis.Flaeche() + (gflAsKreis.GetRadius() * seitenLaengeMantel * Math.PI);
	}
}
