package network.public_chat;

import java.io.Serializable;

public class Status implements Serializable {
    private String name;
    private double health;
    private double maxHealth;
    private double energy;
    private double maxEnergy;
    private double stamina;
    private double maxStamina;
    private double satiety;
    private double maxSatiety;
    private int money;

    public Status(String name, double health, double maxHealth, double energy, double maxEnergy, double stamina, double maxStamina, double satiety, double maxSatiety, int money) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.energy = energy;
        this.maxEnergy = maxEnergy;
        this.stamina = stamina;
        this.maxStamina = maxStamina;
        this.satiety = satiety;
        this.maxSatiety = maxSatiety;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getEnergy() {
        return energy;
    }

    public double getMaxEnergy() {
        return maxEnergy;
    }

    public double getStamina() {
        return stamina;
    }

    public double getMaxStamina() {
        return maxStamina;
    }

    public double getSatiety() {
        return satiety;
    }

    public double getMaxSatiety() {
        return maxSatiety;
    }

    public int getMoney() {
        return money;
    }
}
