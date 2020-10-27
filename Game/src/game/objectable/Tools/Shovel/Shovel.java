package game.objectable.Tools.Shovel;

import game.objectable.Tools.Tools;

public class Shovel extends Tools {
    public boolean broken = false;
    public int range = 0;

    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("A " + name + " shovel. With this shovel you can dig a " + range + " range in one go.\n");
        res.append("\nEnergy required for each use: " + changeEnergy + '\n');
        if(broken) {
            res.append("\nBroken\n");
        }
        else {
            res.append("\nNot broken\n");
        }
        return res.toString();
    }

    public Shovel(String name) {
        super(name, "Shovel");
        this.type = "Shovel";
    }
}
