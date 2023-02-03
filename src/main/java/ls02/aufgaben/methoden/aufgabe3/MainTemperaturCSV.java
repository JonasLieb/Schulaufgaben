package ls02.aufgaben.methoden.aufgabe3;

public class MainTemperaturCSV {
    public static void main(String[] args) {
        System.out.println(getCelsiusFromFahrenheit(86));
        System.out.println(getFahrenheitFromCelsius(30));
        System.out.println(getKelvinFromCelsius(30));
    }

    /**
     * converts the given temperature from Fahrenheit to Celsius
     *
     * @param fahrenheit the given temperature in Fahrenheit
     * @return the temperature in Celsius
     */
    public static double getCelsiusFromFahrenheit(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }

    /**
     * converts the given temperature from Celsius to Fahrenheit
     *
     * @param celsius the given temperature in Celsius
     * @return the temperature in Fahrenheit
     */
    public static double getFahrenheitFromCelsius(double celsius) {
        return celsius * 1.8 + 32;
    }

    /**
     * converts the given temperature from Celsius to kelvin
     *
     * @param celsius the given temperature in Celsius
     * @return the temperature in kelvin
     */
    public static double getKelvinFromCelsius(double celsius) {
        return celsius + 273.15;
    }
}
