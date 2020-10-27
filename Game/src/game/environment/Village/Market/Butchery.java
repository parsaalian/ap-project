package game.environment.Village.Market;

import game.Game;
import game.objectable.Animals.Animals;
import game.objectable.Goods.Food_Goods.Meat.Meat;

import java.util.ArrayList;
import java.util.Scanner;

public class Butchery {

    public void inspect() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            String inspectLine = scanner.nextLine();
            if (inspectLine.equals("Back")) {
                break;
            }
            else {
                int choice;
                try {
                    choice = Integer.parseInt(inspectLine) - 1;
                } catch (Exception e) {
                    System.out.println("Invalid Command");
                    continue;
                }

                if (choice == 0){
                    for (int i = 1; i <= Animals.animals.size(); i++)
                        System.out.println(i + "." + Animals.animals.get(i-1).type);
                    String line = scanner.nextLine();
                    if (line.equals("Back")){
                        continue;
                    }
                    int id;
                    try {
                        id = Integer.parseInt(line) - 1;
                    } catch (Exception e) {
                        System.out.println("Invalid Command");
                        continue;
                    }
                    if (id >= 0 && id < Animals.animals.size()) {
                        Animals.animals.get(id).status();
                        System.out.println("Price: " + Animals.animals.get(id).money);
                    }
                }
                else if (choice == 1) {
                    for (int i = 1; i <= Animals.animals.size(); i++)
                        System.out.println(i + "." + Animals.animals.get(i-1).type);
                    String line = scanner.nextLine();
                    if (line.equals("Back")) {
                        continue;
                    }
                    int item;
                    try {
                        item = Integer.parseInt(line) - 1;
                    } catch (Exception e) {
                        System.out.println("Invalid Command");
                        continue;
                    }
                    if (item >= 0 && item < Animals.animals.size()){
                        line = scanner.nextLine();
                        int cnt;
                        try {
                            cnt = Integer.parseInt(line);
                        } catch (Exception e) {
                            System.out.println("Invalid Command");
                            continue;
                        }
                        if (cnt <= 0) continue;
                        int price = Meat.meats.get(item).money * cnt;
                        System.out.println("You will buy " + Animals.animals.get(item).type + " x" + cnt + " for " + price + " Gill. Is this okay? (Y/N)");
                        line = scanner.nextLine();
                        if (line.equals("Y") && Game.Parsa.backpack.capacity >= cnt && Game.Parsa.money >= price){
                            Game.Parsa.money -= price;
                            for (int i = 0; i < cnt; i++)
                                Game.Parsa.backpack.putItem(Meat.meats.get(item));
                        }
                        else
                            System.out.println("Rejected");
                    }
                }
                else if (choice == 2) {
                    while (true) {
                        System.out.println("Choose the animal type you want to sell:\n1.Chicken\n2.Cow\n3.Sheep");
                        String line = scanner.nextLine();
                        if (line.equals("Back")) {
                            break;
                        }
                        int item;
                        try {
                            item = Integer.parseInt(line) - 1;
                        } catch (Exception e) {
                            System.out.println("Invalid Command");
                            continue;
                        }
                        if (item >= 0 && item < 3) {
                            ArrayList <Animals> list = new ArrayList<>();
                            if (item == 0){
                                for (int i = 0; i < Game.farm.barn.chickens.size(); i++) {
                                    System.out.println(i + 1 + "." + Game.farm.barn.chickens.get(i).name + "(" + Game.farm.barn.chickens.get(i).type + ")");
                                    list.add(Game.farm.barn.chickens.get(i));
                                }
                            }
                            else if (item == 1){
                                for (int i = 0; i < Game.farm.barn.cows.size(); i++) {
                                    System.out.println(i + 1 + "." + Game.farm.barn.cows.get(i).name + "(" + Game.farm.barn.cows.get(i).type + ")");
                                    list.add(Game.farm.barn.cows.get(i));
                                }
                            }
                            else
                                for (int i = 0; i < Game.farm.barn.sheeps.size(); i++) {
                                    System.out.println(i + 1 + "." + Game.farm.barn.sheeps.get(i).name + "(" + Game.farm.barn.sheeps.get(i).type + ")");
                                    list.add(Game.farm.barn.sheeps.get(i));
                                }
                            line = scanner.nextLine();
                            int id;
                            try {
                                id = Integer.parseInt(line) - 1;
                            } catch (Exception e) {
                                System.out.println("Invalid Command");
                                continue;
                            }
                            if (id >= 0 && id < list.size()){
                                System.out.println("\n1.Status\n2.Sell this animal\n");
                                line = scanner.nextLine();
                                int which;
                                try {
                                    which = Integer.parseInt(line) - 1;
                                } catch (Exception e) {
                                    System.out.println("Invalid Command");
                                    continue;
                                }
                                if (which == 0){
                                    list.get(id).status();
                                }
                                else if (which == 1){
                                    int price = list.get(id).money;
                                    System.out.println("You will sell " + list.get(id).type + " No." + id+1 + " for " + price + " Gil. Is this okay? (Y/N)");
                                    line = scanner.nextLine();
                                    if (line.equals("Y")){
                                        Game.Parsa.money += price;
                                        if (item == 0) Game.farm.barn.chickens.remove(id);
                                        if (item == 1) Game.farm.barn.cows.remove(id);
                                        if (item == 2) Game.farm.barn.sheeps.remove(id);
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    private String menu(){
        return "\nButchery:\n" +
                "1. Check this shop\n" +
                "2. Buy an item\n" +
                "3. Sell an animal\n";
    }
}
