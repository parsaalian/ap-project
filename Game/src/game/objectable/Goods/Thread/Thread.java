package game.objectable.Goods.Thread;

import game.objectable.Goods.Goods;

public class Thread extends Goods {
    public String status() {
        return ("Status: Can be used to create specific items at the workshop.");
    }

    public Thread() {
        super("Thread");
        this.money = 300;
        this.inspectType = 2;
        this.type = "Thread";
    }
}
