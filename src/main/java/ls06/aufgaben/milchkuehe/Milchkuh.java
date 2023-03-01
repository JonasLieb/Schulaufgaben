package ls06.aufgaben.milchkuehe;

public class Milchkuh {
    private String name;
    private double maxMilchMenge;

    public Milchkuh(String name, double maxMilchMenge) {
        setName(name);
        setMaxMilchMenge(maxMilchMenge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Der Name einer Kuh darf nicht leer sein!");
        this.name = name;
    }

    public double getMaxMilchMenge() {
        return maxMilchMenge;
    }

    public void setMaxMilchMenge(double maxMilchMenge) {
        if (maxMilchMenge <= 0)
            throw new IllegalArgumentException("Die maximale Milchmenge einer Kuh darf nicht kleiner oder gleich null sein");
        this.maxMilchMenge = maxMilchMenge;
    }
}
