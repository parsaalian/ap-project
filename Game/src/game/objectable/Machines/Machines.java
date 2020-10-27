package game.objectable.Machines;

import game.Game;
import game.objectable.*;

import java.util.Scanner;

public class Machines extends Objectable {
    protected Objectable input;
    protected Objectable output;

    public void inspect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ":");
        System.out.println("1. Status\n2. Use this machine");
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println(name + ":");
                System.out.println("1. Status\n2. Use this machine");
            }
            else if(line.equals("1")) {
                status();
            }
            else if(line.equals("2")) {
                use();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public String use() {
        StringBuilder res = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        res.append("Choose " + input.name + ":\n");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Back")) {
                break;
            } else if (line.equals("WhereAmI")) {
                res.append("Choose " + input.name + ":\n");
                Game.Parsa.backpack.printItems();
            } else {
                int j = 0;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    res.append("Invalid Command!\n");
                    continue;
                }
                if (j < 1 || j > Game.Parsa.backpack.getRange()) {
                    res.append("Out of range.\n");
                    continue;
                }
                Objectable item = Game.Parsa.backpack.geti(j);
                if (!item.name.equals(input.name)) {
                    res.append("You have to choose " + input.name + ".\n");
                } else {
                    Game.Parsa.backpack.takeItem(input);
                    Game.Parsa.backpack.putItem(output);
                    res.append(output.name + " added to your backpack.\n");
                }
            }
        }
        return res.toString();
    }

    public String status() {
        return null;
    }

    public void build() {

    }

    protected boolean checkInBackpack(Objectable item, int r) {
        boolean ret = false;
        if(Game.Parsa.backpack.frequency(item) >= r) {
            ret = true;
        }
        return ret;
    }

    protected boolean getItemsBuild(Objectable need, int r, String name) {
        boolean ret = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ":");
        System.out.println("Get " + need.name + " x" + r);
        Game.Parsa.backpack.printItems();
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                Game.Parsa.backpack.printItems();
            }
            else {
                int i;
                try {
                    i = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command");
                    continue;
                }
                if(i < 1 || i > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable item = Game.Parsa.backpack.geti(i);
                if(item.name.equals(need.name) && Game.Parsa.backpack.frequency(item) >= r) {
                    for(int j = 0; j < r; j++) {
                        Game.Parsa.backpack.takeItem(item);
                        ret = true;
                    }
                    System.out.println("You have chosen " + r + " " + need.name + "(s)");
                    break;
                }
                else if(item.name.equals(need.name) && Game.Parsa.backpack.frequency(item) < r) {
                    System.out.println("You don't have enough amount of this good.");
                    break;
                }
                else {
                    System.out.println("You have chosen wrong item.");
                }
            }
        }
        return ret;
    }

    public Machines(String name) {
        super(name, "Machine");
    }
}
