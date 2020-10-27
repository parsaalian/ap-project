package game.environment.Jungle.Stones;

import game.Game;
import game.objectable.Goods.Stone.Adamantium.Adamantium;
import game.objectable.Goods.Stone.Gravel.Gravel;
import game.objectable.Goods.Stone.Iron.Iron;
import game.objectable.Goods.Stone.Silver.Silver;
import game.objectable.Objectable;
import game.objectable.Tools.Pickax.Pickax;

import java.util.Random;
import java.util.Scanner;

public class Stones {

    public String collectStones() {
        StringBuilder res = new StringBuilder();
        Random random = new Random();
        int r = random.nextInt(3);
        for(int i = 0; i < r; i++) {
            Game.Parsa.backpack.putItem(new Gravel());
        }
        if(r == 0) {
            res.append("You have collected nothing.\n");
        }
        else {
            res.append("You have collected " + r + " Stone(s)\n");
        }
        return res.toString();
    }

    public void collectIron() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an pickax from your inventory. It has to be a Stone (or a stronger kind) pickax.");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Back")) {
                break;
            } else if (line.equals("WhereAmI")) {
                System.out.println("Choose an pickax from your inventory. It has to be a Stone (or a stronger kind) pickax.");
                Game.Parsa.backpack.printItems();
            } else {
                int j = 0;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if (j < 1 || j > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable item = Game.Parsa.backpack.geti(j);
                if (item.type.equals("Pickax")) {
                    Pickax pickax = (Pickax) Game.Parsa.backpack.geti(j);
                    int a = pickax.numCollected(new Iron());
                    int e = pickax.energyChange(new Iron());
                    for (int i = 0; i < a; i++) {
                        Game.Parsa.backpack.putItem(new Iron());
                    }
                    Game.Parsa.energy -= e;
                    if (a == 0) {
                        System.out.println("You have collected nothing.");
                    } else {
                        System.out.println("You have collected " + a + " Iron(s)");
                    }
                    if (pickax.breaking(pickax.p)) {
                        System.out.println("Your pickax has broke during the operation.");
                        pickax.broken = true;
                    }
                    break;
                } else {
                    System.out.println("Invalid Item.");
                }
            }
        }
    }

    public void collectSilver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an pickax from your inventory. It has to be a Iron (or a stronger kind) pickax.");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Back")) {
                break;
            } else if (line.equals("WhereAmI")) {
                System.out.println("Choose an pickax from your inventory. It has to be a Iron (or a stronger kind) pickax.");
                Game.Parsa.backpack.printItems();
            } else {
                int j = 0;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if (j < 1 || j > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable item = Game.Parsa.backpack.geti(j);
                if (item.type.equals("Pickax") && !item.name.equals("Stone Pickax")) {
                    Pickax pickax = (Pickax) Game.Parsa.backpack.geti(j);
                    int a = pickax.numCollected(new Silver());
                    int e = pickax.energyChange(new Silver());
                    for (int i = 0; i < a; i++) {
                        Game.Parsa.backpack.putItem(new Silver());
                    }
                    Game.Parsa.energy -= e;
                    if (a == 0) {
                        System.out.println("You have collected nothing.");
                    } else {
                        System.out.println("You have collected " + a + " Silver(s)");
                    }
                    if (pickax.breaking(pickax.p)) {
                        System.out.println("Your pickax has broke during the operation.");
                        pickax.broken = true;
                    }
                    break;
                } else {
                    System.out.println("Invalid Item.");
                }
            }
        }
    }

    public void collectAdamantium() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an pickax from your inventory. It has to be a Silver (or a stronger kind) pickax.");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Back")) {
                break;
            } else if (line.equals("WhereAmI")) {
                System.out.println("Choose an pickax from your inventory. It has to be a Silver (or a stronger kind) pickax.");
                Game.Parsa.backpack.printItems();
            } else {
                int j = 0;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if (j < 1 || j > Game.Parsa.backpack.getRange()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Objectable item = Game.Parsa.backpack.geti(j);
                if (item.type.equals("Pickax") && !item.name.equals("Stone Pickax") && !item.name.equals("Iron Pickax")) {
                    Pickax pickax = (Pickax) Game.Parsa.backpack.geti(j);
                    int a = pickax.numCollected(new Adamantium());
                    int e = pickax.energyChange(new Adamantium());
                    for (int i = 0; i < a; i++) {
                        Game.Parsa.backpack.putItem(new Adamantium());
                    }
                    Game.Parsa.energy -= e;
                    if (a == 0) {
                        System.out.println("You have collected nothing.");
                    } else {
                        System.out.println("You have collected " + a + " Adamantium(s)");
                    }
                    if (pickax.breaking(pickax.p)) {
                        System.out.println("Your pickax has broke during the operation.");
                        pickax.broken = true;
                    }
                    break;
                } else {
                    System.out.println("Invalid Item.");
                }
            }
        }
    }
}
