package game.environment.Village.Market;

public class Market {
    public Butchery butchery = new Butchery();
    public General_Store general_store = new General_Store();
    public Grocery_Store grocery_store = new Grocery_Store();
    public void inspectGroceryStore(){
        grocery_store.inspect();
    }

    public void inspectGeneralStore(){
        general_store.inspect();
    }

    public void inspectButchery(){
        butchery.inspect();
    }
}
