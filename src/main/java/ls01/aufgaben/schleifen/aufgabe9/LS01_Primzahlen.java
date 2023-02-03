package ls01.aufgaben.schleifen.aufgabe9;


import ls01.aufgaben.schleifen.aufgabe6.LS01_Teiler;

public class LS01_Primzahlen {
    public static void main(String[] args) {
        System.out.println(isPrimzahl(66));
        System.out.println(isPrimzahl(53));
    }

    public static boolean isPrimzahl(int num) {
        int[] teiler = LS01_Teiler.getTeiler(num);
        return teiler == null || teiler.length == 2; // Nur durch genau 2 Werte Teilbar: sich selbst oder 0
    }
}
