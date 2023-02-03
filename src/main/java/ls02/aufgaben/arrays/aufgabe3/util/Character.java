package ls02.aufgaben.arrays.aufgabe3.util;

public class Character {

	public static final String[] CHARACTER_TRAITS = { "Intelligenz", "St�rke", "Ausdauer", "Geschicklichkeit",
			"Weisheit", "Intuition", "Charisma" };

	public String name;
	//Character trait values in percent
	public int[] characterTraitValues = new int[CHARACTER_TRAITS.length];

	public Character(String name) {
		this.name = name;
		fillCharacterTraitValues();
	}

	private void fillCharacterTraitValues(/*
											 * Hier k�nnte potentiell noch ein Charactertyp mitgegeben werden, welcher
											 * die Charaktereigenschaften beeinflusst...
											 */) {
		for (int i = 0; i < characterTraitValues.length; i++) {
			characterTraitValues[i] = getProzentualValue();
		}
	}

	public void printTraitVaues() {
		for (int i = 0; i < characterTraitValues.length; i++) {
			System.out.println(CHARACTER_TRAITS[i] + ": " + characterTraitValues[i] + " %");
		}
	}

	private int getProzentualValue() {
		return (int) (Math.random() * 100);
	}
}
