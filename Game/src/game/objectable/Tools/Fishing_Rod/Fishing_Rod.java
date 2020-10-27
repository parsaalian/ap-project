package game.objectable.Tools.Fishing_Rod;

import game.Game;
import game.objectable.Animals.Fish.Fish;
import game.objectable.Tools.Tools;

import java.util.Random;

public class Fishing_Rod extends Tools {
    public int f;

    public String getFish() {
        Random random = new Random();
        int x = random.nextInt(100);
        if(x < f) {
            Game.Parsa.backpack.putItem(new Fish());
            return ("You caught a fish.");

        }
        else {
            return ("You couldn't catch a fish.");
        }
    }

    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("A " + name + ". There is " + p + "% chance to successfully catch a fish in every try.\n");
        res.append("\nEnergy required for each use: " + changeEnergy + '\n');
        if(broken) {
            res.append("\nBroken\n");
        }
        else {
            res.append("\nNot broken\n");
        }
        return res.toString();
    }

    public Fishing_Rod(String name) {
        super(name, "Fishing Rod");
        this.type = "Fishing Rod";
    }
}
