package game.environment.Farm.Arable.Greenhouse;

import game.environment.Farm.Arable.*;
import game.environment.Farm.Arable.Field.Empty_Field.Empty_Field;
import game.environment.Farm.Arable.Garden.Garden;
import game.Game;
import game.objectable.Goods.Stone.Iron.Iron;
import game.objectable.Goods.Wood.Old_Lumber.Old_Lumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Greenhouse extends Arable {
    private boolean weatherMachine = false;
    private boolean out = false;
    public String Weather;
    public int dropped = 0;
    public ArrayList<String> placesToGo = new ArrayList<>(Arrays.asList("Farm"));
    public ArrayList<Arable> fields = new ArrayList<>(Arrays.asList(new Empty_Field(), new Empty_Field(), new Empty_Field(), new Empty_Field(), new Empty_Field(), new Empty_Field()));

    private String greenMenu() {
        StringBuilder res = new StringBuilder();
        int i = 1;
        res.append("Greenhouse Fields:\n");
        for(Arable field : fields) {
            res.append(i++ + ". " + field.type + " section\n");
        }
        return res.toString();
    }

    public void inspectGreenhouse() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (!weatherMachine) {
                System.out.println("Greenhouse:\n1. Repair Greenhouse");
                while (true) {
                    String line = scanner.nextLine();
                    if (line.equals("GoTo Farm")) {
                        Game.Parsa.goTo("Farm");
                        out = true;
                        break;
                    } else if (line.equals("WhereAmI")) {
                        System.out.println("Greenhouse:\n1. Repair Greenhouse");
                    } else {
                        int j;
                        try {
                            j = Integer.parseInt(line);
                        } catch (Exception e) {
                            System.out.println("Invalid Command!");
                            continue;
                        }
                        if (j != 1) {
                            System.out.println("Out of range.");
                            continue;
                        }
                        System.out.println("Do you want to repair greenhouse for 5000 Gil, 20 Old Lumbers and 20 Irons. Is this OK? (Y/N)");
                        while (true) {
                            String yn = scanner.nextLine();
                            if (yn.equals("Y")) {
                                if (Game.Parsa.money >= 5000) {
                                    if (Game.Parsa.backpack.frequency(new Iron()) >= 20) {
                                        if (Game.Parsa.backpack.frequency(new Old_Lumber()) >= 20) {
                                            Game.Parsa.money -= 5000;
                                            for (int i = 0; i < 20; i++) {
                                                Game.Parsa.backpack.takeItem(new Iron());
                                                Game.Parsa.backpack.takeItem(new Old_Lumber());
                                            }
                                            System.out.println("You have repaired weather machine.");
                                            weatherMachine = true;
                                            break;
                                        } else {
                                            System.out.println("You don't have enough Old Lumber");
                                        }
                                    } else {
                                        System.out.println("You don't have enough Iron.");
                                    }
                                } else {
                                    System.out.println("You don't have enough money.");
                                }
                            } else if (yn.equals("Back") || yn.equals("N")) {
                                break;
                            } else if (yn.equals("WhereAmI")) {
                                System.out.println("Do you want to repair greenhouse for 5000 Gil, 20 Old Lumbers and 20 Irons. Is this OK? (Y/N)");
                            }
                        }
                        if (weatherMachine) {
                            break;
                        }
                    }
                }
                if(out) {
                    out = false;
                    break;
                }
            }
            else {
                System.out.println("Greenhouse:\n1. Inspect Weather Machine\n2. Inspect Fields");
                while (true) {
                    String wf = scanner.nextLine();
                    if(wf.equals("GoTo Farm")) {
                        Game.Parsa.goTo("Farm");
                        out = true;
                        break;
                    }
                    else if(wf.equals("WhereAmI")) {
                        System.out.println("Greenhouse:\n1. Inspect Weather Machine\n2. Inspect Fields");
                    }
                    else if(wf.equals("1")) {
                        while(true) {
                            System.out.println("Choose Choose the Greenhouse’s weather:\n1. Spring weather\n2. Summer weather\n3. Autumn weather\n4. Tropical weather");
                            String w = scanner.nextLine();
                            if(w.equals("Back")) {
                                break;
                            }
                            else if(w.equals("WhereAmI")) {
                                System.out.println("Choose Choose the Greenhouse’s weather:\n1. Spring weather\n2. Summer weather\n3. Autumn weather\n4. Tropical weather");
                            }
                            else if(w.equals("1")) {
                                Weather = "Spring";
                                System.out.println("The greenhouse weather is " + Weather + " now");
                                break;
                            }
                            else if(w.equals("2")) {
                                Weather = "Summer";
                                System.out.println("The greenhouse weather is " + Weather + " now");
                                break;
                            }
                            else if(w.equals("3")) {
                                Weather = "Autumn";
                                System.out.println("The greenhouse weather is " + Weather + " now");
                                break;
                            }
                            else if(w.equals("4")) {
                                Weather = "Tropical";
                                System.out.println("The greenhouse weather is " + Weather + " now");
                                break;
                            }
                            else {
                                System.out.println("Invalid Command!");
                            }
                        }
                    }
                    else if(wf.equals("2")) {
                        greenMenu();
                        while (true) {
                            String f = scanner.nextLine();
                            if(f.equals("Back")) {
                                break;
                            }
                            else if(f.equals("WhereAmI")) {
                                greenMenu();
                            }
                            else {
                                int j = 0;
                                try {
                                    j = Integer.parseInt(f);
                                } catch (Exception e) {
                                    System.out.println("Invalid Command!");
                                }
                                if(j < 1 || j > fields.size()) {
                                    System.out.println("Out of range.");
                                    continue;
                                }
                                Arable field = fields.get(j - 1);
                                if(field.type.equals("Apple") || field.type.equals("Lemon") || field.type.equals("Orange") || field.type.equals("Peach") || field.type.equals("Pear") || field.type.equals("Pomegranate") || field.type.equals("Pineapple")) {
                                    field.inspectGarden();
                                    while (true) {
                                        String inGarden = scanner.nextLine();
                                        if (inGarden.equals("Back")) {
                                            break;
                                        }
                                        else if (inGarden.equals("WhereAmI")) {
                                            field.inspectGarden();
                                        }
                                        else if (inGarden.equals("1")) {
                                            field.status();
                                        }
                                        else if (inGarden.equals("2")) {
                                            field.water();
                                        }
                                        else if (inGarden.equals("3")) {
                                            ((Garden) field).collect();
                                        }
                                    }
                                }
                                else {
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
                                            else if (inField.equals("4")) {
                                                field.destroy();
                                                System.out.println("Field has been destroyed.");
                                            }
                                            else if (inField.equals("3")) {
                                                field.harvest();
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
                                                if(field.plantInGreenhouse()) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Invalid Command!");
                    }
                }
                if(out) {
                    out = false;
                    break;
                }
            }
        }
    }
}
