package game.environment.Village;

//import game.environment.Village.Cafe.Cafe;
import game.environment.Village.Cafe.Cafe;
import game.environment.Village.Clinic.Clinic;
import game.environment.Village.Gym.Gym;
import game.environment.Village.Laboratory.Laboratory;
import game.environment.Village.Market.Market;
import game.environment.Village.Ranch.Ranch;
import game.environment.Village.Workshop.Workshop;

import java.util.ArrayList;
import java.util.Arrays;

public class Village {
    public Market market = new Market();
    public Workshop workshop = new Workshop();
    public Clinic clinic = new Clinic();
    public Cafe cafe = new Cafe();
    public Ranch ranch = new Ranch();
    public Laboratory laboratory = new Laboratory();
    public Gym gym = new Gym();
    public ArrayList<String> placesToGo = new ArrayList<>(Arrays.asList("Market", "Workshop", "Clinic", "Cafe", "Ranch", "Laboratory", "Gym"));


    void inspectCafe(){
        //inspectMissionBoard();
        //inspectDiningTable();

    }

    void inspectRanch(){
        /*printMenu();
        if (BuyAnimal){
            chooseAnimal();
            if (possible){
                askYN();
                askName();
                addAnimal();
            }
        }*/
    }

    void inspectLab(){
        /*printMenu();
        if (checkMachines){
            printMachines();
            readMachine();
            printPriceReq();
        }
        else{
            printMachines();
            addMachine();
        }*/
    }

    void inspectGym() {
        /*while (1){
            skill = readSkill();
            property = readProperty();

        }*/
    }


}
