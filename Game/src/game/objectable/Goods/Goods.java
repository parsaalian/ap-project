package game.objectable.Goods;

import game.objectable.Objectable;

public class Goods extends Objectable {
    public String status() {
        return null;
    }

    public Goods(String name) {
        super(name, name);
    }

    public Goods(String name, String type) {
        super(name, type);
    }
}
