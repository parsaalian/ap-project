package custom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Read_Custom {
    String name, type;
    int health;
    int maxHealth;
    int energy;
    int maxEnergy;
    int stamina;
    int maxStamina;
    int satiety;
    int maxSatiety;

    public Read_Custom(File file) throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
    }
}
