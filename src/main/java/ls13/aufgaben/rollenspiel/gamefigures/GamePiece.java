package ls13.aufgaben.rollenspiel.gamefigures;

import ls13.aufgaben.rollenspiel.field.Matchfield;
import ls13.aufgaben.rollenspiel.gamefigures.util.Attack;
import ls13.aufgaben.rollenspiel.gamefigures.util.Defense;
import ls13.aufgaben.rollenspiel.gamefigures.util.Observable;
import ls13.aufgaben.rollenspiel.gamefigures.util.Trait;

import java.awt.*;

public abstract class GamePiece /*Spielfigur*/ extends Observable {
    private static final int MINIMUM_VISIBLE_FIELDS_X = 2;
    private static final int MINIMUM_VISIBLE_FIELDS_Y = 2;

    private Matchfield field;
    private String name;
    private int hp;
    private Trait characterTrait;
    private Point currentPosition;
    private Attack attack;
    private Defense defense;

    public GamePiece(Matchfield field, String name, int hp, Point currentPosition, Trait trait) {
        setMatchfield(field);
        setName(name);
        setAttack(getStandardAttack());
        setDefense(getStandardDefense());
        setHp(hp);
        setInitialPosition(currentPosition);
        setCharacterTraits(trait);
    }

    public GamePiece(Matchfield field, String name, Attack a, Defense d, int hp, Point currentPosition, Trait trait) {
        setMatchfield(field);
        setName(name);
        setAttack(a);
        setDefense(d);
        setHp(hp);
        setInitialPosition(currentPosition);
        setCharacterTraits(trait);
    }

    private void setMatchfield(Matchfield field) {
        if (field == null)
            throw new IllegalArgumentException("Eine Spielfigur muss ihr Spielfeld kennen!");
        this.field = field;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Der Name einer Spielfigur darf nie leer sein!");
        this.name = name;
    }

    private void setHp(int hp) {
        if (hp < 1)
            throw new IllegalArgumentException("Die Lebenspunkte einer Spielfigur dürfen nicht bei kleiner als 1 sein! Ihre Angabe: " + hp);
        this.hp = hp;
    }

    private void setCharacterTraits(Trait characterTraits) {
        if (characterTraits == null) throw new IllegalArgumentException("Jede Spielfigur benötigt eine Stärke");
        this.characterTrait = characterTraits;
    }

    private void setAttack(Attack attack) {
        if (attack == null) throw new IllegalArgumentException("Eine Spielfigur braucht immer einen Angriff!");
        this.attack = attack;
    }

    private void setDefense(Defense defense) {
        if (defense == null) throw new IllegalArgumentException("Eine Spielfigur braucht immer eine Verteidigung!");
        this.defense = defense;
    }

    public Attack getAttack() {
        return attack;
    }

    public Defense getDefense() {
        return defense;
    }

    protected void setInitialPosition(Point initialPosition) {
        if (initialPosition == null) throw new IllegalArgumentException("Die Person braucht einen Startpunkt!");
        if (initialPosition.x < 0 || initialPosition.y < 0 || initialPosition.x < field.getWidth() || initialPosition.y > field.getHeight())
            throw new IllegalArgumentException("Die Person befindet sich außerhalb des Spielfeldes! Angegebene Position: " + initialPosition);
        this.currentPosition = initialPosition;
    }


    public void move(int x, int y) {
        currentPosition.x += x;
        currentPosition.y += y;
        notifyObservers();
    }

    public void pickupArtefact() {
        //TODO
        notifyObservers();
    }

    public void useArtefact() {
        //TODO
        notifyObservers();
    }

    public void substrateHp(int factor) {
        hp -= factor;
        if (hp <= 0) die();

        notifyObservers();
    }

    private void die() {
        //TODO
    }

    public void attackEnemy(GamePiece attacker, GamePiece defender) {
        Attack a = attacker.getAttack();
        Defense d = defender.getDefense();

        if (a.strength > d.strength)
            defender.substrateHp(a.strength - d.strength);
    }

    protected abstract Attack getStandardAttack();

    protected abstract Defense getStandardDefense();
}
