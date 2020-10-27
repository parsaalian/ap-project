package game.objectable.Machines.Spinning;

import game.Game;
import game.objectable.Goods.Thread.Thread;
import game.objectable.Goods.Wool.Wool;
import game.objectable.Machines.Machines;

import java.util.Scanner;

public class Spinning extends Machines {
    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("Spinning Wheel:\n");
        res.append("Status: A machine to make threads out of wools\n");
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
                Game.Parsa.money = Game.Parsa.money - money;
                made = true;
            }
            else {
                System.out.println("You don't have enough money.");
            }
        }
        if (made) {
            Game.farm.barn.machines.add(new Spinning());
            Game.village.laboratory.removeMachine(new Spinning());
            System.out.println("spinning machine added to your barn.");
        } else {
            System.out.println("You couldn't make spinning machine.");
        }
    }

    public Spinning() {
        super("Spinning Machine");
        this.name = "Spinning Machine";
        this.input = new Wool();
        this.output = new Thread();
        this.money = 2000;
    }
}
