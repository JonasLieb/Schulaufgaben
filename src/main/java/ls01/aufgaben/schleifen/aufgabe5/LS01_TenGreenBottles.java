package ls01.aufgaben.schleifen.aufgabe5;


import ls01.util.Utilities;

public class LS01_TenGreenBottles {
    private static final String REPLACEABLE1 = "_REPLACEABLE_1_";
    private static final String REPLACEABLE2 = "_REPLACEABLE_2_";

    private static final String POEM_PLURAL = REPLACEABLE1 + " green bottles hanging on the wall,\r\n" + REPLACEABLE1
            + " green bottles hanging on the wall.\r\n" + "And if one green bottle should accidentally fall,\r\n"
            + "There'll be " + REPLACEABLE2 + " green bottles hanging on the wall.\r\n";

    private static final String POEM_SINGULAR = "One green bottle hanging on the wall,\r\n"
            + "One green bottle hanging on the wall.\r\n" + "And if one green bottle should accidentally fall,\r\n"
            + "There'll be no green bottles hanging on the wall.\r\n";

    private static final String[] NUMS = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten"};

    public static void main(String[] args) {
        printPoem(Utilities.getInt(
                "Geben Sie die Anzahl von Strophen an, welche durchlaufen werden sollen.\nMehr als 10 Strophen sind nicht möglich.",
                "Der angegebene Wert war ungültig. versuchen Sie es erneut."));
    }

    public static void printPoem(int i) {
        if (i < 1 || i > 10) {
            System.out.println("Ungültiger Wert: " + i);
            return;
        }

        for (; i > 1; i--) {
            System.out.println(POEM_PLURAL.replace(REPLACEABLE1, NUMS[i - 1]).replace(REPLACEABLE2, NUMS[i - 2]));
        }
        System.out.println(POEM_SINGULAR);

    }
}