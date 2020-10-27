package game.objectable.Medicine;

import game.Game;
import game.objectable.Objectable;

import java.util.Scanner;

public class Medicine extends Objectable {
    public int addHealth;

    public String use() {
        Game.Parsa.health += addHealth;
        return (addHealth + " health points healed.");
    }

    public String status() {
        if(!name.equals("Animal Medicine")) {
            return ("It heals " + addHealth + " health points.");
        } else {
            return ("It heals animals fully.");
        }
    }

    public void buy() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("How many of this item you want to buy?");
            String r = scanner.nextLine();
            if(r.equals("Back")) {
                break;
            }
            else if(r.equals("WhereAmI")) {
                continue;
            }
            else {
                int j;
                try {
                    j = Integer.parseInt(r);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1) {
                    System.out.println("Out of range.");
                }
                if(Game.Parsa.backpack.capacity < 1) {
                    System.out.println("You can't buy any of this item.\nyou don't have enough capacity.");
                    break;
                }
                if(j > Game.Parsa.backpack.capacity) {
                    System.out.println("You don't have enough capacity for this amount.\ntry again.");
                    continue;
                }
                else {
                    System.out.println("Do you want to buy x" + j + " " + name + " for " + j * money + " Gil? (Y/N)");
                    while (true) {
                        String line = scanner.nextLine();
                        if (line.equals("Back") || line.equals("N")) {
                            break;
                        } else if (line.equals("WhereAmI")) {
                            System.out.println("Do you want to buy x" + j + " " + name + " for " + j * money + " Gil? (Y/N)");
                        } else if (line.equals("Y")) {
                            if (Game.Parsa.money < j * money) {
                                System.out.println("You don't have enough money.");
                                break;
                            }
                            System.out.println("You have bought " + j + " " + name + "(s).");
                            Game.Parsa.money -= j * money;
                            for(int i = 0; i < j; i++) {
                                Game.Parsa.backpack.putItem(this);
                            }
                            break;
                        } else {
                            System.out.println("Invalid Command!");
                        }
                    }
                }
                break;
            }
        }
    }

    public Medicine(String name) {
        super(name, "Medicine");
        this.inspectType = 1;
    }
}
