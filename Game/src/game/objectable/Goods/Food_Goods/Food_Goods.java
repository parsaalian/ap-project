package game.objectable.Goods.Food_Goods;

import game.objectable.Goods.Food_Goods.Egg.Egg;
import game.objectable.Goods.Food_Goods.Flour.Flour;
import game.objectable.Goods.Food_Goods.Oil.Oil;
import game.objectable.Goods.Food_Goods.Spices.Salt.Salt;
import game.objectable.Goods.Food_Goods.Spices.Sugar.Sugar;
import game.objectable.Goods.Goods;

import java.util.ArrayList;
import java.util.Arrays;

public class Food_Goods extends Goods {
    public String status() {
        return ("Can be used while cooking certain foods.");
    }

    public Food_Goods(String name) {
        super(name);
        this.inspectType = 2;
    }

    public static ArrayList<Food_Goods> list = new ArrayList<>(Arrays.asList(new Egg(), new Flour(), new Oil(), new Salt(), new Sugar()));
}
