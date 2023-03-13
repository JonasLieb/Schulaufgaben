package ls06.aufgaben.figuren_anna.figuren3D;

import ls06.aufgaben.figuren_anna.figuren2D.*;

public class GleichseitigePyramide extends Pyramide {
	public GleichseitigePyramide(Polygon grundflaeche, double hoehe) {
		super(grundflaeche, hoehe);
	}

	@Override
	public double oberflaeche() {
		Polygon gflAsPolygon = (Polygon)super.getGrundFlaeche();
		
		double gfSeitenLaenge = gflAsPolygon.GetSeiteLaenge();
		double gfFlaecheEinDreieck = gflAsPolygon.Flaeche() / gflAsPolygon.GetAnzahlSeiten();
		double gfHoehe = gfFlaecheEinDreieck / gfSeitenLaenge/2;
		
		double hoeheMitte = Math.sqrt(Math.pow(gfHoehe, 2) + Math.pow(super.getHoehe(), 2));
		double mantelFlaeche = hoeheMitte * (gflAsPolygon.GetSeiteLaenge()/2) * gflAsPolygon.GetAnzahlSeiten();
		
		return mantelFlaeche + gflAsPolygon.Flaeche();
	}
}
