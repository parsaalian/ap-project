package game.objectable.Goods.Wool;

import game.objectable.Goods.Goods;

public class Wool extends Goods {
    public String status() {
        return ("Status: Sheep wool. By using a spinning wheel you can turn it into a thread.");
    }

    public Wool() {
        super("Wool");
        this.money = 200;
        this.inspectType = 2;
        this.type = "Wool";
    }
}
