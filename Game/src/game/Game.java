package game;

import game.environment.Farm.Arable.Arable;
import game.environment.Farm.Arable.Garden.Garden;
import game.environment.Farm.Arable.Field.Field;
import game.environment.Farm.Farm;
import game.environment.Jungle.Jungle;
import game.environment.Village.Village;
import game.farmer.Farmer;
import game.environment.*;
import game.objectable.Animals.Sheep.Sheep;

import java.util.Scanner;

public class Game {
    private static int day = 0;
    public static String season = "Autumn";
    public static Environment gamePlay = new Environment();
    public static Farmer Parsa = new Farmer();
    public static Farm farm = new Farm();
    public static Jungle jungle = new Jungle();
    public static Village village = new Village();

    public static void changeDay() {
        day++;
        Parsa.energy = Parsa.maxEnergy;
        for(Field field : farm.fields) {
            if(field.water) {
                field.age++;
            }
            field.water = false;
            field.plowed = false;
        }
        for(Garden garden : farm.gardens) {
            garden.birdsEatFruits();
            if(garden.water) {
                garden.dropSomeFruits();
            }
            garden.water = false;
        }
        for(Arable arable : farm.greenhouse.fields) {
            if(arable.type.equals("Apple") || arable.type.equals("Orange") || arable.type.equals("Peach") || arable.type.equals("Pear") || arable.type.equals("Lemon") || arable.type.equals("Pomegranate") || arable.type.equals("Pineapple")) {
                ((Garden) arable).birdsEatFruits();
                if(arable.water && arable.season.equals(farm.greenhouse.season)) {
                    ((Garden) arable).dropSomeFruits();
                }
                arable.water = false;
            }
            else {
                if(arable.water && arable.season.equals(farm.greenhouse.season)) {
                    ((Field) arable).age++;
                }
                arable.water = false;
                arable.plowed = false;
            }
        }
        for(Sheep sheep : farm.barn.sheeps) {
            sheep.shearDay++;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String line = scanner.nextLine();
                String input[] = line.split(" ");

                if (line.equals("end")) {
                    break;
                }

                if (line.equals("BackPack")) {
                    Parsa.backpack.inspectBackpack();
                }

                if (line.equals("Stats")) {
                    Parsa.stats();
                }

                if (input[0].equals("GoTo")) {
                    System.out.println(Parsa.goTo(input[1]));
                    Game.gamePlay.whereAmI();
                }

                if (input[0].equals("WhereAmI")) {
                    gamePlay.whereAmI();
                }

                if(gamePlay.place.equals("Greenhouse") && line.equals("GoTo Greenhouse")) {
                    farm.greenhouse.inspectGreenhouse();
                }

                if(gamePlay.place.equals("Workshop") && line.equals("GoTo Workshop")) {
                    village.workshop.inspect();
                }

                if(gamePlay.place.equals("Clinic") && line.equals("GoTo Clinic")) {
                    village.clinic.inspect();
                }

                if(gamePlay.place.equals("Ranch") && line.equals("GoTo Ranch")) {
                    village.ranch.inspect();
                }

                if(gamePlay.place.equals("Laboratory") && line.equals("GoTo Laboratory")) {
                    village.laboratory.inspect();
                }

                if(gamePlay.place.equals("Gym") && line.equals("GoTo Gym")) {
                    village.gym.inspect();
                }


                if (input[0].equals("Inspect")) {

                    if (gamePlay.getPlace().equals("Farm")) {
                        if (input[1].equals("Field")) {
                            farm.inspectFields();
                        }
                        if (input.length > 1 && input[1].equals("Fruit") && input[2].equals("Garden")) {
                            farm.inspectGardens();
                        }
                        if (input[1].equals("Pond")) {
                            farm.inspectPond();
                        }
                    }

                    if (gamePlay.getPlace().equals("Home")) {
                        if (input[1].equals("Bed")) {
                            farm.home.bed.inspectBed();
                        }
                        if (input[1].equals("Kitchen")) {
                            farm.home.kitchen.inspectKitchen();
                        }
                        if (input[1].equals("Storage") && input[2].equals("Box")) {
                            farm.home.storageBox.inspectStorageBox();
                        }
                    }

                    if(gamePlay.getPlace().equals("Barn")) {
                        if(input[1].equals("Cows")) {
                            farm.barn.inspectCows();
                        }
                        else if(input[1].equals("Sheep")) {
                            farm.barn.inspectSheeps();
                        }
                        else if(input[1].equals("Chickens")) {
                            farm.barn.inspectChicken();
                        }
                        else if(input[1].equals("Machines")) {
                            farm.barn.inspectMachines();
                        }
                    }

                    if(gamePlay.getPlace().equals("Jungle")) {
                        if(input[1].equals("Woods")) {
                            jungle.inspectWoods();
                        }
                        if(input[1].equals("Rocks")) {
                            jungle.inspectRocks();
                        }
                        if(input[1].equals("River")) {
                            jungle.inspectRiver();
                        }
                    }

                    if(gamePlay.getPlace().equals("Cave")) {
                        if(input[1].equals("Rocks")) {
                            jungle.cave.inspectRocks();
                        }
                    }
                    if (gamePlay.getPlace().equals("Cafe")){
                        if (input[1].equals("Mission") && input[2].equals("Board"))
                          village.cafe.inspectMissionBoard();
                        else if (input[1].equals("Dining") && input[2].equals("Table"))
                          village.cafe.inspectDiningTable();
                    }
                    if (gamePlay.getPlace().equals("Market")){
                        if (input[1].equals("Groceries"))
                            village.market.inspectGroceryStore();
                        else if (input[1].equals("General"))
                            village.market.inspectGeneralStore();
                        else if (input[1].equals("Butchery"))
                            village.market.inspectButchery();
                    }
                }
                if (input[0].equals("BackPack")) {
                    Parsa.backpack.inspectBackpack();
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
}
