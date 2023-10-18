package ls13.aufgaben.rollenspiel.gamefigures;

import ls13.aufgaben.rollenspiel.field.Matchfield;
import ls13.aufgaben.rollenspiel.gamefigures.util.Attack;
import ls13.aufgaben.rollenspiel.gamefigures.util.Defense;
import ls13.aufgaben.rollenspiel.gamefigures.util.Trait;

import java.awt.*;

public class Wizard extends GamePiece {
    private final Attack standardAttack = new Attack(this, 14);
    private final Defense standardDefense = new Defense(this, 3);
    private static final int STANDARD_WIZARD_HP = 100;
    private static final Trait STANDARD_WIZARD_TRAITS = Trait.INTELLIGENCE;

    public Wizard(Matchfield field, String name, Point currentPosition) {
        super(field, name, STANDARD_WIZARD_HP, currentPosition, STANDARD_WIZARD_TRAITS);
    }

    public Wizard(Matchfield field, String name, Attack a, Defense d, int hp, Point currentPosition, Trait trait) {
        super(field, name, a, d, hp, currentPosition, trait);
    }

    @Override
    protected Attack getStandardAttack() {
        return standardAttack;
    }

    @Override
    protected Defense getStandardDefense() {
        return standardDefense;
    }
}
