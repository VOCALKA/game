package characters;

import items.*;
import locations.Location;
import quests.Quest;


import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<Quest> quests = new ArrayList<>();
    private Location currentLocation;
    private String name;
    private Character currentDialogueNpc;


    public void addItem(Item item) {
        if (inventory.size() >= 2) {
            System.out.println("Inventář je plný! Musíš něco odložit.");
        } else {
            inventory.add(item);
            System.out.println(item.getName() + " přidán do inventáře.");
        }
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Player(String name, Location startLocation) {
        this.name = name;
        this.currentLocation = startLocation;
    }

    public void pickUp(Item item) {
        addItem(item);
        // TODO
    }

    public void useItem(Item item) {
        if (item == null) {
            System.out.println("Takový předmět nemáš.");
            return;
        }

        item.use(this);
        // TODO
    }
    public ArrayList<Item> getInventory() {
        //TODO
        return inventory;
    }

    public ArrayList<Quest> getQuests() {
        //TODO
        return quests;
    }
    public Item getItemByName(String name) {
        for (Item i : inventory) {
            if (i.getName().equalsIgnoreCase(name)) return i;
        }
        return null;
    }
    public boolean hasItem(String itemId) {
        for (Item item : inventory) {
            if (item.getId().equalsIgnoreCase(itemId)) {
                return true;
            }
        }
        return false;
    }

    public void setCurrentDialogueNpc(Character npc) {
        this.currentDialogueNpc = npc;
    }

    public Character getCurrentDialogueNpc() {
        return currentDialogueNpc;
    }
    public void endDialogue() {
        this.currentDialogueNpc = null;
    }
}
