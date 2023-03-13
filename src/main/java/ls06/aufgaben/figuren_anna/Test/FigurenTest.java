package ls06.aufgaben.figuren_anna.Test;


import ls06.aufgaben.figuren_anna.figuren2D.*;
import ls06.aufgaben.figuren_anna.figuren3D.*;

public class FigurenTest {

	private static final String trenner = "-----------------------------------------------------";

	public static void main(String[] args) {

		System.out.println(trenner + "\n2D-Figuren:\nKreis (Radius 5):");
		Kreis kreis = new Kreis(5);
		System.out.println("	Flaeche: " + kreis.Flaeche() + "\n	Umfang: " + kreis.Umfang() + "\n");

		System.out.println("Rechteck (Seite A: 2, Seite B: 3):");
		Rechteck rightEdge = new Rechteck(2, 3);
		System.out.println("	Flaeche: " + rightEdge.Flaeche() + "\n	Umfang: " + rightEdge.Umfang() + "\n");

		System.out.println("Sechseck (Länge 14):");
		Sechseck sechsEck = new Sechseck(14);
		System.out.println("	Flaeche: " + sechsEck.Flaeche() + "\n	Umfang: " + sechsEck.Umfang() + "\n");

		System.out.println("Dreieck (SeiteA = 4, SeiteB = 3, SeiteC = 2):");
		Dreieck dreieck = new Dreieck(4, 3, 2);
		System.out.println("	Flaeche Dreieck: " + dreieck.Flaeche() + "\n	Umfang: " + dreieck.Umfang() + "\n");

		System.out.println("Ungültiges Dreieck: (Seiten 2,3,7)");
		try {
			Dreieck dreieckKaputt = new Dreieck(2, 3, 7);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		System.out.println(trenner + "\n3D-Figuren");

		System.out.println("Gerades Prisma:\nFlaeche: Kreis (r=14), Hoehe = 20");
		GeradesPrisma geradesPrisma = new GeradesPrisma(new Kreis(14), 20);
		System.out.println(
				"	Flaeche: " + geradesPrisma.oberflaeche() + "\n	Volumen: " + geradesPrisma.volumen() + "\n");

		System.out.println("Gleichseitige Pyramide (Grundflaeche 10 Seiten, Laenge 3, Hoehe 20):");
		GleichseitigePyramide gleichseitigePyramide = new GleichseitigePyramide(new Polygon(10, 3), 20);
		System.out.println("	Flaeche: " + gleichseitigePyramide.oberflaeche() + "\n	Volumen: "
				+ gleichseitigePyramide.volumen() + "\n");

		System.out.println("Kreiskegel (Radius 11, Hoehe 20)");
		Kreiskegel kreiskegel = new Kreiskegel(new Kreis(11), 20);
		System.out.println("	Flaeche: " + kreiskegel.oberflaeche() + "\n	Volumen: " + kreiskegel.volumen() + "\n");

		System.out.println("Kugel (Radius 12)");
		Kugel kugel = new Kugel(12);
		System.out.println("	Flaeche: " + kugel.oberflaeche() + "\n	Volumen: " + kugel.volumen() + "\n");

		System.out.println(trenner);
	}
}