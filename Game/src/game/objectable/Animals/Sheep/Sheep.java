package game.objectable.Animals.Sheep;

import game.Game;
import game.objectable.Animals.*;
import game.objectable.Goods.Wool.Wool;
import game.objectable.Objectable;

import java.util.Scanner;

public class Sheep extends Animals {
    public String name;
    public int shearDay= 0;

    public void inspect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sheep " + name + ":");
        System.out.println("1. Status\n2. Feed this sheep\n3. Heal this sheep\n4. Shear this sheep");
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Sheep " + name + ":");
                System.out.println("1. Status\n2. Feed this sheep\n3. Heal this sheep\n4. Shear this sheep");
            }
            else if(line.equals("1")) {
                status();
            }
            else if(line.equals("2")) {
                feedCowAndSheep();
            }
            else if(line.equals("3")) {
                heal();
            }
            else if(line.equals("4")) {
                shear();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("Sheep " + name + ":\n");
        res.append("Health: " + health + '\n');
        res.append("Satiety: " + satiety + '\n');
        res.append("Feed today: " + feedToday + '\n');
        res.append("Days to shear: " + (2 - shearDay) + '\n');
        return res.toString();
    }

    private void shear() {
        Scanner scanner = new Scanner(System.in);
        if (shearDay >= 2) {
            System.out.println("Choose Scissors:");
            Game.Parsa.backpack.printItems();
            while (true) {
                String line = scanner.nextLine();
                if (line.equals("Back")) {
                    break;
                } else if (line.equals("WhereAmI")) {
                    System.out.println("Choose Scissors:");
                    Game.Parsa.backpack.printItems();
                } else {
                    int j;
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
                    if (!item.name.equals("Scissors")) {
                        System.out.println("You have to scissors.");
                    } else {
                        System.out.println("Your sheep has been sheared.");
                        Game.Parsa.backpack.putItem(new Wool());
                        if(item.breaking(10)) {
                            System.out.println("Your scissors has been broken.");
                        }
                        shearDay = 0;
                    }
                }
            }
        }
        else {
            System.out.println("Sheep is not ready to shear.");
        }
    }

    public Sheep(String name) {
        super(name, "Sheep");
        this.name = name;
        this.money = 2500;
    }
}
