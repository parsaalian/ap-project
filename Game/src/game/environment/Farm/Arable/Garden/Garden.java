package game.environment.Farm.Arable.Garden;

import game.environment.Farm.Arable.*;
import game.Game;

import java.util.Random;

public class Garden extends Arable {
    public int money = 50;
    public int dropped = 0;
    public boolean buy = false;

    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("Status:\n");
        res.append("Tree type: " + type + '\n');
        res.append("Tree season: " + season + '\n');
        res.append("Watered today: " + water + '\n');
        res.append("Fruits under the tree: " + dropped + '\n');
        return res.toString();
    }

    public String collect() {
        StringBuilder res = new StringBuilder();
        if (dropped == 0) {
            res.append("There is no fruit under the tree.\n");
        }
        else {
            if(Game.Parsa.backpack.capacity > dropped * under.capacity) {
                for (int i = 0; i < dropped; i++) {
                    Game.Parsa.backpack.putItem(under);
                }
                Game.Parsa.backpack.capacity -= dropped * under.capacity;
                res.append(dropped +  " fruits collected.\n");
                dropped = 0;
            }
            else {
                res.append("You don't have enough capacity.\n");
            }
        }
        return res.toString();
    }

    public void buy() {
        buy = true;
    }

    public void birdsEatFruits() {
        dropped = 0;
    }

    public void dropSomeFruits() {
        if(water) {
            Random random = new Random();
            dropped = random.nextInt(1) + 2;
        }
    }

    public Garden() {
        super();
    }
}
