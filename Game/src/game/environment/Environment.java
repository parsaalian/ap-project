package game.environment;

import game.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Environment {
    public String place;
    public ArrayList<String> places = new ArrayList<>(Arrays.asList("Farm", "Village", "Jungle"));
    public Game game;

    public String whereAmI() {
        if(place.equals("Farm")) {
            return("You are currently in the Farm\n\nPlaces you can go:\nBarn\nJungle\nGreenhouse\nHome\nVillage\n\nObjects you can interact with:\nField\nGarden\nPond");
        }
        if(place.equals("Home")) {
            return("You are currently in the Home\n\nPlaces you can go:\nFarm\n\nObjects you can interact with:\nBed\nStorage Box\nKitchen");
        }
        if(place.equals("Barn")) {
            return("You are currently in the Barn\n\nPlaces you can go:\nFarm\n\nObjects you can interact with:\nCows\nSheep\nChickens\nMachines");
        }
        if(place.equals("Jungle")) {
            return("You are currently in the Jungle\n\nPlaces you can go:\nFarm\nCave\n\nObjects you can interact with:\nWoods\nRocks\nRiver");
        }
        if(place.equals("Cave")) {
            return("You are currently in the Cave\n\nPlaces you can go:\nJungle\n\nObjects you can interact with:\nRocks");
        }
        if(place.equals("Village")) {
            return("You are currently in the Village\n\nPlaces you can go:\nMarket\nWorkshop\nClinic\nCafe\nRanch\nLaboratory\nGym\nFarm\nForest\n");
        }
        if (place.equals("Market")){
            return("You are currently in the Market\n\nPlaces you can go:\nVillage\n\nObjects you can interact with:\nGroceries Store\nGeneral Store\nButchery\n");
        }
        if (place.equals("Workshop")){
            return("You are currently in the Workshop\n\nPlaces you can go:\nVillage\n");

        }
        if (place.equals("Clinic")){
            return("You are currently in the Clinic\n\nPlaces you can go:\nVillage\n");

        }
        if (place.equals("Cafe")){
            return("You are currently in the Cafe\n\nPlaces you can go:\nVillage\n\nObjects you can interact with:\nMission Board\nDining Table\n");
        }
        if (place.equals("Ranch")){
            return("You are currently in the Ranch\n\nPlaces you can go:\nVillage\n");
        }
        if (place.equals("Laboratory")){
            return("You are currently in the Laboratory\n\nPlaces you can go:\nVillage\n");
        }
        if (place.equals("Gym")){
            return("You are currently in the Gym\n\nPlaces you can go:\nVillage\n");
        }
        return null;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }
}
