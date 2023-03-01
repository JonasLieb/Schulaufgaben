package ls05.aufgaben.shapes2d;

public class Circle extends Shape2D {
	private int radius;

	@Override
	public double berechneFlaeche() {
		return Math.PI * Math.pow(getRadius(), 2);
	}

	@Override
	public double berechneUmfang() {
		return 2 * Math.PI * getRadius();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
