package game.objectable.Fruits_and_Vegs;

import game.Game;
import game.objectable.Fruits_and_Vegs.Autumn.Apple.Apple;
import game.objectable.Fruits_and_Vegs.Autumn.Autumn;
import game.objectable.Fruits_and_Vegs.Autumn.Carrot.Carrot;
import game.objectable.Fruits_and_Vegs.Autumn.Melon.Melon;
import game.objectable.Fruits_and_Vegs.Autumn.Orange.Orange;
import game.objectable.Fruits_and_Vegs.Autumn.Potato.Potato;
import game.objectable.Fruits_and_Vegs.Autumn.Tomato.Tomato;
import game.objectable.Fruits_and_Vegs.Spring.Bean.Bean;
import game.objectable.Fruits_and_Vegs.Spring.Eggplant.Eggplant;
import game.objectable.Fruits_and_Vegs.Spring.Garlic.Garlic;
import game.objectable.Fruits_and_Vegs.Spring.Lettuce.Lettuce;
import game.objectable.Fruits_and_Vegs.Spring.Peach.Peach;
import game.objectable.Fruits_and_Vegs.Spring.Pear.Pear;
import game.objectable.Fruits_and_Vegs.Spring.Spring;
import game.objectable.Fruits_and_Vegs.Summer.Cucumber.Cucumber;
import game.objectable.Fruits_and_Vegs.Summer.Lemon.Lemon;
import game.objectable.Fruits_and_Vegs.Summer.Onion.Onion;
import game.objectable.Fruits_and_Vegs.Summer.Pomegranate.Pomegranate;
import game.objectable.Fruits_and_Vegs.Summer.Summer;
import game.objectable.Fruits_and_Vegs.Summer.Turnip.Turnip;
import game.objectable.Fruits_and_Vegs.Summer.Watermelon.Watermelon;
import game.objectable.Fruits_and_Vegs.Tropical.Pepper.Pepper;
import game.objectable.Fruits_and_Vegs.Tropical.Pineapple.Pineapple;
import game.objectable.Fruits_and_Vegs.Tropical.Strawberry.Strawberry;
import game.objectable.Fruits_and_Vegs.Tropical.Tropical;
import game.objectable.Objectable;

import java.util.ArrayList;
import java.util.Arrays;

public class Fruits_and_Vegs extends Objectable {
    public int removal = 0;
    public int toDrop = 0;
    public int addHealth = 0;
    public int addEnergy = 0;
    public int addMaxHealth = 0;
    public int addMaxEnergy = 0;
    public String season;
    public String name;

    public Fruits_and_Vegs() {
        super();
    }

    public String getSeason() {
        return season;
    }

    public String status() {
        StringBuilder res = new StringBuilder();
        res.append("A(n) " + name + "! It can be used while cooking.\n");
        if(addHealth != 0) {
            res.append("Health: " + addHealth + '\n');
        }
        if(addEnergy != 0) {
            res.append("Energy: " + addEnergy + '\n');
        }
        if(addMaxHealth != 0) {
            res.append("Maximum Health: " + addMaxHealth + '\n');
        }
        if(addMaxEnergy != 0) {
            res.append("Maximum Energy: " + addMaxEnergy + '\n');
        }
        return res.toString();
    }

    public String use() {
        StringBuilder res = new StringBuilder();
        if(addHealth != 0) {
            res.append("Adding Health: " + addHealth + '\n');
            Game.Parsa.health += addHealth;
        }
        if(addEnergy != 0) {
            res.append("Adding Energy: " + addEnergy + '\n');
            Game.Parsa.energy += addEnergy;
        }
        if(addMaxHealth != 0) {
            res.append("Adding Maximum Health: " + addMaxHealth + '\n');
            Game.Parsa.maxHealth += addMaxHealth;
        }
        if(addMaxEnergy != 0) {
            res.append("Adding Maximum Energy: " + addMaxEnergy + '\n');
            Game.Parsa.maxEnergy += addMaxEnergy;
        }
        return res.toString();
    }

    public Fruits_and_Vegs(String name) {
        super(name, name);
        this.inspectType = 1;
    }
    public static ArrayList <Autumn> autumn_fruits = new ArrayList<>(Arrays.asList(new Apple(), new Carrot(), new Melon(), new Orange(), new Potato(), new Tomato()));
    public static ArrayList <Spring> spring_fruits = new ArrayList<>(Arrays.asList(new Bean(), new Eggplant(), new Garlic(), new Lettuce(), new Peach(), new Pear()));
    public static ArrayList <Summer> summer_fruits = new ArrayList<>(Arrays.asList(new Cucumber(), new Lemon(), new Onion(), new Pomegranate(), new Turnip(), new Watermelon()));
    public static ArrayList <Tropical> tropical_fruits = new ArrayList<>(Arrays.asList(new Pepper(), new Pineapple(), new Strawberry()));

}
