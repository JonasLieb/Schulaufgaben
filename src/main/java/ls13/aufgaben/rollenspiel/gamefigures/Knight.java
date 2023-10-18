package ls13.aufgaben.rollenspiel.gamefigures;

import ls13.aufgaben.rollenspiel.field.Matchfield;
import ls13.aufgaben.rollenspiel.gamefigures.util.Attack;
import ls13.aufgaben.rollenspiel.gamefigures.util.Defense;
import ls13.aufgaben.rollenspiel.gamefigures.util.Trait;

import java.awt.*;

public class Knight extends GamePiece{
    private final Attack standardAttack = new Attack(this, 9);
    private final Defense standardDefense = new Defense(this, 6);
    private static final int STANDARD_KNIGHT_HP = 120;
    private static final Trait STANDARD_KNIGHT_TRAITS = Trait.CONSTITUTION;

    public Knight(Matchfield field, String name, Point currentPosition) {
        super(field, name, STANDARD_KNIGHT_HP, currentPosition, STANDARD_KNIGHT_TRAITS);
    }

    public Knight(Matchfield field, String name, Attack a, Defense d, int hp, Point currentPosition, Trait trait) {
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
