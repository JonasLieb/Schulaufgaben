package ls13.aufgaben.rollenspiel.gamefigures;

import ls13.aufgaben.rollenspiel.field.Matchfield;
import ls13.aufgaben.rollenspiel.gamefigures.util.Attack;
import ls13.aufgaben.rollenspiel.gamefigures.util.Defense;
import ls13.aufgaben.rollenspiel.gamefigures.util.Trait;

import java.awt.*;

public class Fighter extends GamePiece{
    private final Attack standardAttack = new Attack(this, 8);
    private final Defense standardDefense = new Defense(this, 7);
    private static final int STANDARD_FIGHTER_HP = 120;
    private static final Trait STANDARD_FIGHTER_TRAITS = Trait.STRENGTH;

    public Fighter(Matchfield field, String name, Point currentPosition) {
        super(field, name, STANDARD_FIGHTER_HP, currentPosition, STANDARD_FIGHTER_TRAITS);
    }

    public Fighter(Matchfield field, String name, Attack a, Defense d, int hp, Point currentPosition, Trait trait) {
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
