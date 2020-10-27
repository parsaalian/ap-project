package game.objectable.Goods.Wood;

import game.objectable.Goods.Goods;

public class Wood extends Goods {
    public String type;
    public String strength;
    public int LR;
    public int ER;
    public double CR;

    public String status() {
        if (type.equals("Branch")) {
            return ("Status: Weak tree branch. Can be used to create specific items at the workshop.");
        }
        else {
            return ("Status: " + strength + " wood gotten from a " + type + " tree. Can be used to create specific items at the workshop.");
        }
    }

    public Wood(String name) {
        super(name, "Wood");
        this.inspectType = 2;
        this.ER = 30;
        this.CR = 2.5;
    }
}
