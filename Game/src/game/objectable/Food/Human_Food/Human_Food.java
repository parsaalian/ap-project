package game.objectable.Food.Human_Food;

import game.Game;
import game.objectable.Food.Food;
import game.objectable.Food.Human_Food.Cheesecake.Cheesecake;
import game.objectable.Food.Human_Food.French_Fries.French_Fries;
import game.objectable.Food.Human_Food.Mirza_Ghasemi.Mirza_Ghasemi;
import game.objectable.Food.Human_Food.Shirazi_Salad.Shirazi_Salad;

import java.util.ArrayList;
import java.util.Arrays;

public class Human_Food extends Food {
    public int addHealth;
    public int addEnergy;
    public int addMaxHealth;
    public int addMaxEnergy;

    public String status() {
        StringBuilder res = new StringBuilder();
        res.append(name + ":\n");
        if(addHealth != 0) {
            res.append("Health: " + addHealth + '\n');
        }
        if(addEnergy != 0) {
            res.append("Energy: " + addEnergy + '\n');
        }
        if(addMaxHealth != 0) {
            res.append("Maximum Health: " + addMaxHealth + '\n');
        }
        if(addMaxEnergy != 0) {
            res.append("Maximum Energy: " + addMaxEnergy + '\n');
        }
        return res.toString();
    }

    public String use() {
        StringBuilder res = new StringBuilder();
        if(addHealth != 0) {
            res.append("Adding Health: " + addHealth + '\n');
            Game.Parsa.health += addHealth;
        }
        if(addEnergy != 0) {
            res.append("Adding Energy: " + addEnergy + '\n');
            Game.Parsa.energy += addEnergy;
        }
        if(addMaxHealth != 0) {
            res.append("Adding Maximum Health: " + addMaxHealth + '\n');
            Game.Parsa.maxHealth += addMaxHealth;
        }
        if(addMaxEnergy != 0) {
            res.append("Adding Maximum Energy: " + addMaxEnergy + '\n');
            Game.Parsa.maxEnergy += addMaxEnergy;
        }
        return res.toString();
    }

    public Human_Food(String name) {
        super(name);
        this.inspectType = 1;
    }

    public static ArrayList <Human_Food> list = new ArrayList<>(Arrays.asList(new Cheesecake(), new French_Fries(), new Mirza_Ghasemi(), new Shirazi_Salad()));
}
