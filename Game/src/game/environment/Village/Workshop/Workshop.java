package game.environment.Village.Workshop;

import game.Game;
import game.objectable.Tools.Axe.Adamantium_Axe.Adamantium_Axe;
import game.objectable.Tools.Axe.Iron_Axe.Iron_Axe;
import game.objectable.Tools.Axe.Silver_Axe.Silver_Axe;
import game.objectable.Tools.Axe.Stone_Axe.Stone_Axe;
import game.objectable.Tools.Cooking.Frying_Pan.Frying_Pan;
import game.objectable.Tools.Cooking.Knife.Knife;
import game.objectable.Tools.Cooking.Mixer.Mixer;
import game.objectable.Tools.Cooking.Oven.Oven;
import game.objectable.Tools.Cooking.Pot.Pot;
import game.objectable.Tools.Fishing_Rod.Oak_FishingRod.Oak_FishingRod;
import game.objectable.Tools.Fishing_Rod.Old_FishingRod.Old_FishingRod;
import game.objectable.Tools.Fishing_Rod.Pine_FishingRod.Pine_FishingRod;
import game.objectable.Tools.Fishing_Rod.Small_FishingRod.Small_FishingRod;
import game.objectable.Tools.Milker.Milker;
import game.objectable.Tools.Pickax.Adamantium_Pickax.Adamantium_Pickax;
import game.objectable.Tools.Pickax.Iron_Pickax.Iron_Pickax;
import game.objectable.Tools.Pickax.Silver_Pickax.Silver_Pickax;
import game.objectable.Tools.Pickax.Stone_Piackax.Stone_Pickax;
import game.objectable.Tools.Scissors.Scissors;
import game.objectable.Tools.Shovel.Adamantium_Shovel.Adamantium_Shovel;
import game.objectable.Tools.Shovel.Iron_Shovel.Iron_Shovel;
import game.objectable.Tools.Shovel.Silver_Shovel.Silver_Shovel;
import game.objectable.Tools.Shovel.Stone_Shovel.Stone_Shovel;
import game.objectable.Tools.Tools;
import game.objectable.Tools.Watering_Can.Adamantium_WateringCan.Adamantium_WateringCan;
import game.objectable.Tools.Watering_Can.Iron_WateringCan.Iron_WateringCan;
import game.objectable.Tools.Watering_Can.Oak_WateringCan.Oak_WateringCan;
import game.objectable.Tools.Watering_Can.Old_WateringCan.Old_WateringCan;
import game.objectable.Tools.Watering_Can.Pine_WateringCan.Pine_WateringCan;
import game.objectable.Tools.Watering_Can.Silver_WateringCan.Silver_WateringCan;
import game.objectable.Tools.Watering_Can.Small_WateringCan.Small_WateringCan;
import game.objectable.Tools.Watering_Can.Stone_WateringCan.Stone_WateringCan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Workshop {
    private ArrayList<Tools> items = new ArrayList<>(Arrays.asList(new Stone_Axe(), new Iron_Axe(), new Silver_Axe(), new Adamantium_Axe(), new Stone_Pickax(), new Iron_Pickax(), new Silver_Pickax(), new Adamantium_Pickax(), new Stone_Shovel(), new Iron_Shovel(), new Silver_Shovel(), new Adamantium_Shovel(), new Small_WateringCan(), new Old_WateringCan(), new Pine_WateringCan(), new Oak_WateringCan(), new Stone_WateringCan(), new Iron_WateringCan(), new Silver_WateringCan(), new Adamantium_WateringCan(), new Small_FishingRod(), new Old_FishingRod(), new Pine_FishingRod(), new Oak_FishingRod(), new Scissors(), new Milker(), new Frying_Pan(), new Knife(), new Mixer(), new Oven(), new Pot()));
    public ArrayList<String> placesToGo = new ArrayList<>(Arrays.asList("Village"));

    public void inspect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Workshop:\n1. Check this shop\n2. Make a tool\n3. Repair a tool\n4. Disassemble a tool");
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("GoTo Village")) {
                Game.Parsa.goTo("Village");
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Workshop:\n1. Check this shop\n2. Make a tool\n3. Repair a tool\n4. Disassemble a tool");
            }
            else if(line.equals("1")) {
                check();
            }
            else if(line.equals("2")) {
                make();
            }
            else if(line.equals("3")) {
                repair();
            }
            else if(line.equals("4")) {
                disassemble();
            }
            else {
                System.out.println("Invalid Command!");
            }
        }
    }

    public ArrayList<Tools> setCanBuild() {
        ArrayList<Tools> ret = new ArrayList<>();
        for(Tools tool : items) {
            if(tool.canBuild()) {
                ret.add(tool);
            }
        }
        return ret;
    }

    public ArrayList<Tools> setCanRepair() {
        ArrayList<Tools> ret = new ArrayList<>();
        for(Tools tool : items) {
            if(tool.broken) {
                ret.add(tool);
            }
        }
        return ret;
    }

    private String brokenMenu() {
        StringBuilder res = new StringBuilder();
        int i = 1;
        ArrayList<Tools> canRepair = setCanRepair();
        for(Tools tool : canRepair) {
            res.append(i++ + ". " + tool.name + '\n');
        }
        return res.toString();
    }

    private String checkMenu() {
        StringBuilder res = new StringBuilder();
        int i = 1;
        ArrayList<Tools> canBuild = setCanBuild();
        for(Tools tool : canBuild) {
            res.append(i++ + ". " + tool.name + '\n');
        }
        return res.toString();
    }

    private void check() {
        Scanner scanner = new Scanner(System.in);
        checkMenu();
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                checkMenu();
            }
            else {
               int j;
               try {
                   j = Integer.parseInt(line);
               } catch (Exception e) {
                   System.out.println("Invalid Command!");
                   continue;
               }
               if(j < 1 || j > setCanBuild().size()) {
                   System.out.println("Out of range.");
                   continue;
               }
               Tools tool = setCanBuild().get(j - 1);
               tool.buildStatus();
            }
        }
    }

    private void make() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an item to build:");
        checkMenu();
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Choose an item to build:");
                checkMenu();
            }
            else {
                int j;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > setCanBuild().size()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Tools tool = setCanBuild().get(j - 1);
                tool.build();
            }
        }
    }

    private void repair() {
        Scanner scanner = new Scanner(System.in);
        brokenMenu();
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                brokenMenu();
            }
            else {
                int j;
                try {
                    j = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid Command!");
                    continue;
                }
                if(j < 1 || j > setCanRepair().size()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Tools tool = setCanRepair().get(j - 1);
                tool.repair();
            }
        }
    }

    private void disassemble() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a tool to disassemble:");
        Game.Parsa.backpack.printItems();
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Back")) {
                break;
            }
            else if(line.equals("WhereAmI")) {
                System.out.println("Choose a tool to disassemble:");
                Game.Parsa.backpack.printItems();
            }
            else {
                int j;
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
                try {
                    Tools tool = (Tools) Game.Parsa.backpack.geti(j);
                    tool.disassemble();
                } catch (Exception e) {
                    System.out.println("You have to choose a tool!");
                    continue;
                }
            }
        }
    }
}
