package ls13.aufgaben.rollenspiel.gamefigures.util;

public enum Trait {
    INTELLIGENCE("I"),
    STRENGTH("S"),
    CONSTITUTION("C"),
    DEXTERITY("D");

    private final String id;

    Trait(String id) {
        this.id = id;
    }

    public static Trait ofId(String id) {
        for (Trait value : values()) {
            if (value.id.equals(id)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }
}
