package game.environment.Farm.Home.Storage_Box;

import game.Game;
import game.objectable.*;

import java.util.*;

public class Storage_Box {
    private ArrayList<Objectable> items = new ArrayList<>();

    public void inspect() {
        System.out.println("Storage Box:\n1. Put in item\n2. Take out item");
    }

    public void takeItem(Objectable objectable) {
        items.remove(objectable);
    }

    public void putItem(Objectable objectable) {
        items.add(objectable);
    }

    public String printItems() {
        StringBuilder res = new StringBuilder();
        ArrayList<String> items_names = new ArrayList<>();
        for (Objectable objectable : items) {
            items_names.add(objectable.name);
        }
        int i = 1;
        HashSet<String> items_rep = new HashSet<>(items_names);
        for(String string : items_rep) {
            String repeat = "";
            if(Collections.frequency(items_names, string) > 1) {
                repeat = "x" + Integer.toString(Collections.frequency(items_names, string));
            }
            res.append(i++ + "." + " " + string + " " + repeat + "\n");
        }
        return res.toString();
    }

    private int frequency(Objectable get) {
        ArrayList<String> items_names = new ArrayList<>();
        for (Objectable objectable : items) {
            items_names.add(objectable.name);
        }
        return Collections.frequency(items_names, get.name);
    }

    private int getRange() {
        ArrayList<String> items_names = new ArrayList<>();
        for (Objectable objectable : items) {
            items_names.add(objectable.name);
        }
        HashSet<String> items_rep = new HashSet<>(items_names);
        items_names = new ArrayList<>();
        for(String string :items_rep) {
            items_names.add(string);
        }
        return items_rep.size();
    }

    private Objectable getByName(String name) {
        Objectable ret = null;
        for(Objectable item : items) {
            if(item.name.equals(name)) {
                ret = item;
                break;
            }
        }
        return ret;
    }

    public Objectable geti(int k) {
        String name;
        Objectable ret = null;
        ArrayList<String> items_names = new ArrayList<>();
        for (Objectable objectable : items) {
            items_names.add(objectable.name);
        }
        HashSet<String> items_rep = new HashSet<>(items_names);
        items_names = new ArrayList<>();
        for(String string :items_rep) {
            items_names.add(string);
        }
        name = items_names.get(k - 1);
        for(Objectable item : items) {
            if(Objects.equals(item.name, name)) {
                ret = item;
                break;
            }
        }
        return ret;
    }

    public void inspectStorageBox() {
        Scanner scanner = new Scanner(System.in);
        inspect();
        while (true) {
            String box = scanner.nextLine();
            if (box.equals("Back")) {
                break;
            }
            else if (box.equals("WhereAmI")) {
                inspect();
            }
            else if (box.equals("1")) {
                System.out.println("Choose items from your Backpack to put in:");
                Game.Parsa.backpack.printItems();
                while (true) {
                    String item = scanner.nextLine();
                    if (item.equals("Back")) {
                        break;
                    }
                    else if (item.equals("WhereAmI")) {
                        System.out.println("Choose items from your Backpack to put in:");
                        Game.Parsa.backpack.printItems();
                    }
                    else {
                        int j;
                        Objectable get;
                        try {
                            j = Integer.parseInt(item);
                        } catch (Exception e) {
                            continue;
                        }
                        if (j > 0 && j <= Game.Parsa.backpack.getRange()) {
                            get = Game.Parsa.backpack.geti(j);
                        }

                        else {
                            System.out.println(Game.Parsa.backpack.getRange());
                            System.out.println("Out of range.");
                            continue;
                        }
                        if (Game.Parsa.backpack.frequency(get) > 1) {
                            System.out.println("How many of this item you want to choose?");
                            int n = scanner.nextInt();
                            if (n > Game.Parsa.backpack.frequency(get)) {
                                System.out.println("You have chosen too much.");
                            }
                            else {
                                for (int i = 0; i < n; i++) {
                                    Objectable takei = Game.Parsa.backpack.geti(j);
                                    Game.Parsa.backpack.takeItem(takei);
                                    putItem(takei);
                                }
                                System.out.println(n + " " + get.name + "'s has been removed to storage box.");
                                if(Game.Parsa.backpack.getRange() == 0) {
                                    System.out.println("Backpack is empty now.\n");
                                    inspect();
                                    break;
                                }
                                System.out.println("Choose items from your Backpack to put in:");
                                Game.Parsa.backpack.printItems();
                            }
                        }
                        else {
                            Game.Parsa.backpack.takeItem(get);
                            putItem(get);
                            System.out.println(get.name + " has been removed to storage box");
                            if(Game.Parsa.backpack.getRange() == 0) {
                                System.out.println("Backpack is empty now.\n");
                                inspect();
                                break;
                            }
                            System.out.println("Choose items from your Backpack to put in:");
                            Game.Parsa.backpack.printItems();
                        }
                    }
                }
            }
            else if (box.equals("2")) {
                printItems();
                while (true) {
                    String get = scanner.nextLine();
                    if (get.equals("Back")) {
                        break;
                    }
                    else if (get.equals("WhereAmI")) {
                        printItems();
                    }
                    else {
                        int j;
                        Objectable item;
                        try {
                            j = Integer.parseInt(get);
                        } catch (Exception e) {
                            continue;
                        }
                        if(j > 0 && j <= getRange()) {
                            item = geti(j);
                        }
                        else {
                            System.out.println("Out of range.");
                            continue;
                        }
                        if (frequency(item) > 1) {
                            System.out.println("How many of this item you want to choose?");
                            int n = scanner.nextInt();
                            if (n > frequency(item)) {
                                System.out.println("You have chosen too much.");
                            }
                            else {
                                if (Game.Parsa.backpack.capacity > n * item.capacity) {
                                    for (int i = 0; i < n; i++) {
                                        Objectable takei = geti(j);
                                        takeItem(takei);
                                        Game.Parsa.backpack.putItem(takei);
                                    }
                                    System.out.println(n + " " + item.name + "s has been removed to backpack.");
                                    if(getRange() == 0) {
                                        System.out.println("Storage Box is empty now.\n");
                                        inspect();
                                        break;
                                    }
                                    printItems();
                                }
                                else {
                                    System.out.println("You don't have enough capacity.");
                                }
                            }
                        }
                        else {
                            if (Game.Parsa.backpack.capacity > item.capacity) {
                                takeItem(item);
                                Game.Parsa.backpack.putItem(item);
                                System.out.println(item.name + " has been removed to your backpack");
                                if(getRange() == 0) {
                                    System.out.println("Storage Box is empty now.\n");
                                    inspect();
                                    break;
                                }
                                printItems();
                            }
                            else {
                                System.out.println("You don't have enough capacity.");
                            }
                        }
                    }
                }
            }
        }
    }
}
