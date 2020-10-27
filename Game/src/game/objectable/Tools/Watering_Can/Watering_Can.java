package game.objectable.Tools.Watering_Can;


import game.*;
import game.objectable.Objectable;
import game.objectable.Tools.Tools;

import java.util.ArrayList;

public class Watering_Can extends Tools {
    public int max = 0;
    public int inside = 0;
    public int range = 0;
    public boolean broken = false;
    public Game game;

    public Watering_Can(String choice) {
        super(choice, "Watering Can");
        this.name = choice;
        this.type = "Watering Can";
    }

    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("A " + name + " sprinkler. With this sprinkler you can water a\n" + range + " range in one go. It has the capacity to water" + max + "  fields of the\nfarm.\n");
        res.append("\nWater level: " + inside + " of " + max + '\n');
        res.append("\nEnergy required for each use: " + Math.abs(changeEnergy) + '\n');
        if(broken) {
            res.append("\nBroken\n");
        }
        else {
            res.append("\nNot broken\n");
        }
        return res.toString();
    }

    public String fullCan() {
        inside = max;
        return ("Your " + name + " is filled with water");
    }

    public void setInside(int inside) {
        this.inside = inside;
    }

    public int getInside() {
        return inside;
    }

    public Watering_Can(String name, ArrayList<Objectable> needs, ArrayList<Objectable> repairs) {
        super(name, "Watering Can");
        this.type = "Watering Can";
        this.needs = needs;
        this.repairs = repairs;
    }
}
