package game.objectable.Tools.Axe;

import game.objectable.Goods.Wood.Wood;
import game.objectable.Tools.Tools;

import java.util.Random;

public class Axe extends Tools {
    public boolean broken = false;
    public int Lr;

    public int numCollected(Wood wood) {
        Random random = new Random();
        int x;
        int a = (int)(wood.CR * Math.pow(2.0, Lr) / Math.pow(2.0, wood.LR));
        x = random.nextInt(a + 1);
        return x;
    }

    public int energyChange(Wood wood) {
        int E;
        E = (int) (wood.ER * Math.pow(2.0, wood.LR) / Math.pow(1.6, Lr));
        return E;
    }

    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("A " + name + '\n');
        if(broken) {
            res.append("\nBroken\n");
        }
        else {
            res.append("\nNot broken\n");
        }
        return res.toString();
    }

    public Axe(String name) {
        super(name, "Axe");
        this.type = "Axe";
    }
}
