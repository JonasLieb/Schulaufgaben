package ls02.aufgaben.arrays.aufgabe5;

public class PhrasOMat {
	private static final String[] WORD_LIST_1 = { "verlässliche", "erfolgsorientierte", "webbasierte", "allumfassende",
			"clevere", "kundenorientierte", "pfadkritische", "dynamische", "konkurenzfähige", "verteilte",
			"zielgerichtete" };

	private static final String[] WORD_LIST_2 = { "gepowerte", "haftende", "Mehrwert-", "zentrierte", "geclusterte",
			"proaktive", "Out-of-the-Box", "positionierte", "vernetzte", "fokussierte", "kraftvolle", "geordnete",
			"geteilte", "kooperative", "beschleunigte", "Multi-Tier-", "Enterprise-", "B2B-", "Frontend", };

	private static final String[] WORD_LIST_3 = { "Schicht", "Endstufe", "Lösung", "Architektur", "Kernkompetenz",
			"Strategie", "Kooperation", "Ausrichtung", "Räumlichkeit", "Vision", "Dimension", "Mission" };

	private static final String[][] wordLists = { WORD_LIST_1, WORD_LIST_2, WORD_LIST_3 };

	public static void main(String[] args) {
		printPhrase();
	}

	/**
	 * prints a single phrase build from every wordlist contained in wordLists
	 */
	public static void printPhrase() {
		String output = "";
		for (int i = 0; i < wordLists.length; i++) {
			output += wordLists[i][getRandomIndex(wordLists[i])];
			if (!output.endsWith("-"))
				output += " ";
		}
		System.out.println(output);
	}

	/**
	 * determins an random index from the given array
	 * 
	 * @param array the given array
	 * @return an random index
	 */
	private static int getRandomIndex(Object[] array) {
		return (int) (Math.random() * array.length);
	}
}
