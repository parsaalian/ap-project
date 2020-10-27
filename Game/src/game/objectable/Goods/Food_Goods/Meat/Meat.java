package game.objectable.Goods.Food_Goods.Meat;

import game.objectable.Goods.Food_Goods.Food_Goods;
import game.objectable.Goods.Food_Goods.Meat.Chicken_Meat.Chicken_Meat;
import game.objectable.Goods.Food_Goods.Meat.Cow_Meat.Cow_Meat;
import game.objectable.Goods.Food_Goods.Meat.Fish_Meat.Fish_Meat;
import game.objectable.Goods.Food_Goods.Meat.Sheep_Meat.Sheep_Meat;

import java.util.ArrayList;
import java.util.Arrays;

public class Meat extends Food_Goods {
    public Meat(String name) {
        super(name);
    }
    public static ArrayList <Meat> meats = new ArrayList<>(Arrays.asList(new Chicken_Meat(), new Cow_Meat(), new Fish_Meat(), new Sheep_Meat()));
}