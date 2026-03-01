package characters;

import items.*;
import locations.Location;
import quests.Quest;
import quests.QuestData;


import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<QuestData> quests = new ArrayList<>();
    private Location currentLocation;
    private String name;
    private Character currentDialogueNpc;


    /**
     * Adds an item to the player's inventory if there is space.
     * @param item the item to add
     */
    public void addItem(Item item) {
        if (inventory.size() >= 2) {
            System.out.println("Inventář je plný! Musíš něco odložit.");
        } else {
            inventory.add(item);
            System.out.println(item.getName() + " přidán do inventáře.");
        }
    }

    /**
     * Removes an item from the player's inventory.
     * @param item the item to remove
     */
    public void removeItem(Item item) {
        inventory.remove(item);
    }


    /**
     * Gets the current location of the player.
     * @return current location
     */
    public Location getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Sets the current location of the player.
     * @param currentLocation the location to move the player to
     */
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Player(String name, Location startLocation) {
        this.name = name;
        this.currentLocation = startLocation;
    }

    /*public void pickUp(Item item) {
        addItem(item);
        // TODO
    }*/

    /*public void useItem(Item item) {
        if (item == null) {
            System.out.println("Takový předmět nemáš.");
            return;
        }

        item.use(this);
        // TODO
    }*/
    /**
     * Returns the list of items in the inventory.
     * @return list of items
     */
    public ArrayList<Item> getInventory() {
        //TODO
        return inventory;
    }

    /**
     * Returns the list of quests the player currently has.
     * @return list of quests
     */
    public ArrayList<QuestData> getQuests() {
        //TODO
        return quests;
    }

    /**
     * Gets an item from the inventory by its name (case-insensitive).
     * @param name the name of the item
     * @return the matching item, or null if not found
     */
    public Item getItemByName(String name) {
        for (Item i : inventory) {
            if (i.getName().equalsIgnoreCase(name)) return i;
        }
        return null;
    }

    /**
     * Checks if the player has a specific item by ID.
     * @param itemId the item ID to check
     * @return true if the item is in the inventory, false otherwise
     */
    public boolean hasItem(String itemId) {
        for (Item item : inventory) {
            if (item.getId().equalsIgnoreCase(itemId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the NPC the player is currently interacting with.
     * @param npc the NPC to set
     */
    public void setCurrentDialogueNpc(Character npc) {
        this.currentDialogueNpc = npc;
    }
    /**
     * Removes an item from the inventory by its ID.
     * @param id the ID of the item to remove
     */
    public void removeItemById(String id) {
        inventory.removeIf(i -> i.getId().equalsIgnoreCase(id));
    }

    /**
     * Returns the NPC the player is currently interacting with.
     * @return current dialogue NPC
     */
    public Character getCurrentDialogueNpc() {
        return currentDialogueNpc;
    }
    /*public void endDialogue() {
        this.currentDialogueNpc = null;
    }*/
    private main.GameData gameData;

    /**
     * Sets the game's data reference.
     * @param gameData the GameData instance
     */
    public void setGameData(main.GameData gameData) {
        this.gameData = gameData;
    }

    /**
     * Returns the game's data reference.
     * @return GameData instance
     */
    public main.GameData getGameData() {
        return gameData;
    }
    private commands.CommandManager cmdManager;


    public void setCmdManager(commands.CommandManager cmdManager) {
        this.cmdManager = cmdManager;
    }

    /**
     * Returns the command manager instance.
     * @return CommandManager instance
     */
    public commands.CommandManager getCmdManager() {
        return cmdManager;
    }
}
