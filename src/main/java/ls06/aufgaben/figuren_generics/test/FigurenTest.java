package ls06.aufgaben.figuren_generics.test;

import ls06.aufgaben.figuren_generics.figuren3d.Kugel;
import ls06.aufgaben.figuren_generics.pricecalculation.PriceCalculator;

public class FigurenTest {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        calculator.calculatePrice(new Kugel(10), "Styropor", "Plastik");
    }
}
