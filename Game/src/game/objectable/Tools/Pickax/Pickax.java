package game.objectable.Tools.Pickax;

import game.objectable.Goods.Stone.Stone;
import game.objectable.Tools.Tools;

import java.util.Random;

public class Pickax extends Tools {
    public boolean broken = false;
    public int Lr;

    public int numCollected(Stone stone) {
        int x;
        Random random = new Random();
        int a = (int)(stone.CR * Math.pow(2.0, Lr) / Math.pow(2.0, stone.LR));
        x = random.nextInt(a + 1);
        return x;
    }

    public int energyChange(Stone stone) {
        int E;
        E = (int) (stone.ER * Math.pow(2.0, stone.LR) / Math.pow(1.6, Lr));
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

    public Pickax(String name) {
        super(name, "Pickax");
        this.type = "Pickax";
    }
}
