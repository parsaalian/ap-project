package game.objectable.Tools;

import game.Game;
import game.objectable.*;
import graphic.Handle.EnvGroup;
import graphic.Menu.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Tools extends Objectable {
    public ArrayList<Objectable> repairs = new ArrayList<>();
    public ArrayList<Objectable> needs = new ArrayList<>();
    public boolean broken = false;
    public String type;
    public String name;
    public int changeEnergy = 0;
    public int repairMoney = 0;
    public int buildMoney = 0;
    public int p;

    public void repair() {
        Scanner scanner = new Scanner(System.in);
        boolean made = false;
        status();
        while(true) {
            String yn = scanner.nextLine();
            if (yn.equals("Back") || yn.equals("N")) {
                break;
            } else if (yn.equals("WhereAmI")) {
                status();
            } else if (yn.equals("Y")) {
                ArrayList<Objectable> needsTemp = new ArrayList<>();
                for(Objectable objectable : needs) {
                    needsTemp.add(objectable);
                }
                if (Game.Parsa.money > repairMoney) {
                    Game.Parsa.money -= buildMoney;
                    ArrayList<Objectable> temp = new ArrayList<>();
                    while(true) {
                        if(needsTemp.size() > 0) {
                            int r = 0;
                            Objectable need = needsTemp.get(0);
                            for(Objectable item : needsTemp) {
                                if (item.name.equals(need.name)) {
                                    temp.add(item);
                                    r++;
                                }
                            }
                            for(Objectable item : temp) {
                                needsTemp.remove(item);
                            }
                            if(checkInBackpack(need, r) && getItemsBuild(need, r, name)) {

                            }
                            else {
                                System.out.println("You don't have enough " + need.name + " to build this tool.");
                                for(Objectable o : temp) {
                                    Game.Parsa.backpack.putItem(o);
                                }
                            }
                        }
                        else {
                            made = true;
                            break;
                        }
                    }
                }
                else {
                    System.out.println("You don't have enough money.");
                }
            }
            if (made) {
                this.broken = false;
                System.out.println("You have repaired " + name + ".");
            } else {
                System.out.println("You couldn't repair " + name + ".");
            }
        }
    }

    public void build() {
        Scanner scanner = new Scanner(System.in);
        if (Game.Parsa.backpack.capacity < 1) {
            System.out.println("You don't have enough capacity.");
            return;
        }
        boolean made = false;
        status();
        System.out.println("\nDo you want to make this tool? (Y/N)");
        String yn = scanner.nextLine();
        if (yn.equals("Back")) {

        }
        else if (yn.equals("WhereAmI")) {
            status();
            System.out.println("\nDo you want to make this tool? (Y/N)");
        }
        else if (yn.equals("Y")) {
            ArrayList<Objectable> needsTemp = new ArrayList<>();
            for(Objectable objectable : needs) {
                needsTemp.add(objectable);
            }
            if(Game.Parsa.money >= buildMoney) {
                Game.Parsa.money -= buildMoney;
                ArrayList<Objectable> temp = new ArrayList<>();
                while(true) {
                    if(needsTemp.size() > 0) {
                        int r = 0;
                        Objectable need = needsTemp.get(0);
                        for(Objectable item : needsTemp) {
                            if (item.name.equals(need.name)) {
                                temp.add(item);
                                r++;
                            }
                        }
                        for(Objectable item : temp) {
                            needsTemp.remove(item);
                        }
                        if(checkInBackpack(need, r) && getItemsBuild(need, r, name)) {
                            continue;
                        }
                        else {
                            System.out.println("You don't have enough " + need.name + " to build this tool.");
                            for(Objectable o : temp) {
                                Game.Parsa.backpack.putItem(o);
                            }
                        }
                    }
                    else {
                        made = true;
                        break;
                    }
                }
            }
            else {
                System.out.println("You don't have enough money.");
            }
        }
        if (made) {
            Game.Parsa.backpack.putItem(this);
            System.out.println("You have made " + this.name + ".");
        } else {
            System.out.println("You couldn't make " + this.name + ".");
        }
    }



    public boolean getItemsBuild(Objectable need, int r, String name) {
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

            }
        }
        return ret;
    }

    public boolean checkInBackpack(Objectable item, int r) {
        boolean ret = false;
        if(Game.Parsa.backpack.frequency(item) >= r) {
            ret = true;
        }
        return ret;
    }

    public String showItemStatus(ArrayList<Objectable> a) {
        StringBuilder res = new StringBuilder();
        ArrayList<String> items_names = new ArrayList<>();
        for (Objectable objectable : a) {
            items_names.add(objectable.name);
        }
        int i = 1;
        HashSet<String> items_rep = new HashSet<>(items_names);
        for(String string : items_rep) {
            if(Collections.frequency(items_names, string) > 1) {
                res.append(i++ + ". " + string + " x" + Integer.toString(Collections.frequency(items_names, string)) + '\n');
            }
            else {
                res.append(i++ + ". " + string + " " + Integer.toString(Collections.frequency(items_names, string)) + '\n');
            }
        }
        return res.toString();
    }

    public void disassemble() {
        Scanner scanner = new Scanner(System.in);
        if(broken) {
            System.out.println("Do you want to disassemble this " + name + " for: ");
            showItemStatus(repairs);
            System.out.println("(Y/N)");
            while (true) {
                String line = scanner.nextLine();
                if(line.equals("Back") || line.equals("N")) {
                    break;
                }
                else if(line.equals("WhereAmI")) {
                    System.out.println("Do you want to disassemble this broken " + name + " for: ");
                    showItemStatus(repairs);
                    System.out.println("(Y/N)");
                }
                else if(line.equals("Y")) {
                    for (Objectable objectable : repairs) {
                        Game.Parsa.backpack.putItem(objectable);
                    }
                    Game.Parsa.money += repairMoney / 2;
                    System.out.println(name + " disassembled.");
                    break;
                }
                else {
                    System.out.println("Invalid Command!");
                }
            }
        }
        else {
            System.out.println("Do you want to disassemble this tool for: ");
            showItemStatus(needs);
            System.out.println("(Y/N)");
            while (true) {
                String line = scanner.nextLine();
                if(line.equals("Back") || line.equals("N")) {
                    break;
                }
                else if(line.equals("WhereAmI")) {
                    System.out.println("Do you want to disassemble this tool for: ");
                    showItemStatus(repairs);
                    System.out.println("(Y/N)");
                }
                else if(line.equals("Y")) {
                    Game.Parsa.money += buildMoney / 2;
                    for(Objectable objectable : needs) {
                        Game.Parsa.backpack.putItem(objectable);
                    }
                    System.out.println(name + " disassembled.");
                    break;
                }
                else {
                    System.out.println("Invalid Command!");
                }
            }
        }
    }

    public boolean canBuild() {
        ArrayList<Objectable> backpackTemp = new ArrayList<>();
        ArrayList<Objectable> needsTemp = new ArrayList<>();
        for(Objectable item : Game.Parsa.backpack.items) {
            backpackTemp.add(item);
        }
        for(Objectable item : needs) {
            needsTemp.add(item);
        }
        for(int i = 0; i < needsTemp.size(); i++) {
            for(int j = 0; j < backpackTemp.size(); j++) {
                if(needsTemp.get(i).name.equals(backpackTemp.get(j).name)) {
                    needsTemp.remove(i);
                    backpackTemp.remove(j);
                    i--;
                    j--;
                    if(i < 0 || j < 0) {
                        break;
                    }
                }
            }
        }
        return needsTemp.size() == 0;
    }

    public String buildStatus() {
        StringBuilder res = new StringBuilder();
        res.append("Items need to build this tool:\n");
        res.append("Money: " + buildMoney + '\n');
        res.append(showItemStatus(needs));
        return res.toString();
    }

    public Tools(String name, String type) {
        super(name, type);
    }
}
