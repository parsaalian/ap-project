package game.objectable.Seeds;

import game.objectable.Fruits_and_Vegs.Fruits_and_Vegs;
import game.objectable.Objectable;

public class Seeds extends Objectable {
    public Fruits_and_Vegs seed;

    public String  status() {
        return ("A " + seed.name + " seed. When it’s fully raised, you can harvest it " + seed.removal + " times. Can only be raised (in " + seed.getSeason() + "/ at the greenhouse).");
    }

    public Fruits_and_Vegs getSeed() {
        return seed;
    }

    public Seeds(String name) {
        super(name, "Seed");
        this.inspectType = 2;
    }
}
