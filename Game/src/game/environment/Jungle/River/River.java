package game.environment.Jungle.River;

import game.Game;
import game.objectable.Objectable;
import game.objectable.Tools.Fishing_Rod.Fishing_Rod;

import java.util.Scanner;

public class River {
    public void fish() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a fishing rod from your inventory.");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Back")) {
                break;
            }
            else if (line.equals("WhereAmI")) {
                System.out.println("Choose a fishing rod from your inventory.");
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
                if(item.type.equals("Fishing Rod")) {
                    Fishing_Rod fishing_rod = (Fishing_Rod) Game.Parsa.backpack.geti(j);
                    fishing_rod.getFish();
                    Game.Parsa.energy -= fishing_rod.changeEnergy;
                    if(fishing_rod.breaking(fishing_rod.p)) {
                        System.out.println("Your fishing rod has broke during the operation.");
                        fishing_rod.broken = true;
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
