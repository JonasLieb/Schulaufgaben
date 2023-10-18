package ls13.aufgaben.rollenspiel.gamefigures.util;

import ls13.aufgaben.rollenspiel.gamefigures.GamePiece;

public class Defense {
    public final GamePiece gp;
    public final int strength;

    public Defense(GamePiece gp, int strength) {
        if (gp == null) throw new IllegalArgumentException("Ein Angriff braucht immer eine Spielfigur");
        if (strength < 1)
            throw new IllegalArgumentException("Stärke einer Verteidigung muss größer oder gleich null sein.");
        this.gp = gp;
        this.strength = strength;
    }
}
