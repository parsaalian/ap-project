package game.objectable.Machines.Cheese_Maker;

import game.Game;
import game.objectable.Food.Human_Food.Other_Foods.Cheese.Cheese;
import game.objectable.Food.Human_Food.Other_Foods.Milk.Milk;
import game.objectable.Machines.Machines;

import java.util.Scanner;

public class Cheese_Maker extends Machines {
    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("The Ultimate Cheese Maker:\n");
        res.append("Status: A machine to create cheese from milk.\n");
        res.append("You Can build this machine with " + money + " Gil in Laboratory.\n");
        return res.toString();
    }

    public void build() {
        Scanner scanner = new Scanner(System.in);
        boolean made = false;
        status();
        System.out.println("\nDo you want to build this machine? (Y/N)");
        String yn = scanner.nextLine();
        if (yn.equals("Back")) {

        }
        else if (yn.equals("WhereAmI")) {
            status();
            System.out.println("\nDo you want to build this machine? (Y/N)");
        }
        else if (yn.equals("Y")) {
            if(Game.Parsa.money > money) {
                Game.Parsa.money -= money;
                made = true;
            }
            else {
                System.out.println("You don't have enough money.");
            }
        }
        if (made) {
            Game.farm.barn.machines.add(new Cheese_Maker());
            Game.village.laboratory.removeMachine(new Cheese_Maker());
            System.out.println("Cheese Maker added to your barn.");
        } else {
            System.out.println("You couldn't make cheese maker.");
        }
    }

    public Cheese_Maker() {
        super("Cheese Maker Machine");
        this.name = "Cheese Maker Machine";
        this.input = new Milk();
        this.output = new Cheese();
        this.money = 3000;
    }
}
