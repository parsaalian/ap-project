package game.environment.Jungle.Woods;

import game.Game;
import game.objectable.Goods.Wood.Branch.Branch;
import game.objectable.Goods.Wood.Oak_Lumber.Oak_Lumber;
import game.objectable.Goods.Wood.Old_Lumber.Old_Lumber;
import game.objectable.Goods.Wood.Pine_Lumber.Pine_Lumber;
import game.objectable.Objectable;
import game.objectable.Tools.Axe.Axe;

import java.util.Random;
import java.util.Scanner;

public class Woods {

    public String collectBranch() {
        StringBuilder res = new StringBuilder();
        Random random = new Random();
        int r = random.nextInt(3);
        for(int i = 0; i < r; i++) {
            Game.Parsa.backpack.putItem(new Branch());
        }
        if(r == 0) {
            res.append("You have collected nothing.\n");
        }
        else {
            res.append("You have collected " + r + " Branch(es)\n");
        }
        return res.toString();
    }

    public void collectOldLumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an axe from your inventory. It has to be a Stone (or a stronger kind) Axe.");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Back")) {
                break;
            }
            else if (line.equals("WhereAmI")) {
                System.out.println("Choose an axe from your inventory. It has to be a Stone (or a stronger kind) Axe.");
                Game.Parsa.backpack.printItems();
            }
            else {
                int j = 0;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable item = Game.Parsa.backpack.geti(j);
                if(item.type.equals("Axe")) {
                    Axe axe = (Axe) Game.Parsa.backpack.geti(j);
                    int a = axe.numCollected(new Old_Lumber());
                    int e = axe.energyChange(new Old_Lumber());
                    for(int i = 0; i < a; i++) {
                        Game.Parsa.backpack.putItem(new Old_Lumber());
                    }
                    Game.Parsa.energy -= e;
                    if(a == 0) {
                        System.out.println("You have collected nothing.");
                    }
                    else {
                        System.out.println("You have collected " + a + " Old Lumber(s)");
                    }
                    if(axe.breaking(axe.p)) {
                        System.out.println("Your axe has broke during the operation.");
                        axe.broken = true;
                    }
                    break;
                }
                else {
                    System.out.println("Invalid Item.");
                }
            }
        }
    }

    public void collectPineLumeber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an axe from your inventory. It has to be a Iron (or a stronger kind) Axe.");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Back")) {
                break;
            }
            else if (line.equals("WhereAmI")) {
                System.out.println("Choose an axe from your inventory. It has to be a Iron (or a stronger kind) Axe.");
                Game.Parsa.backpack.printItems();
            }
            else {
                int j = 0;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable item = Game.Parsa.backpack.geti(j);
                if(item.type.equals("Axe") && !item.name.equals("Stone Axe")) {
                    Axe axe = (Axe) Game.Parsa.backpack.geti(j);
                    int a = axe.numCollected(new Pine_Lumber());
                    int e = axe.energyChange(new Pine_Lumber());
                    for(int i = 0; i < a; i++) {
                        Game.Parsa.backpack.putItem(new Pine_Lumber());
                    }
                    Game.Parsa.energy -= e;
                    if(a == 0) {
                        System.out.println("You have collected nothing.");
                    }
                    else {
                        System.out.println("You have collected " + a + " Pine Lumber(s)");
                    }
                    if(axe.breaking(axe.p)) {
                        System.out.println("Your axe has broke during the operation.");
                        axe.broken = true;
                    }
                    break;
                }
                else {
                    System.out.println("Invalid Item.");
                }
            }
        }
    }

    public void collectOakLumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an axe from your inventory. It has to be a Silver (or a stronger kind) Axe.");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Back")) {
                break;
            }
            else if (line.equals("WhereAmI")) {
                System.out.println("Choose an axe from your inventory. It has to be a Silver (or a stronger kind) Axe.");
                Game.Parsa.backpack.printItems();
            }
            else {
                int j = 0;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable item = Game.Parsa.backpack.geti(j);
                if(item.type.equals("Axe") && !item.name.equals("Stone Axe") && !item.name.equals("Iron")) {
                    Axe axe = (Axe) Game.Parsa.backpack.geti(j);
                    int a = axe.numCollected(new Oak_Lumber());
                    int e = axe.energyChange(new Oak_Lumber());
                    for(int i = 0; i < a; i++) {
                        Game.Parsa.backpack.putItem(new Oak_Lumber());
                    }
                    Game.Parsa.energy -= e;
                    if(a == 0) {
                        System.out.println("You have collected nothing.");
                    }
                    else {
                        System.out.println("You have collected " + a + " Oak Lumber(s)");
                    }
                    if(axe.breaking(axe.p)) {
                        System.out.println("Your axe has broke during the operation.");
                        axe.broken = true;
                    }
                    break;
                }
                else {
                    System.out.println("Invalid Item.");
                }
            }
        }
    }
}
