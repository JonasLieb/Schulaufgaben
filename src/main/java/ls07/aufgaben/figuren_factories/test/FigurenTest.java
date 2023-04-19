package ls07.aufgaben.figuren_factories.test;

import ls07.aufgaben.figuren_factories.figuren3d.Kugel;
import ls07.aufgaben.figuren_factories.pricecalculation.PriceCalculator;

public class FigurenTest {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        calculator.calculatePrice(new Kugel(10), "Styropor", "Plastik");
    }
}
