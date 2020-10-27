package game.environment.Village.Market;

import game.Game;
import game.objectable.Fruits_and_Vegs.Autumn.Autumn;
import game.objectable.Fruits_and_Vegs.Spring.Spring;
import game.objectable.Fruits_and_Vegs.Summer.Summer;
import game.objectable.Fruits_and_Vegs.Tropical.Tropical;
import game.objectable.Objectable;
import game.objectable.Fruits_and_Vegs.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Grocery_Store{

    public ArrayList <Fruits_and_Vegs> listItems(){
        ArrayList <Fruits_and_Vegs> list = new ArrayList<>();
        if (Game.season.equals("Autumn"))
            for (Autumn f : Fruits_and_Vegs.autumn_fruits)
                list.add(f);
        else if (Game.season.equals("Spring"))
            for (Spring s : Fruits_and_Vegs.spring_fruits)
                list.add(s);
        else if (Game.season.equals("Summer"))
            for (Summer s : Fruits_and_Vegs.summer_fruits)
                list.add(s);
        for (Tropical t : Fruits_and_Vegs.tropical_fruits)
            list.add(t);
        return list;
    }

    String printItems(ArrayList <Fruits_and_Vegs> list){
        StringBuilder res = new StringBuilder();
        int i = 1;
        for (Fruits_and_Vegs f : list)
            res.append(i++ + "." + f.name + '\n');
        return res.toString();
    }

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
                    ArrayList <Fruits_and_Vegs> list = listItems();
                    printItems(list);
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
                    if (id >= 0 && id < list.size()) {
                        list.get(id).status();
                        System.out.println("Price: " + list.get(id).money);
                    }
                }
                else if (choice == 1) {
                    ArrayList<Fruits_and_Vegs> list = listItems();
                    printItems(list);
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
                    if (item >= 0 && item < list.size()){
                        System.out.println("How many?");
                        line = scanner.nextLine();
                        int cnt;
                        try {
                            cnt = Integer.parseInt(line);
                        } catch (Exception e) {
                            System.out.println("Invalid Command");
                            continue;
                        }
                        if (cnt <= 0) continue;
                        int price = list.get(item).money * cnt;
                        System.out.println("You will buy " + list.get(item).name + " x" + cnt + " for " + price + " Gill. Is this okay? (Y/N)");
                        line = scanner.nextLine();
                        if (line.equals("Y") && Game.Parsa.backpack.capacity >= cnt && Game.Parsa.money >= price){
                            System.out.println("Accepted");
                            Game.Parsa.backpack.capacity--;
                            Game.Parsa.money -= price;
                            for (int i = 0; i < cnt; i++)
                                Game.Parsa.backpack.putItem(list.get(item));
                        }
                        else
                            System.out.println("Rejected");
                    }
                }
                else if (choice == 2) {
                    Game.Parsa.backpack.printItems();
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
                    if (item >= 0 && item < Game.Parsa.backpack.items.size()) {
                        Objectable obj = Game.Parsa.backpack.geti(item+1);
                        if (!Fruits_and_Vegs.tropical_fruits.contains(obj) && !Fruits_and_Vegs.autumn_fruits.contains(obj) &&
                                !Fruits_and_Vegs.spring_fruits.contains(obj) && !Fruits_and_Vegs.summer_fruits.contains(obj)){
                            System.out.println("Invalid item");
                            continue;
                        }
                        System.out.println("How many?");
                        line = scanner.nextLine();
                        int cnt;
                        try {
                            cnt = Integer.parseInt(line);
                        } catch (Exception e) {
                            System.out.println("Invalid Command");
                            continue;
                        }
                        if (cnt <= 0 || cnt > Game.Parsa.backpack.frequency(obj)){
                            System.out.println("Number of Items is not Valid.");
                            continue;
                        }
                        int price = obj.money * cnt;
                        System.out.println("You will sell " + obj.name + " x" + cnt + " for " + price + " Gil. Is this okay? (Y/N)");
                        line = scanner.nextLine();
                        if (line.equals("Y")){
                            System.out.println("Accepted");
                            Game.Parsa.money += price;
                            for (int i = 0; i < cnt; i++)
                                Game.Parsa.backpack.takeItem(obj);
                        }
                        else
                            System.out.println("Rejected");

                    }
                }
            }
        }
    }

    private String menu(){
        return  ("\nGroceries Store:\n" +
                "1. Check this shop\n" +
                "2. Buy an item\n" +
                "3. Sell an item\n");
    }


}


