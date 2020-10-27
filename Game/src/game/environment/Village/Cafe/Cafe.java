package game.environment.Village.Cafe;

import game.environment.Village.Cafe.MissionBoard.MissionBoard;

/**
 * Created by seyedparsa on 5/23/2017 AD.
 */
public class Cafe {
    DiningTable dining_table = new DiningTable();
    MissionBoard mission_board = new MissionBoard();

    public void inspectMissionBoard() {
        mission_board.inspect();
    }

    public void inspectDiningTable() {
        dining_table.inspect();
    }
}
