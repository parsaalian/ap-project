package game.objectable.Goods.Stone;

import game.objectable.Goods.Goods;

public class Stone extends Goods {
    public String type;
    public String strength;
    public int LR;
    public int ER;
    public double CR;

    public String status() {
        if (type.equals("Stone")) {
            return ("Status: Bunch of stones collected from the ground. Can be used to create specific items at the workshop.");
        }
        else {
            return ("Status: " + type + ". A " + strength + " type of metal. Can be used to create specific items at the workshop.");
        }
    }

    public Stone(String name) {
        super(name, "Stone");
        this.inspectType = 2;
        this.ER = 30;
        this.CR = 2.5;
    }
}
