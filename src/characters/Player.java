package characters;

import items.Item;
import locations.Location;
import quests.Quest;


import java.util.ArrayList;

public class Player implements Character{
    private ArrayList<Item> inventory;
    private ArrayList<Quest> quests;
    private Location currentLocation;

    @Override
    public String getName() {
        // TODO
        return null;
    }

    @Override
    public void talk() {
        // TODO
    }

    public void moveTo(Location location) {
        // TODO
    }

    public void pickUp(Item item) {
        // TODO
    }

    public void useItem(Item item) {
        // TODO
    }
    public ArrayList<Item> getInventory() {
        //TODO
        return null; }

    public ArrayList<Quest> getQuests() {
        //TODO
        return null; }
}
