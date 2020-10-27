package game.objectable.Goods.Stone.Iron;

import game.objectable.Goods.Stone.Stone;

public class Iron extends Stone {
    public Iron() {
        super("Iron Ore");
        this.money = 80;
        this.type = "Iron";
        this.strength = "normal";
        this.LR = 2;
    }
}
