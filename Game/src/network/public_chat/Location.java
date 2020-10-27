package network.public_chat;

import java.io.Serializable;

public class Location implements Serializable {
    protected static final long serialVersionUID = 1112122201L;

    private boolean isInVillage;
    private String name;
    private double x, y;

    public Location(double x, double y, String name, boolean isInVillage) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.isInVillage = isInVillage;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isInVillage() {
        return isInVillage;
    }

    public String getName() {
        return name;
    }
}
