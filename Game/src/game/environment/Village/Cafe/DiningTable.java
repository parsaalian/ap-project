package game.environment.Village.Cafe;

import game.Game;
import game.objectable.Food.Human_Food.Human_Food;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by seyedparsa on 5/23/2017 AD.
 */
public class DiningTable {

    String menu(){
        return "1.Check the menu\n2.Buy a meal\n";
    }
    ArrayList<Human_Food> listItems(){
        ArrayList <Human_Food> list = new ArrayList<>();
        for (Human_Food hf : Human_Food.list)
            list.add(hf);
        return list;
    }

    String printItems(ArrayList <Human_Food> list){
        StringBuilder res = new StringBuilder();
        int i = 1;
        for (Human_Food hf : list)
            res.append(i++ + "." + hf.name + '\n');
        return res.toString();
    }

    void inspect(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            menu();
            String line = scanner.nextLine();
            if (line.equals("Back"))
                break;
            int choice;
            try{
                choice = Integer.parseInt(line) - 1;
            }
            catch (Exception e){
                System.out.println("Invalid Command");
                continue;
            }
            if (choice == 0){
                ArrayList <Human_Food> list = listItems();
                printItems(list);
                line = scanner.nextLine();
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
                    list.get(item).status();
                }
            }
            else if (choice == 1){
                ArrayList <Human_Food> list = listItems();
                printItems(list);
                line = scanner.nextLine();
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
                    int price = list.get(item).money;
                    System.out.println("You will buy " + list.get(item).name + " for " + price + " Gill. Is this okay? (Y/N)");
                    line = scanner.nextLine();
                    if (line.equals("Y") && Game.Parsa.money >= price){
                        System.out.println("Accepted");
                        Game.Parsa.money -= price;
                        //add energy
                    }
                    else
                        System.out.println("Rejected");
                }
            }
        }
    }
}
