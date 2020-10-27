package game.objectable.Machines.Juicer;

import game.Game;
import game.objectable.Food.Human_Food.Other_Foods.Juice.Juice;
import game.objectable.Fruits_and_Vegs.Fruits_and_Vegs;
import game.objectable.Machines.Machines;

import java.util.Scanner;

public class Juicer extends Machines {
    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("Juicer:\n");
        res.append("Status: A machine to extract juice from fruits and vegetables.\n");
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
                made = true;
                Game.Parsa.money -= money;
            }
            else {
                System.out.println("You don't have enough money.");
            }
        }
        if (made) {
            Game.farm.barn.machines.add(new Juicer());
            Game.village.laboratory.removeMachine(new Juicer());
            System.out.println("Juicer added to your barn.");
        } else {
            System.out.println("You couldn't make juicer.");
        }
    }

    public Juicer() {
        super("Juicer Machine");
        this.money = 1000;
        this.name = "Juicer Machine";
        this.input = new Fruits_and_Vegs();
        this.output = new Juice(input.name);
    }
}
