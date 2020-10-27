package game.environment.Village.Cafe.MissionBoard;

import game.objectable.Objectable;

import java.util.ArrayList;

/**
 * Created by seyedparsa on 5/24/2017 AD.
 */
public class Mission {
    public ArrayList<Req> reqs = new ArrayList<>();
    public ArrayList<Objectable> prize = new ArrayList<>();
    public ArrayList<Integer> prizeCnt = new ArrayList<Integer>();
    public int deposit;
    public int deadline;
    String name = "MardAfkan";
    Mission (){

    }

    public String status(){
        StringBuilder res = new StringBuilder();
        res.append("Requirements:\n");
        for (int i = 0; i < reqs.size(); i++)
            res.append(i+1 + "." + reqs.get(i).obj.name + " (x" + reqs.get(i).needed + ")\n");
        res.append("Prizes:\n");
        for (int i = 0; i < prize.size(); i++)
            res.append(i+1 + "." + prize.get(i).name + " (x" + prizeCnt.get(i) + "\n");
        res.append("Deposit: " + deposit + '\n');
        res.append("Deadline: " + deadline + " days.\n");
        return res.toString();
    }

    public String progressStatus(){
        StringBuilder res = new StringBuilder();
        res.append("Mission progress:\n");
        for (int i = 0; i < reqs.size(); i++){
            res.append(i+1 + ". " + reqs.get(i).obj.name + " (" + reqs.get(i).prepared + "/" + reqs.get(i).needed + ")\n");
        }
        return res.toString();
    }

    boolean Completed(){
        for (int i = 0; i < reqs.size(); i++)
            if (reqs.get(i).needed > reqs.get(i).prepared)
                return false;
        return true;
    }

}

class Req{
    public Objectable obj = new Objectable();
    public int needed, prepared;
    Req (Objectable o, int n){
        obj = o;
        needed = n;
        prepared = 0;
    }
}
