package game.environment.Farm;

import game.environment.Farm.Arable.Garden.Pomegranate.*;
import game.environment.Farm.Arable.Field.Empty_Field.*;
import game.environment.Farm.Arable.Garden.Orange.*;
import game.environment.Farm.Arable.Garden.Apple.*;
import game.environment.Farm.Arable.Garden.Lemon.*;
import game.environment.Farm.Arable.Garden.Peach.*;
import game.environment.Farm.Arable.Garden.Pear.*;
import game.environment.Farm.Arable.Garden.*;
import game.environment.Farm.Arable.Field.*;
import game.environment.Farm.Arable.Greenhouse.Greenhouse;
import game.environment.Farm.Home.*;
import game.environment.Farm.Barn.*;
import game.environment.Farm.Pond.*;
import java.util.ArrayList;
import game.environment.*;
import game.Game;
import game.objectable.Tools.Watering_Can.Watering_Can;

import java.util.Arrays;
import java.util.*;

public class Farm extends Environment {
    private Pond pond = new Pond();
    public Home home = new Home();
    public Barn barn = new Barn();
    public Greenhouse greenhouse = new Greenhouse();
    public ArrayList<Garden> gardens = new ArrayList<>(Arrays.asList(new peachTree(), new pearTree(), new lemonTree(), new pomegranateTree(), new appleTree(), new orangeTree()));
    public ArrayList<Field> fields = new ArrayList<>(Arrays.asList(new Empty_Field(), new Empty_Field(), new Empty_Field(), new Empty_Field(), new Empty_Field(), new Empty_Field()));
    public ArrayList<String> placesToGo = new ArrayList<>(Arrays.asList("Barn", "Forest", "Greenhouse", "Home", "Village"));

    private String gardenMenu() {
        StringBuilder res = new StringBuilder();
        int i = 1;
        res.append("Fruit Garden:\n");
        for(Garden tree : gardens) {
            if(!tree.buy) {
                res.append(i++ + ". Buy " + tree.type + " Tree\n");
            }
            else {
                res.append(i++ + ". " + tree.type + " Tree\n");
            }
        }
        return res.toString();
    }

    private String fieldMenu() {
        StringBuilder res = new StringBuilder();
        int i = 1;
        res.append("Field\n");
        for(Field field : fields) {
            res.append(i++ + ". " + field.type + " Field\n");
        }
        return res.toString();
    }

    private Field inspectField(int i) {
        return fields.get(i);
    }

    public void inspectFields() {
        Scanner scanner = new Scanner(System.in);
        fieldMenu();
        while (true) {
            String inspectLine = scanner.nextLine();
            if (inspectLine.equals("Back")) {
                break;
            }
            else if (inspectLine.equals("WhereAmI")) {
                fieldMenu();
            }
            else {
                int i;
                try {
                    i = Integer.parseInt(inspectLine);
                } catch (Exception e) {
                    System.out.println("Invalid Command");
                    continue;
                }
                if(i < 0 || i > fields.size()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Field field = inspectField(i - 1);
                field.inspectField();
                while (true) {
                    String inField = scanner.nextLine();
                    if (!field.type.equals("Empty")) {
                        if (inField.equals("Back")) {
                            break;
                        }
                        else if (inField.equals("WhereAmI")) {
                            field.inspectField();
                        }
                        else if (inField.equals("1")) {
                            field.status();
                        }
                        else if (inField.equals("2")) {
                            field.water();
                        }
                        else if (inField.equals("3")) {
                            field.harvest();
                        }
                        else if (inField.equals("4")) {
                            field.destroy();
                            System.out.println("Field has been destroyed.");
                        }
                    }
                    else {
                        if (inField.equals("Back")) {
                            break;
                        }
                        else if (inField.equals("WhereAmI")) {
                            field.inspectField();
                        }
                        else if (inField.equals("1")) {
                            field.status();
                        }
                        else if (inField.equals("2")) {
                           field.plow();
                        }
                        else if (inField.equals("3")) {
                           field.water();
                        }
                        else if (inField.equals("4")) {
                            if(field.plant()) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void inspectGardens() {
        Scanner scanner = new Scanner(System.in);
        gardenMenu();
        while (true) {
            String inspectLine = scanner.nextLine();
            if (inspectLine.equals("Back")) {
                break;
            }
            else if (inspectLine.equals("WhereAmI")) {
                gardenMenu();
            }
            else {
                int i;
                try {
                    i = Integer.parseInt(inspectLine);
                } catch (Exception e) {
                    System.out.println("Invalid Command");
                    continue;
                }
                if(i < 1 || i > gardens.size()) {
                    System.out.println("Out of range.");
                    continue;
                }
                Garden garden = gardens.get(i - 1);
                if (!garden.buy) {
                    if(!Game.season.equals(garden.under.getSeason())) {
                        System.out.println("You can't buy this tree in this season.");
                        continue;
                    }
                    System.out.println("This will cost you " + garden.money + " Gil. Is this OK? (Y/N)");
                    String YN = scanner.nextLine();
                    if (YN.equals("Y") && Game.Parsa.money >= garden.money && Game.season.equals(garden.under.getSeason())) {
                        garden.buy();
                        Game.Parsa.money -= garden.money;
                        System.out.println("You have bought this garden.");
                    }
                    else if (YN.equals("Y") && Game.Parsa.money < garden.money) {
                        System.out.println("You don't have enough money.");
                    }
                }
                else {
                    garden.inspectGarden();
                    while (true) {
                        String tree = scanner.nextLine();
                        if (tree.equals("Back")) {
                            break;
                        }
                        else if (tree.equals("WhereAmI")) {
                            garden.inspectGarden();
                        }
                        else if (tree.equals("1")) {
                            garden.status();
                        }
                        else if (tree.equals("2")) {
                            garden.water();
                        }
                        else if (tree.equals("3")) {
                            garden.collect();
                        }
                    }
                }
            }
        }
    }

    public void inspectPond() {
        Scanner scanner = new Scanner(System.in);
        pond.inspect();
        while (true) {
            String fill = scanner.nextLine();
            if (fill.equals("Back")) {
                break;
            }
            else if (fill.equals("WhereAmI")) {
                pond.inspect();
            }
            else if (fill.equals("1")) {
                System.out.println("Choose a Watering Can to use:");
                Game.Parsa.backpack.printItems();
                while (true) {
                    String choice = scanner.nextLine();
                    if (choice.equals("Back")) {
                        break;
                    }
                    else if (choice.equals("WhereAmI")) {
                        Game.Parsa.backpack.printItems();
                    }
                    else {
                        Watering_Can WaterCan = new Watering_Can(choice);
                        if (Game.Parsa.backpack.itemClass(WaterCan) == null) {
                            System.out.println("You have to choose a Watering Can");
                        }
                        else {
                            WaterCan = (Watering_Can) Game.Parsa.backpack.itemClass(WaterCan);
                            if (WaterCan.broken) {
                                System.out.println("Watering Can is broken");
                            }
                            else {
                                pond.getWater();
                                WaterCan.fullCan();
                            }
                        }
                    }
                }
            }
        }
    }

    public Farm() {
        super();
    }
}
