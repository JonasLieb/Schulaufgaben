package ls13.aufgaben.rollenspiel.gamefigures.util;

import ls13.aufgaben.rollenspiel.gamefigures.GamePiece;

public class Attack {
    public final GamePiece gp;
    public final int strength;

    public Attack(GamePiece gp, int strength) {
        if (gp == null) throw new IllegalArgumentException("Ein Angriff braucht immer eine Spielfigur");
        if (strength < 1)
            throw new IllegalArgumentException("Stärke eines Angriffs muss größer oder gleich null sein.");
        this.gp = gp;
        this.strength = strength;
    }
}
