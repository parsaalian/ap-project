package game.environment.Farm.Arable.Garden.Pineapple;

import game.environment.Farm.Arable.Greenhouse.Greenhouse;
import game.objectable.Fruits_and_Vegs.Tropical.Pineapple.Pineapple;

public class Pineapple_Tree extends Greenhouse {
    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("Status:\n");
        res.append("Tree type: " + type + '\n');
        res.append("Tree season: " + season + '\n');
        res.append("Watered today: " + water + '\n');
        res.append("Fruits under the tree: " + dropped + '\n');
        return res.toString();
    }
    public Pineapple_Tree() {
        super();
        this.type = "Pineapple";
        this.season = "Tropical";
        this.under = new Pineapple();
    }
}
