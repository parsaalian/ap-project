package game.objectable.Tools.Cooking;

import game.objectable.Tools.Tools;

public class Cooking extends Tools {
    public boolean isInShelf = false;

    public String status() {
        if (broken) {
            return ("A cooking utensil. (Broken)");
        }
        else {
            return ("A cooking utensil. (Not broken)");
        }
    }

    public Cooking(String name, String type) {
        super(name, type);
    }
}
