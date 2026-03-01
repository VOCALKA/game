package locations;

import characters.Player;
import items.*;
import characters.Character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
    private String id;
    private String name;
    private String description;
    private ArrayList<String> neighbors;
    public ArrayList<String> lootTable;
    private Map<String, String> exits;
    public String ambientSound;
    public List<ItemData> items = new ArrayList<>();
    public List<Character> npcs = new ArrayList<>();


    public String text;

    public Location(String id, String name) {
        this.id = id;
        this.name = name;
        this.exits = new HashMap<>();
        this.neighbors = new ArrayList<>();
        this.lootTable = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    private boolean locked = false;

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private int environmentCount;
    public int getEnvironmentCount() { return environmentCount; }
    public void setEnvironmentCount(int count) {
        this.environmentCount = count;
    }



    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", neighbors=" + neighbors +
                ", lootTable=" + lootTable +
                '}';
    }
//
    /** Returns a map of directional exits for this location. */
    public Map<String, String> getExits() {
        return exits;
    }
//
    /** Returns the textual description of the location. */
    public String getDescription() {
        return description;
    }

    /**
     * Returns an Item object for a given name if it exists in the location.
     * Uses the ItemFactory to create the item instance.
     *
     * @param itemName the name of the item to retrieve
     * @param player the player (used to access CommandManager for certain items)
     * @return the Item instance if found, otherwise null
     */
    public Item getItem(String itemName, Player player) {
        if (items == null)
            return null;

        for (ItemData data : items) {
            if (data.getName().equalsIgnoreCase(itemName)) {
                return ItemFactory.createItem(data.getId(), player.getCmdManager());
            }
        }
        return null;
    }

    /** Removes an item from the location's items list. */
    public void removeItem(Item item) {

            if (items == null) return;
            items.removeIf(data -> data.getId().equalsIgnoreCase(item.getId()));
    }

    /** Returns the ambient sound associated with this location. */
    public String getAmbientSound() {
        return ambientSound;
    }
    public List<Character> getNpcs() {
        return npcs;
    }

    /** Adds an NPC to this location if not already present. */
    public void addNpc(Character npc) {
        if (!npcs.contains(npc)) {
            npcs.add(npc);
        }
    }

    public void removeNpc(Character npc) {
        npcs.remove(npc);
    }

    /**
     * Finds an NPC in this location by name (case-insensitive).
     *
     * @param name the name of the NPC to find
     * @return the NPC instance if found, otherwise null
     */
    public characters.Character getNpcByName(String name) {
        if (this.npcs == null) {
            return null;
        }

        for (characters.Character npc : this.npcs) {

            if (npc.getName().equalsIgnoreCase(name)) {
                return npc;
            }
        }

        return null;
    }
}
